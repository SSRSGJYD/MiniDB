package minidb.basic.database;

public class StatementDrop extends Statement {
	
	String tableName;
	
	public StatementDrop() {
		this.stType=StatementType.Drop;
	}
	
	@Override
	public Result execute(DataBase db) {
		db.dropTable(tableName);
		Result rs=new Result(true);
		return rs;
	}

}
