package minidb.basic.bplustree;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.LinkedList;
import minidb.basic.database.Row;

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

public class BPlusTreeOverflowNode<K extends Comparable<K>> extends BPlusTreeNode<K> {

    protected LinkedList<Row> valueList;
    private long prevPageIndex; // index of prev overflow page
    private long nextPageIndex; // index of next overflow page

    /**
     * constructor
     *
     */
    public BPlusTreeOverflowNode(int nodeType, long pageIndex, int valueSize, long prevPageIndex, long nextPageIndex) {
        super(nodeType, pageIndex, valueSize);
        this.prevPageIndex = prevPageIndex;
        this.nextPageIndex = nextPageIndex;
        this.valueList = new LinkedList<Row>();
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
}