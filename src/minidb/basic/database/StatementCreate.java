package minidb.basic.database;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class StatementCreate extends Statement {
	public String tableName;
	public LinkedHashMap<String,SchemaDescriptor> descriptors;
	public HashMap<String,Integer> types;
	public boolean hasPrimary;
	
	public StatementCreate() {
		this.hasPrimary=false;
		this.type=Statement.create;
		this.descriptors=new LinkedHashMap<String,SchemaDescriptor>();
		this.types=new HashMap<String,Integer>();
	}
}
