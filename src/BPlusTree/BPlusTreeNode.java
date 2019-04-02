package BPlusTree;

import java.io.RandomAccessFile;
import java.util.LinkedList;

import BPlusTree.BPlusTreeConst;

/**
 *
 * Base class of tree node of B+ Tree
 *
 */

public class BPlusTreeNode<T> {
    //final LinkedList<Long> keyArray;  // key array
    private int nodeType;             // actual node type
    private long pageIndex;           // node page index
    private int capacity;             // current capacity

    public BPlusTreeNode() {
        //TODO
    }

}
