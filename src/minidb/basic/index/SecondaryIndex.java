package minidb.basic.index;

import minidb.basic.bplustree.BPlusTree;
import minidb.basic.database.RowObject;

/**
 * class of secondary index
 *
 *
 */
public class SecondaryIndex<K extends Comparable<K>> {

    private BPlusTree<K, RowObject> tree;

    public SecondaryIndex() {

    }
}
