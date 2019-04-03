package minidb.basic.bplustree;

import java.io.RandomAccessFile;

import minidb.basic.bplustree.BPlusTreeConfig;
import minidb.basic.bplustree.BPlusTreeNode;

/**
 *
 * Generic class of B+ Tree for all value types (int, long, float, double, string)
 *
 */

public class BPlusTree<K extends Comparable<K>, V> {

	private BPlusTreeNode<K,V> root; // root of B+ tree
    private BPlusTreeNode<K,V> aChild;
    private BPlusTreeConfig config; // config of B+ tree
    private RandomAccessFile fa; // file access
    
	public BPlusTree() {
		// TODO

	}

}
