package minidb.basic.bplustree;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.LinkedList;

import minidb.basic.bplustree.BPlusTreeConst;

/**
 *
 * Base class of tree node of B+ Tree
 *
 */

abstract class BPlusTreeNode<K extends Comparable<K>> {

    private int nodeType;       // actual node type
    private long pageIndex;     // node page index
    private int capacity;       // current capacity
    private boolean valid;      // valid(useful) or not
    private int valueSize;      // type of value

    /**
     * constructor
     *
     * @param nodeType type of node
     * @param pageIndex index of page in the file
     */
    public BPlusTreeNode(int nodeType, long pageIndex, int valueSize) {
        this.nodeType = nodeType;
        this.pageIndex = pageIndex;
        this.capacity = 0;
        this.valid = false;
        this.valueSize = valueSize;
    }

    public long getPageIndex() {
        return this.pageIndex;
    }

    public int getNodeType() {
        return this.nodeType;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setPageIndex(long pageIndex) {
        this.pageIndex = pageIndex;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isValid() {
        return this.valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    /**
     * writes node to a page slot
     *
     * @param fa opened file descriptor of tree file
     * @throws IOException is thrown when an I/O operation fails.
     */
    public abstract void writeNode(RandomAccessFile fa) throws IOException;

}
