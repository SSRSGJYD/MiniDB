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

public class BPlusTreeInternalNode<K extends Comparable<K>> extends BPlusTreeNode<K> {

    protected LinkedList<K> keyList;
    protected LinkedList<Long> ptrList; // list of pointers to child nodes

    /**
     * constructor
     *
     */
    public BPlusTreeInternalNode(int nodeType, long pageIndex, int valueSize) {
        super(nodeType, pageIndex, valueSize);
        keyList = new LinkedList<K>();
        ptrList = new LinkedList<Long>();
    }


}
