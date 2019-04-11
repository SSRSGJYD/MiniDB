package minidb.types;

public class TypeConst {

    // valueType : type of value stored
    public static final int VALUE_TYPE_INT = 0;
    public static final int VALUE_TYPE_LONG = 1;
    public static final int VALUE_TYPE_FLOAT = 2;
    public static final int VALUE_TYPE_DOUBLE = 3;
    public static final int VALUE_TYPE_STRING = 4;

    public static final int VALUE_SIZE_INT = Integer.BYTES;
    public static final int VALUE_SIZE_LONG = Long.BYTES;
    public static final int VALUE_SIZE_FLOAT = Float.BYTES;
    public static final int VALUE_SIZE_DOUBLE = Double.BYTES;
    public static final int VALUE_SIZE_CHAR = Character.BYTES;

    public static final int VALUE_SIZE[] = {Integer.BYTES, Long.BYTES, Float.BYTES, Double.BYTES, Character.BYTES};
}
