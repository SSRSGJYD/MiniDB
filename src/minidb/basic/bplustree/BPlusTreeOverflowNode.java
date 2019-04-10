package minidb.basic.bplustree;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.LinkedList;
import minidb.basic.database.Row;
import minidb.basic.index.Key;
import minidb.basic.index.Value;

/**
 *
 * Class of overflow node of B+ Tree, to store overflow values in a new page
 *
 * Overflow Leaf node in file page:
 *      node type: 2 bytes(Short.SIZE)
 *      next page index: 8 bytes(Long.SIZE)
 *      prev page index: 8 bytes(Long.SIZE)
 *      capacity: 4 bytes(Int.SIZE)
 *      value: valueSize
 * layout: value1, value2, ...
 *
 */

public class BPlusTreeOverflowNode<K extends Key, V extends Value> extends BPlusTreeNode<K,V> {

    protected LinkedList<V> valueList;
    private long prevPageIndex; // index of prev overflow page
    private long nextPageIndex; // index of next overflow page

    /**
     * constructor
     *
     */
    public BPlusTreeOverflowNode(int nodeType, long pageIndex, int valueSize,  long nextPageIndex, long prevPageIndex) {
        super(nodeType, pageIndex, valueSize);
        this.prevPageIndex = prevPageIndex;
        this.nextPageIndex = nextPageIndex;
        this.valueList = new LinkedList<V>();
    }

    public long getPrevPageIndex() {
        return prevPageIndex;
    }

    public void setPrevPageIndex(long prevPageIndex) {
        this.prevPageIndex = prevPageIndex;
    }

    public long getNextPageIndex() {
        return nextPageIndex;
    }

    public void setNextPageIndex(long nextPageIndex) {
        this.nextPageIndex = nextPageIndex;
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
        fa.seek(getPageIndex());
        fa.writeShort(getNodeType());
        fa.writeLong(nextPageIndex);
        fa.writeLong(prevPageIndex);
        int capacity = getCapacity();
        fa.writeInt(capacity);
        for(int i = 0; i < capacity; i++) {
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
        return getCapacity() == 2 * overflowNodeDegree - 1;
    }

    /**
     * check if node is 'under-used'
     */
    @Override
    public boolean isSparse(int internalNodeDegree, int leafNodeDegree) {
        return getCapacity() == 0;
    }
}