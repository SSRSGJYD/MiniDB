package minidb.basic.bplustree;

import java.lang.reflect.ParameterizedType;
import java.util.LinkedList;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import minidb.types.TypeConst;
import minidb.basic.database.Row;
import minidb.basic.bplustree.BPlusTreeUtils.*;
import minidb.result.SearchResult;

/**
 *
 * Generic class of B+ Tree for all value types (int, long, float, double, string)
 *
 */

public class BPlusTree<K extends Comparable<K>> {

    private int keyType;
    private int valueSize;

	private BPlusTreeNode<K> root; // root of B+ tree
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
        this.keyType = BPlusTreeUtils.getClassType(K_class);

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
                    node.keyList.add(i, (K)BPlusTreeUtils.readKeyFromFile(fa, keyType, keySize));
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
                BPlusTreeOverflowNode<K> node = createOverflowNode(index, nextptr, prevptr);
                // read in rows
                ArrayList<Row> rows = BPlusTreeUtils.readRowsFromFile(fa, valueSize, curCapacity);
                for (Row row: rows) {

                    node.valueList.add(row);
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
                    node.keyList.add(i, (K)BPlusTreeUtils.readKeyFromFile(fa, keyType, keySize));
                    node.overflowList.add(i, fa.readLong());
                    node.valueList.add(i, BPlusTreeUtils.readRowsFromFile(fa, valueSize, 1).get(0));
                }
                node.setCapacity(curCapacity);
                node.setValid(true);
                return node;
            }
            default: //BPlusTreeConst.NODE_TYPE_SLOT_OVERFLOW
            {
                long nextptr = fa.readLong();
                int curCapacity = fa.readInt();
                BPlusTreeSlotNode<K> node = createSlotNode(index, nextptr);

                for (int i = 0; i < curCapacity; i++) {
                    node.freeSlots.add(i, fa.readLong());
                }
                node.setCapacity(curCapacity);
                return node;
            }
        }
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
            writeNodeToFile(root);
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
                for(Object slot : node.freeSlots) {
                    slotPool.add((Long)slot);
                }
                index = node.getNextPageIndex();
            }
        }
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


    /**
     * search by key
     *
     * @param node node to search
     * @param key
     * @return a search result object
     * @throws IOException
     */
    public SearchResult searchByKey(BPlusTreeNode<K> node, K key) throws IOException {
        // search for the key
        int i = searchNode(node, key, BPlusTreeConst.SEARCH_EXACT, 0, node.getCapacity()-1);
        int nodeType = node.getNodeType();
        if(nodeType == BPlusTreeConst.NODE_TYPE_LEAF_OVERFLOW
                || nodeType == BPlusTreeConst.NODE_TYPE_LEAF
                || nodeType == BPlusTreeConst.NODE_TYPE_ROOT_LEAF) { // leaf node
            BPlusTreeLeafNode<K> leaf = (BPlusTreeLeafNode<K>)node;
            if(i >= 0 && i < node.getCapacity() && key == leaf.keyList.get(i)) {
                if(leaf.overflowList.get(i) == -1L ) { // no overflow node
                    return new SearchResult(); // TODO
                }
                else { // deal with overflow node
                    BPlusTreeOverflowNode<K> overflowNode = (BPlusTreeOverflowNode<K>)readNodeFromFile(leaf.overflowList.get(i));
                    LinkedList<Row> valueList = new LinkedList<Row>();
                    valueList.add(leaf.valueList.get(i));
                    int j = 0;
                    while(j < overflowNode.getCapacity()) {
                        valueList.add(overflowNode.valueList.get(j));
                        ++j;
                        if(j == overflowNode.getCapacity() && overflowNode.getNextPageIndex() != -1L) {
                            overflowNode = (BPlusTreeOverflowNode<K>)readNodeFromFile(overflowNode.getNextPageIndex());
                            j = 0;
                        }
                    }
                    return new SearchResult(); // TODO
                }
            }
            else { // key not found
                return new SearchResult(); // TODO
            }
        }
        else { // internal node
            BPlusTreeInternalNode<K> internal = (BPlusTreeInternalNode<K>)node;
            // padding to account for the last pointer (if needed)
            if(i != node.getCapacity() && key.compareTo(internal.keyList.get(i)) == 1) {
                i++;
            }
            BPlusTreeNode<K> nextToSearch = readNodeFromFile(internal.ptrList.get(i));
            return searchByKey(nextToSearch, key);
        }
    }

    /**
     * search by key in a range
     *
     * @param node node to search
     * @param key
     * @param lbound lower bound
     * @param uselbound whether use lower bound or not
     * @param hbound higher bound
     * @param usehbound whether use higher bound or not
     * @return a search result object
     * @throws IOException
     */
    public SearchResult searchByKeyWithRange(BPlusTreeNode<K> node, K key, K lbound, boolean uselbound, K hbound, boolean usehbound) throws IOException {
        // TODO
        return new SearchResult();
    }

    /**
     * search by attribute value
     *
     * @param node node to search
     * @param attributes attributes to search
     * @param attributeIndex index of attributes used for searching
     * @return a search result object
     * @throws IOException
     */
    public SearchResult searchByAttributes(BPlusTreeNode<K> node, Object[] attributes, int[] attributeIndex) throws IOException {
        // TODO
        return new SearchResult();
    }

    /**
     * to insert value into the tree
     *
     * @param key
     * @param value
     * @param unique whether allow duplicate value
     * @throws IOException
     */
    public void insert(K key, Row value, boolean unique) throws IOException {

        assert root != null;

        if(isFullNode(root)) {
            // create a new root
            BPlusTreeNode<K> childNode = this.root;
            BPlusTreeInternalNode<K> node = createInternalNode(getFreeSlot());
            node.ptrList.add(0, childNode.getPageIndex());
            this.root = node;
            // split old root node
            splitNode(node, childNode, 0);
            writeFileHeader();
            insertToNode(node, key, value, unique);
        }
        else {
            insertToNode(root, key, value, unique);
        }
    }

    /**
     * to insert key and value to a node which is not full
     *
     * @param node node to insert into
     * @param key
     * @param value
     * @param unique whether value is unique
     * @throws IOException
     */
    private void insertToNode(BPlusTreeNode<K> node, K key, Row value, boolean unique)
            throws IOException {
        boolean useChild = true;
        int i = searchNode(node, key, BPlusTreeConst.SEARCH_EXACT, 0, node.getCapacity()-1) + 1;
        // check if we have a leaf
        int nodeType = node.getNodeType();
        if(nodeType == BPlusTreeConst.NODE_TYPE_LEAF_OVERFLOW
            || nodeType == BPlusTreeConst.NODE_TYPE_LEAF
            || nodeType == BPlusTreeConst.NODE_TYPE_ROOT_LEAF) { // leaf node
            
            BPlusTreeLeafNode<K> leaf = (BPlusTreeLeafNode<K>)node;
            int j = (leaf.getCapacity() > 0 && i == 0
                    && leaf.keyList.getFirst().compareTo(key) == 1) ? i : i-1;
            if(leaf.getCapacity() > 0 && leaf.keyList.get(j) == key) { // same value already exists
                if(unique) {
                    return;
                }
                if(leaf.overflowList.get(j) < 0) { // overflow page does not exist
                    appendOverflowNode(leaf, j, value);
                }
                else { // overflow page exists
                    BPlusTreeOverflowNode<K> overflowNode =
                            (BPlusTreeOverflowNode<K>)readNodeFromFile(leaf.overflowList.get(j));
                    while(isFullNode(overflowNode)) {
                        if(overflowNode.getNextPageIndex() < 0) { // have to create overflow page
                            appendOverflowNode(overflowNode, -1, value);
                            return;
                        }
                        else { // load next overflow page
                            overflowNode = (BPlusTreeOverflowNode<K>)readNodeFromFile(overflowNode.getNextPageIndex());
                        }
                    }
                    // add value to overflow page
                    overflowNode.valueList.push(value);
                    overflowNode.increaseCapacity();
                    writeNodeToFile(overflowNode);
                }
            }
            else { // a new key
                leaf.keyList.add(i, key);
                leaf.valueList.add(i, value);
                leaf.overflowList.add(i, -1L); // create a NULL overflow pointer
                leaf.increaseCapacity();
                writeNodeToFile(leaf);
            }
        }
        else { // internal node
            // convert type
            BPlusTreeInternalNode<K> internal = (BPlusTreeInternalNode<K>)node;
            BPlusTreeNode<K> childNode = readNodeFromFile(internal.ptrList.get(i));
            BPlusTreeNode<K> nextChild = null;
            if(isFullNode(childNode)) {
                splitNode(internal, childNode, i);
                if (internal.keyList.get(i).compareTo(key) == -1) {
                    useChild = false;
                    nextChild = readNodeFromFile(internal.ptrList.get(i+1));
                }
            }
            insertToNode(useChild ? childNode : nextChild, key, value, unique);
        }
    }

    /**
     * delete by key at a node
     *
     * @param key
     * @param node
     * @param parent parent of the node
     * @param parentPointerIndex
     * @param parentKeyIndex
     * @throws IOException
     */
    public void deleteByKeyAtNode(K key, BPlusTreeNode<K> node, BPlusTreeNode<K> parent, int parentPointerIndex, int parentKeyIndex) throws IOException{
        // TODO
    }



    /**
     * delete by value
     *
     *
     * @throws IOException
     *
     */
    public void deleteByValue() throws IOException {
        // TODO
    }

    /**
     * split an internal node
     *
     * @param parent parent of the split node
     * @param child node to split
     * @param index index of key in parent node to insert new key
     * @throws IOException
     */
    private void splitNode(BPlusTreeInternalNode<K> parent, BPlusTreeNode<K> child, int index) throws IOException {
        int splitAt;
        BPlusTreeNode<K> nodeToAdd;
        K keyToAdd;
        // internal node
        if(child.getNodeType() == BPlusTreeConst.NODE_TYPE_ROOT_INTERNAL
            || child.getNodeType() == BPlusTreeConst.NODE_TYPE_INTERNAL) {
            BPlusTreeInternalNode<K> internalToAdd;
            BPlusTreeInternalNode<K> internalToSplit = (BPlusTreeInternalNode<K>)child;
            internalToAdd = createInternalNode(getFreeSlot());
            splitAt = internalNodeDegree - 1;
            // move key and pointer to new node
            int i;
            for(i = 0; i < splitAt; i++) {
                internalToAdd.keyList.add(i, internalToSplit.keyList.pop());
                internalToAdd.ptrList.add(i, internalToSplit.ptrList.pop());
            }
            internalToAdd.ptrList.add(i, internalToSplit.ptrList.pop());
            // move one key up to parent node
            keyToAdd = internalToSplit.keyList.pop();
            // update capacity
            internalToAdd.setCapacity(splitAt);
            internalToSplit.setCapacity(splitAt);
            // update node type
            internalToSplit.setNodeType(BPlusTreeConst.NODE_TYPE_INTERNAL);
            // update parent node
            parent.ptrList.add(index, internalToAdd.getPageIndex());
            parent.keyList.add(index, keyToAdd);
            parent.increaseCapacity();
            // nodeToAdd to use later
            nodeToAdd = internalToAdd;
        }
        else { // leaf node
            BPlusTreeLeafNode<K> leafToAdd, nextLeaf;
            BPlusTreeLeafNode<K> leafToSplit = (BPlusTreeLeafNode<K>)child;
            leafToAdd = createLeafNode(getFreeSlot(), leafToSplit.getNextPageIndex(), leafToSplit.getPageIndex());
            // update the prevPageIndex of the node after leafToSplit
            if(leafToSplit.getNextPageIndex() != -1) {
                nextLeaf = (BPlusTreeLeafNode<K>)readNodeFromFile(leafToSplit.getNextPageIndex());
                nextLeaf.setPrevPageIndex(leafToAdd.getPageIndex());
                writeNodeToFile(nextLeaf);
            }
            // update nextPageIndex of leafToSplit
            leafToSplit.setNextPageIndex(leafToAdd.getPageIndex());
            // move values from leafToSplit to leafToAdd
            splitAt = leafNodeDegree - 1;
            for(int i = 0; i < splitAt; i++) {
                leafToAdd.keyList.push(leafToSplit.keyList.removeLast());
                leafToAdd.valueList.push(leafToSplit.valueList.removeLast());
                leafToAdd.overflowList.push(leafToSplit.overflowList.removeLast());
                leafToAdd.increaseCapacity();
                leafToSplit.decreaseCapacity();
            }
            // update nodeType
            leafToSplit.setNodeType(BPlusTreeConst.NODE_TYPE_LEAF);
            // update parent
            parent.ptrList.add(index + 1, leafToAdd.getPageIndex());
            parent.keyList.add(index, leafToAdd.keyList.get(0));
            parent.increaseCapacity();
            // nodeToAdd to use later
            nodeToAdd = leafToAdd;
        }
        nodeToAdd.setValid(true);
        // update node info in tree file
        writeNodeToFile(nodeToAdd);
        writeNodeToFile(child);
        writeNodeToFile(parent);
        // update info in tree file
        fa.seek(treeHeaderSize-16);
        fa.writeLong(totalPageNum); // update page count
        fa.writeLong(maxPageNumber); // update max page number
    }

    /**
     * binary search a key in a tree node
     *
     * @param node node to search
     * @param key key to search
     * @param l start index of key
     * @param r end index of key
     * @param policy search policy
     * @return index of the found key or the bound
     */
    private int searchNode(BPlusTreeNode<K> node, K key, int policy, int l, int r) {
        if (l > r) { // search stop here
            switch (policy) {
                case BPlusTreeConst.SEARCH_PREV:
                    return l == 0 ? l : l - 1;
                case BPlusTreeConst.SEARCH_NEXT:
                    return (l > 0 && l == node.getCapacity()) ? l - 1 : l;
                default: //BPlusTreeConst.SEARCH_EXACT
                    return l;
            }
        }
        else {
            int mid = (l + r) / 2;
            K midKey;
            int nodeType = node.getNodeType();
            if(nodeType == BPlusTreeConst.NODE_TYPE_LEAF || nodeType == BPlusTreeConst.NODE_TYPE_ROOT_LEAF){
                midKey = ((BPlusTreeLeafNode<K>)node).keyList.get(mid);
            }
            else { // internal node
                midKey = ((BPlusTreeInternalNode<K>)node).keyList.get(mid);
            }
            int compare = midKey.compareTo(key);
            if (compare == -1) {
                return searchNode(node, key, policy, mid + 1, r);
            } else if (compare == 1) {
                return searchNode(node, key, policy, l, mid - 1);
            } else { // equal
                return mid;
            }
        }
    }

    /**
     * internal node factory
     */
    private BPlusTreeInternalNode<K> createInternalNode(long pageIndex) {
        return new BPlusTreeInternalNode<K>(BPlusTreeConst.NODE_TYPE_INTERNAL, getFreeSlot(), valueSize);
    }

    /**
     * leaf node factory
     */
    private BPlusTreeLeafNode<K> createLeafNode(long pageIndex, long nextPage, long prevPage) {
        return new BPlusTreeLeafNode<K>(BPlusTreeConst.NODE_TYPE_LEAF, getFreeSlot(), valueSize, nextPage, prevPage);
    }

    /**
     * leaf overflow node factory
     */
    private BPlusTreeOverflowNode<K> createOverflowNode(long pageIndex, long nextPage, long prevPage) {
        return new BPlusTreeOverflowNode<K>(BPlusTreeConst.NODE_TYPE_LEAF_OVERFLOW, getFreeSlot(), valueSize, nextPage, prevPage);
    }

    /**
     * slot node factory
     */
    private BPlusTreeSlotNode<K> createSlotNode(long pageIndex, long nextPage) {
        return new BPlusTreeSlotNode<K>(BPlusTreeConst.NODE_TYPE_SLOT_OVERFLOW, getFreeSlot(), valueSize, nextPage);
    }

    /**
     * append new overflow page to leaf node or overflow node
     *
     * @param node node to append at
     * @param leafIndex index of key in leaf node
     * @param value value to write into overflow node
     */
    private void appendOverflowNode(BPlusTreeNode<K> node, int leafIndex, Row value)
        throws IOException {
        BPlusTreeOverflowNode<K> newOverflowNode;
        int nodeType = node.getNodeType();
        if(nodeType == BPlusTreeConst.NODE_TYPE_ROOT_LEAF
            || nodeType == BPlusTreeConst.NODE_TYPE_LEAF) { // leaf node
            BPlusTreeLeafNode<K> leaf = (BPlusTreeLeafNode<K>)node; // convert type
            // create new overflow node and insert value
            newOverflowNode = createOverflowNode(getFreeSlot(), -1L, leaf.getPageIndex());
            newOverflowNode.valueList.push(value);
            newOverflowNode.increaseCapacity();
            leaf.overflowList.set(leafIndex, newOverflowNode.getPageIndex());
            newOverflowNode.setValid(true);
            // update node info in tree file
            writeNodeToFile(newOverflowNode);
            writeNodeToFile(leaf);
        }
        else { //BPlusTreeConst.NODE_TYPE_LEAF_OVERFLOW
            BPlusTreeOverflowNode<K> overflowNode = (BPlusTreeOverflowNode<K>)node;
            newOverflowNode = createOverflowNode(getFreeSlot(), -1L, overflowNode.getPageIndex());
            newOverflowNode.valueList.push(value);
            newOverflowNode.increaseCapacity();
            overflowNode.setNextPageIndex(newOverflowNode.getPageIndex());
            newOverflowNode.setValid(true);
            // update node info in tree file
            writeNodeToFile(newOverflowNode);
            writeNodeToFile(overflowNode);
        }
        // update info in tree file
        fa.seek(treeHeaderSize-16);
        fa.writeLong(totalPageNum); // update page count
        fa.writeLong(maxPageNumber); // update max page number
    }

    /**
     * check if node is full
     */
    private boolean isFullNode(BPlusTreeNode<K> node) {
        return node.isFull(internalNodeDegree, leafNodeDegree, overflowNodeDegree);
    }

    /**
     * check if node is 'under-used'
     */
    private boolean isSparseNode(BPlusTreeNode<K> node) {
        return node.isSparse(internalNodeDegree, leafNodeDegree);
    }

    /**
     * update node information to tree file
     *
     * @param node
     * @throws IOException
     */
    private void writeNodeToFile(BPlusTreeNode<K> node)  throws IOException {
        node.writeNode(fa, pageSize, treeHeaderSize, keyType, keySize);
        return;
    }

}
