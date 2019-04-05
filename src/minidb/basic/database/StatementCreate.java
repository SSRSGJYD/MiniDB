package minidb.basic.database;

import minidb.basic.database.DataBase;
import minidb.basic.database.Schema;
import minidb.basic.database.Result;

public class StatementCreate extends Statement {
	
	String tableName;
	Schema sc;
	
	public StatementCreate() {
		this.stType=StatementType.Create;
	}
	
	@Override
	public Result execute(DataBase db) {
		Table tb=new Table(tableName,sc);
		db.insertTable(tb);
		Result rs=new Result(true);
		return rs;
	}
	
}
