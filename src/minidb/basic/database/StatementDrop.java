package minidb.basic.database;

public class StatementDrop extends Statement {
	public String tableName;
	public StatementDrop() {
		this.type=Statement.drop;
	}
}
