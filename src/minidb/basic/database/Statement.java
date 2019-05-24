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
	public static final int DB = 8;
	public static final int User = 9;
	
	public static final int eq = 0;
	public static final int lg = 1;
	public static final int lt = 2;
	public static final int lge = 3;
	public static final int lte = 4;
	public static final int neq = 5;
	
	public static int opFromString(String Op) {
		int op = 0;
		if(Op.equals("=")) 
			op=Statement.eq;
		else if(Op.equals(">")) 
			op=Statement.lg;
		else if(Op.equals("<")) 
			op=Statement.lt;
		else if(Op.equals(">=")) 
			op=Statement.lge;
		else if(Op.equals("<=")) 
			op=Statement.lte;
		else if(Op.equals("<>")) 
			op=Statement.neq;
		return op;
	}
	
	public int type;
}
