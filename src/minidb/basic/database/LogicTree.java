package minidb.basic.database;

public class LogicTree {
	
	public static final int and= 0;
	public static final int or= 1;
	
	public boolean isLeaf;

	public String cdName;
	public String cdValue;
	public boolean isImme;
	public String cdNamer;
	public int op;

	public LogicTree ltree;
	public LogicTree rtree;
	public int lop;

}
