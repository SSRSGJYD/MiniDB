package minidb.basic.database;


import java.io.Serializable;
import java.util.HashMap;


public class Schema implements Serializable{
	
    private static final long serialVersionUID = 1L;

	HashMap<String,SchemaDescriptor> descriptors;
	
	public Schema() {
		descriptors=new HashMap<String,SchemaDescriptor>();
	}
	public Schema(HashMap<String,SchemaDescriptor> data) {
		this.descriptors=data;
	}


}
