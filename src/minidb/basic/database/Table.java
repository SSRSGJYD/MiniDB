package minidb.basic.database;

import minidb.basic.database.Schema;

public class Table {

	String tableName;
	Schema schema;
	
	public Table(String tableName,Schema schema) {
		this.tableName=tableName;
		this.schema=schema;
	}
	
	public void insert(Row row) {
		
	}
}
