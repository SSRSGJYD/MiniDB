package minidb.basic.bplustree;

import java.util.LinkedList;

import minidb.basic.bplustree.BPlusTreeNode;

/**
 *
 * Class of overflow node of B+ Tree
 *
 * To store overflow values in a new page
 *
 */

public class BPlusTreeOverflowNode<K extends Comparable<K>,V> extends BPlusTreeNode<K,V> {

    private LinkedList<Long> keyList;
    private long prevPage; // index of prev overflow page
    private long nextPage; // index of next overflow page

    /**
     * constructor
     *
     */
    public BPlusTreeOverflowNode(int nodeType, long pageIndex, int valueType, long prevPage, long nextPage) {
        super(nodeType, pageIndex, valueType);
        this.prevPage = prevPage;
        this.nextPage = nextPage;
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
}