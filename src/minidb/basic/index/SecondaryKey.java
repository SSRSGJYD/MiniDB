package minidb.basic.index;


/**
 * class of key of secondary index
 * use both attribute and primary key to ensure uniqueness
 *
 */
public class SecondaryKey<K extends Comparable<K>, PK extends Comparable<PK>> extends Key {

    private K key;          // one column of table
    private PK primaryKey;  // primary key(one column) of table

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public PK getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(PK primaryKey) {
        this.primaryKey = primaryKey;
    }

    public SecondaryKey(K key, PK primaryKey) {
        this.key = key;
        this.primaryKey = primaryKey;
    }

    /**
     * compare use key first and primary key last
     *
     * @param k real type should be SecondaryKey<K, PK>
     * @return 1 for greater, 0 for equal and -1 for smaller
     */
    @Override
    public int compareTo(Key k) {
        SecondaryKey<K, PK> key = (SecondaryKey<K, PK>)k;
        int keyCompare = this.key.compareTo(key.getKey());
        if(keyCompare != 0)
            return keyCompare;
        else
            return this.primaryKey.compareTo(key.getPrimaryKey());
    }

    /**
     *  compare between secondary key
     *
     * @param k real type should be SecondaryKey<K, PK>
     * @param useAll whether compare using all keys or just non-primary attribute
     * @return 1 for greater, 0 for equal and -1 for smaller
     */
    public int compareTo(Key k, boolean useAll) {
        SecondaryKey<K, PK> key = (SecondaryKey<K, PK>)k;
        return this.key.compareTo(key.getKey());
    }
}
