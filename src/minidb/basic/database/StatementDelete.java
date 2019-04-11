package minidb.basic.database;


public class StatementDelete extends Statement {
	public String tableName;
	public String cdName;
	public String cdValue;
	public int op;
	
	public StatementDelete() {
		this.type=Statement.delete;
	}
}
