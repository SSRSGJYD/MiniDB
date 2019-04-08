package minidb.basic.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StatementSelectB extends Statement {
	
	public HashMap<String,String> names;
	public String tableName;
	
	public boolean existWhere;
	public String onName;
	public String onValue;
	public int op;
	
		
	public StatementSelectB() {
		this.type=Statement.selectB;
	}
	
}
