package minidb.basic.bplustree;

import minidb.basic.bplustree.BPlusTreeNode;

import java.util.LinkedList;

public class BPlusTreeSlotNode<K extends Comparable<K>> extends BPlusTreeNode<K> {

    protected long nextPage;
    protected LinkedList<Long> freeSlots;

    public BPlusTreeSlotNode(int nodeType, long pageIndex, int valueSize, long nextPage) {
        super(nodeType, pageIndex, valueSize);
        this.nextPage = nextPage;
        this.freeSlots = new LinkedList<Long>();
    }

    public long getNextPage() {
        return nextPage;
    }

    public void setNextPage(long nextPage) {
        this.nextPage = nextPage;
    }
}
