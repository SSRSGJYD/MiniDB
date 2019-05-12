package minidb.basic.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;




public class StatementSelectB extends Statement {
	
	public static final int join= 0;
	public static final int leftOuterJoin= 1;
	public static final int rightOuterJoin= 2;
	public static final int fullOuterJoin= 3;

	public List<Pair<String,String>> cnames;
	public List<Pair<Pair<String,String>,Pair<String,String>>> onConditions;
	public List<Pair<String,Integer>> jnames;
	
	public boolean isStar;
	public boolean existWhere;
	public CLogicTree lt;
	
	
	public StatementSelectB() {
		this.type=Statement.selectB;
		cnames=new ArrayList<Pair<String,String>>();
		jnames=new ArrayList<Pair<String,Integer>>();
		onConditions=new ArrayList<Pair<Pair<String, String>, Pair<String, String>>>();
	}
	
}
