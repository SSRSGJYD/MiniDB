package minidb.basic.index;

import minidb.basic.bplustree.BPlusTree;
import minidb.basic.database.Row;


/**
 * class of primary index
 *
 */
public class PrimaryIndex<K extends Comparable<K>> {

    private BPlusTree<K, Row> tree;

    public PrimaryIndex() {

    }

}
