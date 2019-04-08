package minidb.basic.database;

public class StatementUpdate extends Statement {
	public String tableName;
	public String cdName;
	public String cdValue;
	public String setName;
	public String setValue;
	public int op;
	
	public StatementUpdate() {
		this.type=Statement.update;
	}

}
