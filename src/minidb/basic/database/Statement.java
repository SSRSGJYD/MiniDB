package minidb.basic.database;

public abstract class Statement {
	public static final int create = 0;
	public static final int drop = 1;

	public int type;
}
