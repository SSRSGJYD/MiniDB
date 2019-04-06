package minidb.basic.bplustree;

import java.lang.reflect.ParameterizedType;
import java.util.LinkedList;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.stream.Collectors;

import minidb.types.TypeConst;

/**
 *
 * Generic class of B+ Tree for all value types (int, long, float, double, string)
 *
 */

public class BPlusTree<K extends Comparable<K>> {

    private int keyType;
    private int valueSize;

	private BPlusTreeNode<K> root; // root of B+ tree
    private BPlusTreeNode<K> aChild;
    private RandomAccessFile fa; // file access

    private LinkedList<Long> slotPool;      // pool for free slots(for key or value)
    private LinkedList<Long> slotPagePool;  // pool for free slot page(slot node)
    private long slotPageIndex;             // index of first slotPage(slot node)
    private long totalPageNum;              // num of pages used
    private long maxPageNumber;             // max id of used page

    // size
    private int pageSize;   // page size
    private int keySize;    // key size
    private int entrySize;  // entry size

    // header size
    private int treeHeaderSize;
    private int internalNodeHeaderSize;
    private int leafNodeHeaderSize;
    private int slotNodeHeaderSize;

    // node degree
    private int internalNodeDegree;
    private int leafNodeDegree;
    private int overflowNodeDegree;
    private int slotNodeDegree;

    // for conditioning
    private int deleteCount;          // count for delete operation
    private int conditionThreshold;   // iterations to perform conditioning

    /**
     * constructor
     *
     * @param pageSize size of one page(node)
     * @throws IOException
     */
	public BPlusTree(int pageSize, int keySize, int valueSize, int conditionThreshold, String path)
            throws IOException {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        Class K_class = (Class<K>) pt.getActualTypeArguments()[0];
        this.keyType = getClassType(K_class);

        this.pageSize = pageSize;
        this.keySize = (this.keyType < TypeConst.VALUE_TYPE_STRING)? TypeConst.VALUE_SIZE[this.keyType]:keySize;
        this.valueSize = valueSize;
        this.entrySize = 20;

        this.treeHeaderSize = (4 * Integer.SIZE + 4 * Long.SIZE) / 8;
        this.internalNodeHeaderSize = (Short.SIZE + Integer.SIZE) / 8;
        this.leafNodeHeaderSize = (Short.SIZE + 2 * Long.SIZE + Integer.SIZE) / 8;
        this.slotNodeHeaderSize = 14;

        this.internalNodeDegree = calculateDegree(2 * this.keySize, internalNodeHeaderSize);
        this.leafNodeDegree = calculateDegree(2 * this.keySize + entrySize, leafNodeHeaderSize);
        this.overflowNodeDegree = calculateDegree(entrySize, leafNodeHeaderSize);
        this.slotNodeDegree = calculateDegree(this.keySize, slotNodeHeaderSize);

        this.slotPool = new LinkedList<Long>();
        this.slotPagePool = new LinkedList<Long>();
        this.slotPageIndex = -1L; // no extra slot page
        this.totalPageNum = 0L;
        this.maxPageNumber = 0L;
        this.deleteCount = 0;
        this.conditionThreshold = conditionThreshold;

        File f = new File(path);
        this.fa = new RandomAccessFile(path, "rw");
        if(f.exists()) {
            System.out.println("File already exists, size: " + fa.length() + " bytes");
            readHeaderFromFile(fa);
            initializeSlotPage(true);
            System.out.println("Tree file loaded");
        }
        else {
            System.out.println("Creating new tree file");
            fa.setLength(0);
            initializeSlotPage(false);
            createTree();
            writeFileHeader();
            System.out.println("Tree file created");
        }
    }

    /**
     * Reads an existing file and generates a B+ configuration based on the stored values
     *
     * @param fa file to read from
     * @throws IOException
     */
    private void readHeaderFromFile(RandomAccessFile fa)
            throws IOException {
        fa.seek(0L);

        int headerNumber = fa.readInt();
        this.pageSize = fa.readInt();
        this.entrySize = fa.readInt();
        this.keySize = fa.readInt();
        this.totalPageNum = fa.readLong();
        this.maxPageNumber = fa.readLong();

        long rootIndex = fa.readLong();
        this.slotPageIndex = fa.readLong();
        this.root = readNodeFromFile(rootIndex);
    }

    /**
     * Write file header into new tree file
     *
     * @throws IOException
     */
    private void writeFileHeader() throws IOException {
        fa.seek(0L);
        fa.writeInt(treeHeaderSize);
        fa.writeInt(pageSize);
        fa.writeInt(entrySize);
        fa.writeInt(keySize);
        fa.writeLong(totalPageNum);
        fa.writeLong(maxPageNumber);
        fa.writeLong(root.getPageIndex());
        fa.writeLong(slotPageIndex);
    }

    /**
     * Read a tree node from tree file according to its index
     *
     * @param index index of the page in the file
     * @return a BPlusTreeNode<K,V> object
     * @throws IOException
     */
    private BPlusTreeNode<K> readNodeFromFile(long index) throws IOException {
        if(index < 0) {
            return(null);
        }
        fa.seek(index);
        int nodeType = (int)fa.readShort();

        switch (nodeType) {
            case BPlusTreeConst.NODE_TYPE_INTERNAL:
            case BPlusTreeConst.NODE_TYPE_ROOT_INTERNAL: {
                BPlusTreeInternalNode<K> node = new BPlusTreeInternalNode<K>(nodeType, index, valueSize);
                int curCapacity = fa.readInt();
                for (int i = 0; i < curCapacity; i++) {
                    node.keyList.add(i, (K)readKeyFromFile(keyType, keySize));
                    node.ptrList.add(i, fa.readLong());
                }
                node.ptrList.add(curCapacity, fa.readLong());
                node.setCapacity(curCapacity);
                node.setValid(true);
                return node;
            }
            case BPlusTreeConst.NODE_TYPE_LEAF_OVERFLOW: {
                long nextptr = fa.readLong();
                long prevptr = fa.readLong();
                int curCapacity = fa.readInt();
                BPlusTreeOverflowNode<K> node = new BPlusTreeOverflowNode<K>(nodeType, index, valueSize, nextptr, prevptr);

                // read entries
                for (int i = 0; i < curCapacity; i++) {
                    Row value = new Row();
                    // TODO: design row data format and read in row data
                    node.valueList.add(i, value);
                }
                node.setCapacity(curCapacity);
                return node;
            }
            case BPlusTreeConst.NODE_TYPE_LEAF:
            case BPlusTreeConst.NODE_TYPE_ROOT_LEAF: {
                long nextptr = fa.readLong();
                long prevptr = fa.readLong();
                int curCapacity = fa.readInt();
                BPlusTreeLeafNode<K> node = new BPlusTreeLeafNode<K>(nodeType, index, valueSize, nextptr, prevptr);

                for (int i = 0; i < curCapacity; i++) {
                    node.keyList.add(i, (K)readKeyFromFile(keyType, keySize));
                    node.overflowList.add(i, fa.readLong());
                    Row value = new Row();
                    // TODO: design row data format and read in row data
                    node.valueList.add(i, value);
                }
                node.setCapacity(curCapacity);
                node.setValid(true);
                return node;
            }
            default: //BPlusTreeConst.NODE_TYPE_SLOT_OVERFLOW
            {
                long nextptr = fa.readLong();
                int curCapacity = fa.readInt();
                BPlusTreeSlotNode<K> node = new BPlusTreeSlotNode<K>(nodeType, index, valueSize, nextptr);

                for (int i = 0; i < curCapacity; i++) {
                    node.freeSlots.add(i, fa.readLong());
                }
                node.setCapacity(curCapacity);
                return node;
            }
        }
    }

    private Object readKeyFromFile(int keyType, int keySize) throws IOException {
        switch (keyType) {
            case TypeConst.VALUE_TYPE_INT:
                return fa.readInt();
            case TypeConst.VALUE_SIZE_LONG:
                return fa.readLong();
            case TypeConst.VALUE_TYPE_FLOAT:
                return fa.readFloat();
            case TypeConst.VALUE_TYPE_DOUBLE:
                return fa.readDouble();
            default:  //TypeConst.VALUE_TYPE_STRING:
                byte[] tmp = new byte[keySize+1];
                fa.read(tmp,0, keySize);
                return new String(tmp);
        }
    }

    private Object readValueFromFile() throws IOException {
        Row value = new Row();
        // TODO: read in row from file
        return value;
    }

    /**
     * Function that initially creates the tree. Here we always
     * create a Leaf that acts as our Root, until we split it.
     * @return tree root.
     * @throws IOException
     */
    private BPlusTreeNode<K> createTree() throws IOException {
        if(root == null) {
            root = new BPlusTreeLeafNode<K>(BPlusTreeConst.NODE_TYPE_ROOT_LEAF, getFreeSlot(), valueSize, -1, -1);
            root.writeNode(fa);
        }
        return root;
    }

    /**
     * to initialize slot nodes / pages
     * read in from tree file; if not exist, create one
     *
     * @param exists flag to indicate if the file already exists
     * @throws IOException
     */
    private void initializeSlotPage(boolean exists) throws IOException {
        fa.seek(treeHeaderSize);
        int slotPageElemNum = (pageSize-slotNodeHeaderSize) / keySize;
        if(!exists) {
            for (int i = 0; i < slotPageElemNum; i++) {
                fa.writeLong(-1); // null ptr(index)
            }
        }
        else {
            long val;
            for (int i = 0; i < slotPageElemNum; i++) {
                if ((val = fa.readLong()) == -1L) {
                    break;
                }
                slotPool.add(val);
            }

            // check if we have more pages
            long index = slotPageIndex;
            BPlusTreeSlotNode node;
            while (index != -1L) {
                slotPool.add(index);
                node = (BPlusTreeSlotNode)readNodeFromFile(index);
                //Iterator it = lpOvf.freeSlots.iterator();
//                for(slot:lpOvf.freeSlots) {
//                    slotPool.add(slot);
//                }
                slotPool.addAll(node.freeSlots.stream().collect(Collectors.toList()));
                index = node.getNextPage();
            }
        }
    }

    /**
     * get the const defined in TypeConst of the class
     *
     * @param cls class
     * @return TypeConst value
     */
    public int getClassType(Class cls) {
        String cls_name = cls.getName();
        if (cls_name.equals(Integer.class.getName())) {
            return TypeConst.VALUE_TYPE_INT;
        }
        if (cls_name.equals(Long.class.getName())) {
            return TypeConst.VALUE_TYPE_LONG;
        }
        if (cls_name.equals(Float.class.getName())) {
            return TypeConst.VALUE_TYPE_FLOAT;
        }
        if (cls_name.equals(Double.class.getName())) {
            return TypeConst.VALUE_TYPE_DOUBLE;
        }
        if (cls_name.equals(String.class.getName())) {
            return TypeConst.VALUE_TYPE_STRING;
        } else {
            System.out.println(String.format("not support type %s", cls_name));
        }
        return -1;
    }

    /**
     * calculates the degree of a node (internal node or leaf node)
     *
     * @param elementSize node element size
     * @param elementHeaderSize node header size
     * @return node degree
     */
    private int calculateDegree(int elementSize, int elementHeaderSize) {
        return((int)((pageSize - elementHeaderSize)/(2.0 * elementSize)));
    }

    /**
     * find an available index for a page
     *
     * @return page index
     */
    private long getFreeSlot() {
        long index;
        if(slotPool.size() > 0) {
            index = slotPool.pop();
            totalPageNum++;
            return index;
        }
        else {
            if (maxPageNumber <= totalPageNum) {
                maxPageNumber++;
            }
            totalPageNum++;
            index = pageSize * (maxPageNumber + 1);
            return index;
        }
    }

}
