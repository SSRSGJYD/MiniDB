package minidb.basic.database;

public class StatementPerm extends Statement {
	public String perm;
	public String tableName;
	public String userName;
	public boolean isOption;
	public int stType;

	public static final int grant= 0;
	public static final int revoke= 1;

	public StatementPerm() {
		this.type=Statement.Perm;
		this.isOption=false;
	}

}
