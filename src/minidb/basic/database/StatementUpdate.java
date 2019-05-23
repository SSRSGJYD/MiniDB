package minidb.basic.database;

public class StatementUpdate extends Statement {
	public String tableName;
	public String setName;
	public String setValue;
	public LogicTree lt;
	
	public StatementUpdate() {
		this.type=Statement.update;
	}

}
