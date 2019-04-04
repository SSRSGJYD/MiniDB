package minidb.basic.bplustree;

import minidb.basic.bplustree.BPlusTreeNode;

public class BPlusTreeSlotNode<K extends Comparable<K>,V> extends BPlusTreeNode<K,V> {

    private long nextPage;
    private long prevPage;

    public BPlusTreeSlotNode(int nodeType, long pageIndex, int valueType, long nextPage, long prevPage) {
        super(nodeType, pageIndex, valueType);
        this.nextPage = nextPage;
        this.prevPage = prevPage;
    }
}
