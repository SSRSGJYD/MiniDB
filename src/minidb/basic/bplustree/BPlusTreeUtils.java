package minidb.basic.bplustree;

import minidb.basic.database.Row;
import minidb.basic.index.*;
import minidb.result.DeleteResult;
import minidb.types.TypeConst;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.ArrayList;

import org.antlr.v4.parse.ANTLRParser.v3tokenSpec_return;

/**
 * Util class for B+ tree
 *
 *
 */
public class BPlusTreeUtils {

    /**
     * read in a primary key from file
     *
     * @param fa file access
     * @param keyType type of key
     * @param keySize size of key
     * @return key
     * @throws IOException
     */
    public static Key readPrimaryKeyFromFile(RandomAccessFile fa, int keyType, int keySize) throws IOException {
        switch (keyType) {
            case TypeConst.VALUE_TYPE_INT:
                return new PrimaryKey<Integer>(fa.readInt(), TypeConst.VALUE_TYPE_INT, keySize);
            case TypeConst.VALUE_TYPE_LONG:
                return new PrimaryKey<Long>(fa.readLong(), TypeConst.VALUE_TYPE_LONG, keySize);
            case TypeConst.VALUE_TYPE_FLOAT:
                return new PrimaryKey<Float>(fa.readFloat(), TypeConst.VALUE_TYPE_FLOAT, keySize);
            case TypeConst.VALUE_TYPE_DOUBLE:
                return new PrimaryKey<Double>(fa.readDouble(), TypeConst.VALUE_TYPE_DOUBLE, keySize);
            default:  //TypeConst.VALUE_TYPE_STRING:
            	String primaryKey = "";
				int len = keySize / TypeConst.VALUE_SIZE_CHAR;
		    	for(int i=0; i<len; i++) {
		    		primaryKey += fa.readChar();
		    	}
                return new PrimaryKey<String>(primaryKey, TypeConst.VALUE_TYPE_STRING, keySize);
        }
    }

    /**
     * read in a secondary key from file
     *
     * @param fa file access
     * @param keyType type of attribute
     * @param keySize size of attribute
     * @param PKType type of primary key
     * @param PKSize type of primary size
     * @return key
     * @throws IOException
     */
    public static Key readSecondaryKeyFromFile(RandomAccessFile fa, int keyType, int keySize, int PKType, int PKSize)
            throws IOException {
        // attribute key
        switch (keyType) {
            case TypeConst.VALUE_TYPE_INT:
            {
                Integer key = fa.readInt();
                // primary key
                switch (PKType) {
                    case TypeConst.VALUE_TYPE_INT: {
                        Integer primaryKey = fa.readInt();
                        return new SecondaryKey<Integer, Integer>(key, keyType, keySize, primaryKey, PKType, PKSize);
                    }
                    case TypeConst.VALUE_TYPE_LONG: {
                        Long primaryKey = fa.readLong();
                        return new SecondaryKey<Integer, Long>(key, keyType, keySize, primaryKey, PKType, PKSize);
                    }
                    case TypeConst.VALUE_TYPE_FLOAT: {
                        Float primaryKey = fa.readFloat();
                        return new SecondaryKey<Integer, Float>(key, keyType, keySize, primaryKey, PKType, PKSize);
                    }
                    case TypeConst.VALUE_TYPE_DOUBLE:{
                        Double primaryKey = fa.readDouble();
                        return new SecondaryKey<Integer, Double>(key, keyType, keySize, primaryKey, PKType, PKSize);
                    }
                    default: { //TypeConst.VALUE_TYPE_STRING:
                    	String primaryKey = "";
        				int len = PKSize / TypeConst.VALUE_SIZE_CHAR;
        		    	for(int i=0; i<len; i++) {
        		    		primaryKey += fa.readChar();
        		    	}
                        return new SecondaryKey<Integer, String>(key, keyType, keySize, primaryKey, PKType, PKSize);
                    }
                }
            }
            case TypeConst.VALUE_TYPE_LONG:
            {
                Long key = fa.readLong();
                // primary key
                switch (PKType) {
                    case TypeConst.VALUE_TYPE_INT: {
                        Integer primaryKey = fa.readInt();
                        return new SecondaryKey<Long, Integer>(key, keyType, keySize, primaryKey, PKType, PKSize);
                    }
                    case TypeConst.VALUE_TYPE_LONG: {
                        Long primaryKey = fa.readLong();
                        return new SecondaryKey<Long, Long>(key, keyType, keySize, primaryKey, PKType, PKSize);
                    }
                    case TypeConst.VALUE_TYPE_FLOAT: {
                        Float primaryKey = fa.readFloat();
                        return new SecondaryKey<Long, Float>(key, keyType, keySize, primaryKey, PKType, PKSize);
                    }
                    case TypeConst.VALUE_TYPE_DOUBLE:{
                        Double primaryKey = fa.readDouble();
                        return new SecondaryKey<Long, Double>(key, keyType, keySize, primaryKey, PKType, PKSize);
                    }
                    default: { //TypeConst.VALUE_TYPE_STRING:
                    	String primaryKey = "";
        				int len = PKSize / TypeConst.VALUE_SIZE_CHAR;
        		    	for(int i=0; i<len; i++) {
        		    		primaryKey += fa.readChar();
        		    	}
                        return new SecondaryKey<Long, String>(key, keyType, keySize, primaryKey, PKType, PKSize);
                    }
                }
            }
            case TypeConst.VALUE_TYPE_FLOAT:
            {
                Float key = fa.readFloat();
                // primary key
                switch (PKType) {
                    case TypeConst.VALUE_TYPE_INT: {
                        Integer primaryKey = fa.readInt();
                        return new SecondaryKey<Float, Integer>(key, keyType, keySize, primaryKey, PKType, PKSize);
                    }
                    case TypeConst.VALUE_TYPE_LONG: {
                        Long primaryKey = fa.readLong();
                        return new SecondaryKey<Float, Long>(key, keyType, keySize, primaryKey, PKType, PKSize);
                    }
                    case TypeConst.VALUE_TYPE_FLOAT: {
                        Float primaryKey = fa.readFloat();
                        return new SecondaryKey<Float, Float>(key, keyType, keySize, primaryKey, PKType, PKSize);
                    }
                    case TypeConst.VALUE_TYPE_DOUBLE:{
                        Double primaryKey = fa.readDouble();
                        return new SecondaryKey<Float, Double>(key, keyType, keySize, primaryKey, PKType, PKSize);
                    }
                    default: { //TypeConst.VALUE_TYPE_STRING:
                    	String primaryKey = "";
        				int len = PKSize / TypeConst.VALUE_SIZE_CHAR;
        		    	for(int i=0; i<len; i++) {
        		    		primaryKey += fa.readChar();
        		    	}
                        return new SecondaryKey<Float, String>(key, keyType, keySize, primaryKey, PKType, PKSize);
                    }
                }
            }
            case TypeConst.VALUE_TYPE_DOUBLE:
            {
                Double key = fa.readDouble();
                // primary key
                switch (PKType) {
                    case TypeConst.VALUE_TYPE_INT: {
                        Integer primaryKey = fa.readInt();
                        return new SecondaryKey<Double, Integer>(key, keyType, keySize, primaryKey, PKType, PKSize);
                    }
                    case TypeConst.VALUE_TYPE_LONG: {
                        Long primaryKey = fa.readLong();
                        return new SecondaryKey<Double, Long>(key, keyType, keySize, primaryKey, PKType, PKSize);
                    }
                    case TypeConst.VALUE_TYPE_FLOAT: {
                        Float primaryKey = fa.readFloat();
                        return new SecondaryKey<Double, Float>(key, keyType, keySize, primaryKey, PKType, PKSize);
                    }
                    case TypeConst.VALUE_TYPE_DOUBLE:{
                        Double primaryKey = fa.readDouble();
                        return new SecondaryKey<Double, Double>(key, keyType, keySize, primaryKey, PKType, PKSize);
                    }
                    default: { //TypeConst.VALUE_TYPE_STRING:
                    	String primaryKey = "";
        				int len = PKSize / TypeConst.VALUE_SIZE_CHAR;
        		    	for(int i=0; i<len; i++) {
        		    		primaryKey += fa.readChar();
        		    	}
                        return new SecondaryKey<Double, String>(key, keyType, keySize, primaryKey, PKType, PKSize);
                    }
                }
            }
            default:  //TypeConst.VALUE_TYPE_STRING:
            {
            	String key = "";
				int len = keySize / TypeConst.VALUE_SIZE_CHAR;
		    	for(int i=0; i<len; i++) {
		    		key += fa.readChar();
		    	}
                // primary key
                switch (PKType) {
                    case TypeConst.VALUE_TYPE_INT: {
                        Integer primaryKey = fa.readInt();
                        return new SecondaryKey<String, Integer>(key, keyType, keySize, primaryKey, PKType, PKSize);
                    }
                    case TypeConst.VALUE_TYPE_LONG: {
                        Long primaryKey = fa.readLong();
                        return new SecondaryKey<String, Long>(key, keyType, keySize, primaryKey, PKType, PKSize);
                    }
                    case TypeConst.VALUE_TYPE_FLOAT: {
                        Float primaryKey = fa.readFloat();
                        return new SecondaryKey<String, Float>(key, keyType, keySize, primaryKey, PKType, PKSize);
                    }
                    case TypeConst.VALUE_TYPE_DOUBLE:{
                        Double primaryKey = fa.readDouble();
                        return new SecondaryKey<String, Double>(key, keyType, keySize, primaryKey, PKType, PKSize);
                    }
                    default: { //TypeConst.VALUE_TYPE_STRING:
                    	String primaryKey = "";
        				int length = PKSize / TypeConst.VALUE_SIZE_CHAR;
        		    	for(int i=0; i<length; i++) {
        		    		primaryKey += fa.readChar();
        		    	}
                        return new SecondaryKey<String, String>(key, keyType, keySize, primaryKey, PKType, PKSize);
                    }
                }
            }
        }
    }

    /**
     * read in a key from file
     *
     * @param fa file access
     * @param key key to write
     * @throws IOException
     */
    public static void writeKeyToFile(RandomAccessFile fa, Key key) throws IOException {
        key.writeToFile(fa);
    }

    public static void writeRowToFile(RandomAccessFile fa, Value row)
        throws IOException {
        fa.write(row.array);
    }
    
    public static void writeKeyToBuffer(ByteBuffer buffer, Key key) throws IOException {
        key.writeToBuffer(buffer);
    }

    public static void writeRowToBuffer(ByteBuffer buffer, Value row)
        throws IOException {
        buffer.put(row.array);
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


