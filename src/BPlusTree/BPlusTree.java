package BPlusTree;

import java.io.RandomAccessFile;
import java.util.LinkedList;

import BPlusTree.BPlusTreeConfig;
import BPlusTree.BPlusTreeNode;

/**
 *
 * Generic class of B+ Tree for all value types (int, long, float, double, string)
 *
 */

public class BPlusTree<T> {

	private BPlusTreeConfig root; // root of B+ tree
    private BPlusTreeNode aChild; // first child
    private BPlusTreeConfig config; // config of B+ tree
    private RandomAccessFile fa; // file access
    
	public BPlusTree() {
		// TODO

	}

}
