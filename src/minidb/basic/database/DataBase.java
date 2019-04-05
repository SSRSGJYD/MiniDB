package minidb.basic.database;

import java.util.HashMap; 
import minidb.basic.database.Result;
import minidb.basic.database.Statement;
import minidb.basic.database.StatementCreate;

public class DataBase {
	
	HashMap<String,Table> tables;
	
	
	public DataBase() {
		// TODO

	}
	
	public void open() {
		//load schema from disk to memory
    	//load index
    }
    
	public Result runSQL(String sql) {
		return null;
    }
	
	protected void loadSchemas() {
		
	}
	
	protected void runStatement(Statement st) {
		switch(st.stType) {
		case Create:
			StatementCreate stc=(StatementCreate)st;
			stc.execute(this);
			break;
		default:
			break;
			
		}
	}
	
	public void insertTable(Table tb) {
		tables.put(tb.tableName, tb);
	}
	
	public void dropTable(String name) {
		tables.remove(name);
		//TODO remove from index and schema file
	}

}
