package minidb.basic.database;


import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


public class Schema implements Serializable{
	
    private static final long serialVersionUID = 1L;

	LinkedHashMap<String,SchemaDescriptor> descriptors;
	public LinkedHashMap<String,Integer> types;

	int keyType;
	String primaryKey;
	
	public Schema() {
		descriptors=new LinkedHashMap<String,SchemaDescriptor>();
		types=new LinkedHashMap<String,Integer>();
	}
	public Schema(LinkedHashMap<String,SchemaDescriptor> data) {
		this.descriptors=data;
		types=new LinkedHashMap<String,Integer>();
	}
	public int getPrimaryKeyType() {
		for (SchemaDescriptor value : descriptors.values()) {
			if(value.isPrimary()) {
				return value.getType();
			}
		}
		return 0;
		
	}


}
