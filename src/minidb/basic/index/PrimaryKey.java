package minidb.basic.index;

public class PrimaryKey<K extends Comparable<K>> extends Key {

    private K key;

    public PrimaryKey(K  key) {
        this.key = key;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    /**
     * compare key
     *
     * @param k real type should be PrimaryKey<K>
     * @return 1 for greater, 0 for equal and -1 for smaller
     */
    @Override
    public int compareTo(Key k) {
        PrimaryKey<K> key = (PrimaryKey<K>)k;
        return this.key.compareTo(key.getKey());
    }
}
