package minidb.basic.bplustree;

import minidb.basic.database.Row;
import minidb.types.TypeConst;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 * Util class for B+ tree
 *
 *
 */
public class BPlusTreeUtils {

    /**
     * read in a key from file
     *
     * @param fa file access
     * @param keyType type of key
     * @param keySize size of key
     * @return key as an object
     * @throws IOException
     */
    public static Object readKeyFromFile(RandomAccessFile fa, int keyType, int keySize) throws IOException {
        switch (keyType) {
            case TypeConst.VALUE_TYPE_INT:
                return fa.readInt();
            case TypeConst.VALUE_SIZE_LONG:
                return fa.readLong();
            case TypeConst.VALUE_TYPE_FLOAT:
                return fa.readFloat();
            case TypeConst.VALUE_TYPE_DOUBLE:
                return fa.readDouble();
            default:  //TypeConst.VALUE_TYPE_STRING:
                byte[] tmp = new byte[keySize+1];
                fa.read(tmp,0, keySize);
                return new String(tmp);
        }
    }

    /**
     * read in a key from file
     *
     * @param fa file access
     * @param key key to write
     * @param keyType type of key
     * @param keySize size of key
     * @throws IOException
     */
    public static void writeKeyToFile(RandomAccessFile fa, Object key, int keyType, int keySize) throws IOException {
        switch (keyType) {
            case TypeConst.VALUE_TYPE_INT:
                fa.writeInt((Integer)key);
                break;
            case TypeConst.VALUE_SIZE_LONG:
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
                for(int i = ((String) key).length(); i<keySize; i++) {
                    fa.writeByte(0);
                }
                break;
        }
    }

    /**
     * read in rows(values) from tree file
     *
     * @param fa file access
     * @param valueSize size of row
     * @param count number of rows
     * @return an arraylist of rows
     * @throws IOException
     */
    public static ArrayList<Row> readRowsFromFile(RandomAccessFile fa, int valueSize, int count) throws IOException {
        byte[] tmp = new byte[valueSize];
        ArrayList<Row> rows = new ArrayList<Row>();
        for(int i=0; i<count; ++i) {
            fa.read(tmp, 0, valueSize);
            rows.add(new Row(tmp));
        }
        return rows;
    }

    public static void writeRowToFile(RandomAccessFile fa, Row row)
        throws IOException {
        // TODO
    }

    /**
     * get the const defined in TypeConst of the class
     *
     * @param cls class
     * @return TypeConst value
     */
    public static int getClassType(Class cls) {
        String cls_name = cls.getName();
        if (cls_name.equals(Integer.class.getName())) {
            return TypeConst.VALUE_TYPE_INT;
        }
        if (cls_name.equals(Long.class.getName())) {
            return TypeConst.VALUE_TYPE_LONG;
        }
        if (cls_name.equals(Float.class.getName())) {
            return TypeConst.VALUE_TYPE_FLOAT;
        }
        if (cls_name.equals(Double.class.getName())) {
            return TypeConst.VALUE_TYPE_DOUBLE;
        }
        if (cls_name.equals(String.class.getName())) {
            return TypeConst.VALUE_TYPE_STRING;
        } else {
            System.out.println(String.format("not support type %s", cls_name));
        }
        return -1;
    }

}


