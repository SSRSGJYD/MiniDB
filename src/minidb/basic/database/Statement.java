package minidb.basic.database;

public abstract class Statement {
	public static final int create = 0;
	public static final int drop = 1;
	public static final int insertA = 2;
	public static final int insertB = 3;
	public static final int delete = 4;
	public static final int update = 5;
	public static final int selectA = 6;
	public static final int selectB = 7;
	
	public static final int eq = 0;
	public static final int lg = 1;
	public static final int lt = 2;
	public static final int lge = 3;
	public static final int lte = 4;
	public static final int neq = 5;
	
	public int type;
}
