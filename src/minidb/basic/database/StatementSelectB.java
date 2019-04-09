package minidb.basic.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;




public class StatementSelectB extends Statement {
	
	public List<Pair<String,String>> cnames;
	public List<Pair<Pair<String,String>,Pair<String,String>>> onConditions;
	public List<String> jnames;
	
	public String tableName;
	
	public boolean existWhere;
	public String cdName;
	public String cdValue;
	public int op;
	
	public StatementSelectB() {
		this.type=Statement.selectB;
		cnames=new ArrayList<Pair<String,String>>();
		jnames=new ArrayList<String>();
		onConditions=new ArrayList<Pair<Pair<String, String>, Pair<String, String>>>();
	}
	
}
