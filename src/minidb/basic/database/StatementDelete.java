package minidb.basic.database;


public class StatementDelete extends Statement {
	public String tableName;

	public LogicTree lt;
	
	public StatementDelete() {
		this.type=Statement.delete;
	}
}
