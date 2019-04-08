package minidb.basic.bplustree;

import minidb.basic.bplustree.BPlusTreeNode;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.LinkedList;


/**
 *
 * Class of slot node of B+ Tree, to store index of slots
 *
 * Overflow Leaf node in file page:
 *      node type: 2 bytes(Short.SIZE)
 *      next page index: 8 bytes(Long.SIZE)
 *      capacity: 4 bytes(Int.SIZE)
 *      slot index: 8 bytes(Long.SIZE)
 * layout: slot1, slot2, ...
 *
 */
public class BPlusTreeSlotNode<K extends Comparable<K>> extends BPlusTreeNode<K> {

    protected long nextPageIndex;
    protected LinkedList<Long> freeSlots;

    public BPlusTreeSlotNode(int nodeType, long pageIndex, int valueSize, long nextPageIndex) {
        super(nodeType, pageIndex, valueSize);
        this.nextPageIndex = nextPageIndex;
        this.freeSlots = new LinkedList<Long>();
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
        int capacity = getCapacity();
        fa.writeInt(capacity);
        for(int i = 0; i < capacity; i++) {
            fa.writeLong(freeSlots.get(i));
        }
    }

    /**
     * invalid for slot node
     */
    @Override
    public boolean isFull(int internalNodeDegree, int leafNodeDegree, int overflowNodeDegree) {
        return false;
    }

    /**
     * invalid for slot node
     */
    @Override
    public boolean isSparse(int internalNodeDegree, int leafNodeDegree) {
        return false;
    }

}
