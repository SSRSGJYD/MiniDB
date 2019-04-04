package minidb.basic.bplustree;

import java.util.LinkedList;

import minidb.basic.bplustree.BPlusTreeNode;

/**
 *
 * Class of leaf node of B+ Tree
 *
 * To store (key,value) in a page
 *
 */

public class BPlusTreeLeafNode<K extends Comparable<K>, V> extends BPlusTreeNode<K, V> {

    private long nextPageIndex;
    private long prevPageIndex;
    private LinkedList<K> keyList;
    private LinkedList<V> valueList;
    private LinkedList<Long> overflowList;  // indexes of overflow pages

    /**
     * constructor
     *
     */
    public BPlusTreeLeafNode(int nodeType, long pageIndex, int valueType, long nextPageIndex, long prevPageIndex) {
        super(nodeType, pageIndex, valueType);
        this.nextPageIndex = nextPageIndex;
        this.prevPageIndex = prevPageIndex;
        this.keyList = new LinkedList<K>();
        this.valueList = new LinkedList<V>();
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