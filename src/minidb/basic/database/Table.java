package minidb.basic.database;

import java.io.Serializable;

import minidb.basic.database.Schema;

public class Table implements Serializable{

	private static final long serialVersionUID = 1L;
	
	String tableName;
	Schema schema;
	
	public Table(String tableName,Schema schema) {
		this.tableName=tableName;
		this.schema=schema;
	}
	
	public void insert(Row row) {
		
	}
}
