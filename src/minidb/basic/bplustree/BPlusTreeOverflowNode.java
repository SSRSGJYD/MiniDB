package minidb.basic.bplustree;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.LinkedList;
import minidb.basic.database.Row;

/**
 *
 * Class of overflow node of B+ Tree
 *
 * To store overflow values in a new page
 *
 */

public class BPlusTreeOverflowNode<K extends Comparable<K>> extends BPlusTreeNode<K> {

    protected LinkedList<Row> valueList;
    private long prevPage; // index of prev overflow page
    private long nextPage; // index of next overflow page

    /**
     * constructor
     *
     */
    public BPlusTreeOverflowNode(int nodeType, long pageIndex, int valueSize, long prevPage, long nextPage) {
        super(nodeType, pageIndex, valueSize);
        this.prevPage = prevPage;
        this.nextPage = nextPage;
        this.valueList = new LinkedList<Row>();
    }

    public long getPrevPage() {
        return prevPage;
    }

    public void setPrevPage(long prevPage) {
        this.prevPage = prevPage;
    }

    public long getNextPage() {
        return nextPage;
    }

    public void setNextPage(long nextPage) {
        this.nextPage = nextPage;
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

    }
}