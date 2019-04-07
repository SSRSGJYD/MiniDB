package minidb.basic.database;

import java.util.HashMap;

public class StatementCreate extends Statement {
	public String tableName;
	public HashMap<String,SchemaDescriptor> descriptors;
	
	public StatementCreate() {
		this.type=Statement.create;
	}
}
