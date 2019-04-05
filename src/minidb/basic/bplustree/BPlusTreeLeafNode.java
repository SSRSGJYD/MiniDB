package minidb.basic.bplustree;

import java.util.LinkedList;

import minidb.basic.bplustree.BPlusTreeNode;
import minidb.basic.Row;

/**
 *
 * Class of leaf node of B+ Tree
 *
 * To store (key,value) in a page
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
}