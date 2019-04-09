package minidb.basic.bplustree;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.LinkedList;

import minidb.basic.database.Row;

/**
 *
 * Class of leaf node of B+ Tree
 *
 * Leaf node in file page:
 *      node type: 2 bytes(Short.SIZE)
 *      next page index: 8 bytes(Long.SIZE)
 *      prev page index: 8 bytes(Long.SIZE)
 *      capacity: 4 bytes(Int.SIZE)
 *      key: keySize
 *      overflow node index:8 bytes(Long.SIZE)
 *      value: valueSize
 * layout: (key, overflow node index, value) ...
 *
 */

public class BPlusTreeLeafNode<K extends Comparable<K>> extends BPlusTreeNode<K> {

    private long nextPageIndex;
    private long prevPageIndex;
    protected LinkedList<K> keyList;
    protected LinkedList<Row> valueList;
    protected LinkedList<Long> overflowList;  // indexes of overflow pages

    /**
     * constructor
     *
     */
    public BPlusTreeLeafNode(int nodeType, long pageIndex, int valueSize, long nextPageIndex, long prevPageIndex) {
        super(nodeType, pageIndex, valueSize);
        this.nextPageIndex = nextPageIndex;
        this.prevPageIndex = prevPageIndex;
        this.keyList = new LinkedList<K>();
        this.valueList = new LinkedList<Row>();
        this.overflowList = new LinkedList<Long>();
    }

    public long getNextPageIndex() {
        return nextPageIndex;
    }

    public void setNextPageIndex(long nextPageIndex) {
        this.nextPageIndex = nextPageIndex;
    }

    public long getPrevPageIndex() {
        return prevPageIndex;
    }

    public void setPrevPageIndex(long prevPageIndex) {
        this.prevPageIndex = prevPageIndex;
    }

    /**
     *  write node to tree file
     *
     * @param fa file descriptor
     * @param pageSize
     * @param headerSize
     * @param keyType
     * @param keySize
     * @throws IOException
     */
    public void writeNode(RandomAccessFile fa, int pageSize, int headerSize, int keyType, int keySize)
            throws IOException {
        if(this.getNodeType() == BPlusTreeConst.NODE_TYPE_ROOT_INTERNAL ||
                this.getNodeType() == BPlusTreeConst.NODE_TYPE_ROOT_LEAF) {
            fa.seek(headerSize-8);
            fa.writeLong(getPageIndex());
        }
        fa.seek(getPageIndex());
        fa.writeShort(getNodeType());
        fa.writeLong(nextPageIndex);
        fa.writeLong(prevPageIndex);
        int capacity = getCapacity();
        fa.writeInt(capacity);
        for(int i = 0; i < capacity; i++) {
            BPlusTreeUtils.writeKeyToFile(fa, keyList.get(i), keyType, keySize);
            fa.writeLong(overflowList.get(i));
            BPlusTreeUtils.writeRowToFile(fa, valueList.get(i));
        }

        if(fa.length() < getPageIndex() + pageSize) {
            fa.setLength(getPageIndex() + pageSize);
        }
    }

    /**
     * check if node is full
     */
    @Override
    public boolean isFull(int internalNodeDegree, int leafNodeDegree, int overflowNodeDegree) {
        return getCapacity() == 2 * leafNodeDegree - 1;
    }

    /**
     * check if node is 'under-used'
     */
    @Override
    public boolean isSparse(int internalNodeDegree, int leafNodeDegree) {
        if(getNodeType() == BPlusTreeConst.NODE_TYPE_ROOT_LEAF) {
            return getCapacity() <= 1;
        }
        else {
            return getCapacity() < leafNodeDegree;
        }
    }
}