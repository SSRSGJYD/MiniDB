package minidb.basic.database;
import java.util.HashMap;
import java.util.Hashtable;

import minidb.basic.database.Statement;

public class StatementInsertB extends Statement {
	public String tableName;
	public HashMap<String,String> pairs;
	
	public StatementInsertB() {
		this.type=Statement.insertB;
		pairs=new HashMap<String,String>();
	}

}
