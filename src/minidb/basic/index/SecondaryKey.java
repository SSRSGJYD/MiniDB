package minidb.basic.index;

import minidb.types.TypeConst;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * class of key of secondary index
 * use both attribute and primary key to ensure uniqueness
 *
 */
public class SecondaryKey<K extends Comparable<K>, PK extends Comparable<PK>> extends Key {

    private K key;              // one column of table
    private int keyType;        // type of attribute
    private int attributeSize;  // size of attribute
    private PK primaryKey;      // primary key(one column) of table
    private int PKType;         // type of primary key
    private int PKSize;         // size of primary key

    public SecondaryKey(K key, int keyType, int attributeSize,
                        PK primaryKey, int PKType, int PKSize) {
        this.key = key;
        this.keyType = keyType;
        this.attributeSize = attributeSize;
        this.primaryKey = primaryKey;
        this.PKType = PKType;
        this.PKSize = PKSize;
    }

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
		if(useAll) {
			return this.compareTo(k);
		}
		return this.key.compareTo(key.getKey());
	}

    @Override
    public void writeToFile(RandomAccessFile fa) throws IOException {
        switch (keyType) {
            case TypeConst.VALUE_TYPE_INT:
                fa.writeInt((Integer)key);
                break;
            case TypeConst.VALUE_TYPE_LONG:
                fa.writeLong((Long)key);
                break;
            case TypeConst.VALUE_TYPE_FLOAT:
                fa.writeFloat((Float)key);
                break;
            case TypeConst.VALUE_TYPE_DOUBLE:
                fa.writeDouble((Double)key);
                break;
            default:  //TypeConst.VALUE_TYPE_STRING:
                fa.writeBytes((String)key);
                for(int i = ((String) key).length(); i<attributeSize; i++) {
                    fa.writeByte(0);
                }
                break;
        }
        switch (PKType) {
            case TypeConst.VALUE_TYPE_INT:
                fa.writeInt((Integer)primaryKey);
                break;
            case TypeConst.VALUE_TYPE_LONG:
                fa.writeLong((Long)primaryKey);
                break;
            case TypeConst.VALUE_TYPE_FLOAT:
                fa.writeFloat((Float)primaryKey);
                break;
            case TypeConst.VALUE_TYPE_DOUBLE:
                fa.writeDouble((Double)primaryKey);
                break;
            default:  //TypeConst.VALUE_TYPE_STRING:
                fa.writeBytes((String)primaryKey);
                for(int i = ((String) primaryKey).length(); i<PKSize; i++) {
                    fa.writeByte(0);
                }
                break;
        }
    }
}
