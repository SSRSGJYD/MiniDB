package minidb.basic.database;

import java.util.HashMap; 
import java.util.Map; 
import minidb.basic.database.DataBase;
import minidb.basic.database.Schema;
import minidb.basic.database.Schema.DataType;
import minidb.basic.database.Result;

public class StatementCreate extends Statement {
	
	String tableName;
	HashMap<String,DataType> vars;
	
	public StatementCreate() {
		this.stType=StatementType.Create;
	}
	
	@Override
	public Result execute(DataBase db) {
		Schema sc=new Schema(vars);
		Table tb=new Table(tableName,sc);
		db.insertTable(tb);
		Result rs=new Result(true);
		return rs;
	}
	
}
