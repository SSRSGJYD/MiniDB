package minidb.basic.bplustree;

/**
 *
 * Configuration of B+ Tree, including all params
 *
 */

public class BPlusTreeConfig {

    private int pageSize;   // page size
    private int valueType;  // type of value
    private int keySize;    // key size, Long.Size

    // header size
    private int internalNodeHeaderSize;
    private int leafNodeHeaderSize;

    // node degree
    private int internalNodeDegree;
    private int leafNodeDegree;


    public BPlusTreeConfig() {
        // TODO
    }


}
