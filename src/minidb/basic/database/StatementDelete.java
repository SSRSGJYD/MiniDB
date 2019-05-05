package minidb.basic.database;


public class StatementDelete extends Statement {
	public String tableName;
	public String cdName;
	public String cdValue;
	public String cdNamer;
	public boolean isImme;
	public int op;
	
	public StatementDelete() {
		this.type=Statement.delete;
	}
}
