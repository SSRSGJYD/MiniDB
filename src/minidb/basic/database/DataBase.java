package minidb.basic.database;

import java.util.HashMap; 

public class DataBase {
	
	HashMap<String,Table> tables;
	String currentTable;
	
	
	public DataBase() {
		// TODO

	}
	
	public void open() {
		//load schema from disk to memory
    	//load index
    }
	
	protected void loadSchemas() {
		
	}
	
	protected void addTable(Table tb) {
		tables.put(tb.tableName, tb);
	}
	
	public void createTable(String tableName, Schema sc) {
		Table tb=new Table(tableName,sc);
		addTable(tb);
		//TODO insert into schema file
	}
	
	public void dropTable(String name) {
		tables.remove(name);
		//TODO remove from index and schema file
	}

}
