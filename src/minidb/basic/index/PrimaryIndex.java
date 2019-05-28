package minidb.basic.index;

import minidb.basic.bplustree.BPlusTree;
import minidb.basic.bplustree.BPlusTreeUtils;
import minidb.basic.database.Row;
import minidb.result.DeleteResult;
import minidb.result.SearchResult;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;


/**
 * class of primary index
 *
 */
public class PrimaryIndex<K extends Comparable<K>> {

    private BPlusTree<PrimaryKey<K>, Row> tree;

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
    public PrimaryIndex(int pageSize, int keyType, int keySize, int valueSize, int conditionThreshold, String path)
        throws IOException {
        this.tree = new BPlusTree<PrimaryKey<K>,Row>(pageSize,true,keySize, keyType,keySize,0,0,valueSize,conditionThreshold,path);
    }

    /**
     * insert into index
     *
     * @param key key
     * @param value value(a row)
     * @throws IOException
     */
    public void insert(PrimaryKey<K> key, Row value) throws IOException {
        tree.insert(key, value);
    }

    /**
     * search by key
     *
     * @param key key
     * @return a SearchResult Object
     * @throws IOException
     */
    public SearchResult<Row> search(PrimaryKey<K> key) throws IOException {
        return tree.searchByKey(key, true);
    }

    /**
     * search by key in a range
     *
     * @param lbound lower bound
     * @param uselbound whether use lower bound or not
     * @param lstrict whether lower bound is strict
     * @param hbound higher bound
     * @param usehbound whether use higher bound or not
     * @param hstrict whether higher bound is strict
     * @return a SearchResult Object
     * @throws IOException
     */
    public SearchResult<Row> searchByRange(PrimaryKey<K> lbound, boolean uselbound, boolean lstrict, PrimaryKey<K> hbound, boolean usehbound, boolean hstrict)
        throws IOException {
        assert uselbound || usehbound;
        return tree.searchByKeyWithRange(lbound, uselbound, lstrict, hbound, usehbound, hstrict, true);
    }

    /**
     * search all values
     *
     * @return a SearchResult Object
     * @throws IOException
     */
    public SearchResult<Row> searchAll() throws IOException {
        return (SearchResult<Row>)tree.searchAll();
    }
    
    /**
     * search except specific key
     *
     * @return a SearchResult Object
     * @throws IOException
     */
    public SearchResult<Row> searchNotEqual(PrimaryKey<K> key) throws IOException {
        return (SearchResult<Row>)tree.searchNotEqual(key);
    }

    /**
     * delete a (key,value) pair
     *
     * @param key key
     * @return a DeleteResult object
     * @throws IOException
     */
    public DeleteResult delete(PrimaryKey<K> key) throws IOException {
        return tree.deleteByKey(key);
    }

    /**
     * update one value given key; if no such key, do nothing
     *
     * @param key key
     * @param value new value
     * @throws IOException
     */
    public void update(PrimaryKey<K> key, Row value) throws IOException {
        tree.update(key, value);
    }

}
