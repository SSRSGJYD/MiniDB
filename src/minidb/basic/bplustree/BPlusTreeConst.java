package minidb.basic.bplustree;

/**
 *
 * Constants of B+ Tree
 *
 */

public class BPlusTreeConst {

    // nodeType : type of node
    int NODE_TYPE_LEAF = 1;
    int NODE_TYPE_INTERNAL_NODE = 2;
    int NODE_TYPE_ROOT_INTERNAL = 3;
    int NODE_TYPE_ROOT_LEAF = 4;
    int NODE_TYPE_LEAF_OVERFLOW = 5;
    int NODE_TYPE_LOOKUP_OVERFLOW = 6;

    // valueType : type of value stored
    int VALUE_TYPE_INT = 1;
    int VALUE_TYPE_LONG = 2;
    int VALUE_TYPE_FLOAT = 3;
    int VALUE_TYPE_DOUBLE = 4;
    int VALUE_TYPE_STRING = 5;

}
