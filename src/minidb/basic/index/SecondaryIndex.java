package minidb.basic.index;

import minidb.basic.bplustree.BPlusTree;
import minidb.basic.database.Row;
import minidb.basic.index.Value;
import minidb.result.DeleteResult;
import minidb.result.SearchResult;
import minidb.basic.index.SecondaryKey;

import java.io.IOException;

/**
 * class of secondary index
 *
 */
public class SecondaryIndex<K extends Comparable<K>, PK extends Comparable<PK>> {

    private BPlusTree<SecondaryKey<K,PK>, PrimaryKeyValue> tree;

    /**
     * constructor
     *
     * @param pageSize size of one page(node)
     * @param keySize size of key
     * @param valueSize size of value stored
     * @param conditionThreshold threshold of re-organize tree
     * @param path file path of tree file
     * @throws IOException
     */
    public SecondaryIndex(int pageSize, int keySize, int valueSize, int conditionThreshold, String path)
            throws IOException {
        this.tree = new BPlusTree<SecondaryKey<K,PK>, PrimaryKeyValue>(pageSize,keySize,valueSize,conditionThreshold,path);
    }

    /**
     * insert into index
     *
     * @param key key
     * @param value value(a row)
     * @throws IOException
     */
    public void insert(SecondaryKey<K,PK> key, PrimaryKeyValue value) throws IOException {
        tree.insert(key, value);
    }

    /**
     * search by key
     *
     * @param key key
     * @param useAll whether compare using all keys or just non-primary attribute
     * @return a SearchResult Object
     * @throws IOException
     */
    public SearchResult search(SecondaryKey<K,PK> key, boolean useAll) throws IOException {
        return tree.searchByKey(key, useAll);
    }

    /**
     * search by key in a range
     *
     * @param lbound lower bound
     * @param uselbound whether use lower bound or not
     * @param hbound higher bound
     * @param usehbound whether use higher bound or not
     * @param useAll whether compare using all keys or just non-primary attribute
     * @return a SearchResult Object
     * @throws IOException
     */
    public SearchResult searchByRange(SecondaryKey<K,PK> lbound, boolean uselbound, SecondaryKey<K,PK> hbound, boolean usehbound, boolean useAll)
            throws IOException {
        assert uselbound || usehbound;
        return tree.searchByKeyWithRange(lbound, uselbound, hbound, usehbound, useAll);
    }

    /**
     * search all values
     *
     * @return a SearchResult Object
     * @throws IOException
     */
    public SearchResult searchAll() throws IOException {
        return tree.searchAll();
    }

    /**
     * delete a (key,value) pair
     *
     * @param key key
     * @return a DeleteResult object
     * @throws IOException
     */
    public DeleteResult delete(SecondaryKey<K,PK> key) throws IOException {
        return tree.deleteByKey(key);
    }

//    /**
//     * update one value given key; if no such key, do nothing
//     *
//     * @param key key
//     * @param value new value
//     * @throws IOException
//     */
//    public void update(SecondaryKey<K,PK> key, PrimaryKeyValue value) throws IOException {
//        tree.update(key, value);
//    }
}
