package minidb.basic.index;

import minidb.types.TypeConst;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * class of key of primary index
 *
 */
public class PrimaryKey<K extends Comparable<K>> extends Key {

    private K key;
    private int keyType;
    private int keySize;

    public PrimaryKey(K key, int keyType, int keySize) {
        this.key = key;
        this.keyType = keyType;
        this.keySize = keySize;
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

    /**
     * compare key
     *
     * @param k real type should be PrimaryKey<K>
     * @param useAll useless for primary key
     * @return 1 for greater, 0 for equal and -1 for smaller
     */
    @Override
    public int compareTo(Key k, boolean useAll) {
        PrimaryKey<K> key = (PrimaryKey<K>)k;
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
            	fa.writeChars((String)key);
                break;
        }
    }
    
    @Override
    public void writeToBuffer(ByteBuffer buffer) {
        switch (keyType) {
            case TypeConst.VALUE_TYPE_INT:
                buffer.putInt((Integer)key);
                break;
            case TypeConst.VALUE_TYPE_LONG:
            	buffer.putLong((Long)key);
                break;
            case TypeConst.VALUE_TYPE_FLOAT:
            	buffer.putFloat((Float)key);
                break;
            case TypeConst.VALUE_TYPE_DOUBLE:
            	buffer.putDouble((Double)key);
                break;
            default:  //TypeConst.VALUE_TYPE_STRING:
            	buffer.put(((String)key).getBytes());
                break;
        }
    }
}
