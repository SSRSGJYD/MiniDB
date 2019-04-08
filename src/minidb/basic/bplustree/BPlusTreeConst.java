package minidb.basic.bplustree;

/**
 *
 * Constants of B+ Tree
 *
 */

public class BPlusTreeConst {

    // nodeType : type of node
    public static final int NODE_TYPE_INTERNAL = 1;
    public static final int NODE_TYPE_ROOT_INTERNAL = 2;
    public static final int NODE_TYPE_LEAF = 3;
    public static final int NODE_TYPE_ROOT_LEAF = 4;
    public static final int NODE_TYPE_LEAF_OVERFLOW = 5;
    public static final int NODE_TYPE_SLOT_OVERFLOW = 6;

    // search policy
    public static final int SEARCH_EXACT = 1;
    public static final int SEARCH_PREV = 2;
    public static final int SEARCH_NEXT = 3;

}
