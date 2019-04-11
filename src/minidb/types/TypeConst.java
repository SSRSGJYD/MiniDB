package minidb.types;

public class TypeConst {

    // valueType : type of value stored
    public static final int VALUE_TYPE_INT = 0;
    public static final int VALUE_TYPE_LONG = 1;
    public static final int VALUE_TYPE_FLOAT = 2;
    public static final int VALUE_TYPE_DOUBLE = 3;
    public static final int VALUE_TYPE_STRING = 4;


    public static final int VALUE_SIZE_INT = Integer.SIZE;
    public static final int VALUE_SIZE_LONG = Long.SIZE;
    public static final int VALUE_SIZE_FLOAT = Float.SIZE;
    public static final int VALUE_SIZE_DOUBLE = Double.SIZE;
    public static final int VALUE_SIZE_CHAR = Character.SIZE;

    public static final int VALUE_SIZE[] = {Integer.SIZE, Long.SIZE, Float.SIZE, Double.SIZE, Character.SIZE};

    public static int fromString(String str) {
    	if(str.equalsIgnoreCase("Int")) return VALUE_TYPE_INT;
    	else if(str.equalsIgnoreCase("Long")) return VALUE_TYPE_LONG;
    	else if(str.equalsIgnoreCase("Float")) return VALUE_TYPE_FLOAT;
    	else if(str.equalsIgnoreCase("Double")) return VALUE_TYPE_LONG;
    	else return VALUE_TYPE_STRING;
    }
    public static int type2size(int type) {
    	switch(type) {
    	case TypeConst.VALUE_TYPE_INT:
    		return TypeConst.VALUE_SIZE_INT;
    	case TypeConst.VALUE_TYPE_LONG:
    		return TypeConst.VALUE_SIZE_LONG;
    	case TypeConst.VALUE_TYPE_FLOAT:
    		return TypeConst.VALUE_SIZE_FLOAT;
    	case TypeConst.VALUE_TYPE_DOUBLE:
    		return TypeConst.VALUE_SIZE_DOUBLE;
    	default:
    		return TypeConst.VALUE_SIZE_CHAR;
    	}
    }
}
