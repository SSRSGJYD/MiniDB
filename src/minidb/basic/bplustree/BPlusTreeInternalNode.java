package minidb.basic.bplustree;

import java.util.LinkedList;

import minidb.basic.bplustree.BPlusTreeNode;


/**
 *
 * Class of internal node of B+ Tree
 *
 * To Store keys in a page
 *
 */

public class BPlusTreeInternalNode<K extends Comparable<K>,V> extends BPlusTreeNode<K,V> {

    private LinkedList<K> keyList;
    private LinkedList<Long> ptrList; // list of pointers to child nodes

    /**
     * constructor
     *
     */
    public BPlusTreeInternalNode(int nodeType, long pageIndex, int valueType) {
        super(nodeType, pageIndex, valueType);
        keyList = new LinkedList<K>();
        ptrList = new LinkedList<Long>();
    }
}
