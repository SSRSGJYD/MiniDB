package minidb.basic.bplustree;

import java.io.RandomAccessFile;
import java.util.LinkedList;

import minidb.basic.bplustree.BPlusTreeConst;

/**
 *
 * Base class of tree node of B+ Tree
 *
 */

abstract class BPlusTreeNode<K extends Comparable<K>, V> {

    private int nodeType;       // actual node type
    private long pageIndex;     // node page index
    private int capacity;       // current capacity
    private boolean valid;      // valid(useful) or not
    private int valueType;      // type of value

    /**
     * constructor
     *
     * @param nodeType type of node
     * @param pageIndex index of page in the file
     */
    public BPlusTreeNode(int nodeType, long pageIndex, int valueType) {
        this.nodeType = nodeType;
        this.pageIndex = pageIndex;
        this.capacity = 0;
        this.valid = false;
        this.valueType = valueType;
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

    public boolean isValid() {
        return this.valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

}
