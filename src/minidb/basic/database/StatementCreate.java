package minidb.basic.database;

import java.util.LinkedHashMap;

public class StatementCreate extends Statement {
	public String tableName;
	public LinkedHashMap<String,SchemaDescriptor> descriptors;
	
	public StatementCreate() {
		this.type=Statement.create;
		this.descriptors=new LinkedHashMap<String,SchemaDescriptor>();
	}
}
