package minidb.basic.database;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class StatementCreate extends Statement {
	public String tableName;
	public LinkedHashMap<String,SchemaDescriptor> descriptors;
	public HashMap<String,Integer> types;
	
	public StatementCreate() {
		this.type=Statement.create;
		this.descriptors=new LinkedHashMap<String,SchemaDescriptor>();
	}
}
