package minidb.basic.database;

public class StatementInsert extends Statement {

	String tableName;
	Row row;
	
	public StatementInsert() {
		this.stType=StatementType.Insert;
	}
	
	@Override
	public Result execute(DataBase db) {
		Table tb=db.tables.get(tableName);
		tb.insert(row);
		return null;
	}

}
