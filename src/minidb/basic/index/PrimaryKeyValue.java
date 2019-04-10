package minidb.basic.index;

/**
 * a wrapper class for primary key as Value; stored in B+ tree leaf of secondary index
 *
 */
public class PrimaryKeyValue<K extends Comparable<K>> extends Value {

    private K key;

    public PrimaryKeyValue(K key) {
        this.key = key;
    }

    public PrimaryKeyValue(byte[] fileContent) {

    }
}
