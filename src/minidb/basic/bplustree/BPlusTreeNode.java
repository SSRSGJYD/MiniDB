package minidb.basic.bplustree;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.LinkedList;

import minidb.basic.bplustree.BPlusTreeConst;
import minidb.basic.index.Key;
import minidb.basic.index.Value;

/**
 *
 * Base class of tree node of B+ Tree
 *
 */

abstract class BPlusTreeNode<K extends Key, V extends Value> {

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

    public void setNodeType(int nodeType) { this.nodeType = nodeType; }

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
     *  write node to tree file
     *
     * @param fa file descriptor
     * @param pageSize
     * @param headerSize
     * @param keyType
     * @param keySize
     * @throws IOException
     */
    public abstract void writeNode(RandomAccessFile fa, int pageSize, int headerSize, int keyType, int keySize)
            throws IOException;

    /**
     * check if node is full
     */
    public abstract boolean isFull(int internalNodeDegree, int leafNodeDegree, int overflowNodeDegree);

    /**
     * check if node is 'under-used'
     */
    public abstract boolean isSparse(int internalNodeDegree, int leafNodeDegree);

    /**
     * increase the node capacity
     */
    public void increaseCapacity()  {
        capacity++;
    }

    /**
     * decrease the node capacity
     */
    public void decreaseCapacity() {
        capacity--;
    }

}
