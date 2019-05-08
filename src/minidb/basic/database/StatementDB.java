package minidb.basic.database;

public class StatementDB extends Statement {
	public String dbName;
	public int stType;
	
	public static final int create= 0;
	public static final int drop= 1;
	public static final int use= 2;
	public static final int show= 3;
	public static final int showdb= 4;

	public StatementDB() {
		this.type=Statement.DB;
	}
}
