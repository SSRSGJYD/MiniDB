package minidb.basic.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StatementSelectA extends Statement {
	public List<String> names;
	public String tableName;
	public boolean existWhere;
	public boolean isStar;
	
	public LogicTree lt;

	
	public StatementSelectA() {
		this.type=Statement.selectA;
		names=new ArrayList<String>();
	}
}
