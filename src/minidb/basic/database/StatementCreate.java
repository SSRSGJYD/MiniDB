package minidb.basic.database;

import java.util.HashMap; 
import java.util.Map; 

public class StatementCreate extends Statement {
	
	String tableName;
	HashMap<String,DataType> map;
	
	public StatementCreate() {
		this.stType=StatementType.Create;
	}
	
}
