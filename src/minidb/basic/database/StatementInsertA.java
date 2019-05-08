package minidb.basic.database;

import java.util.ArrayList;
import java.util.List;

public class StatementInsertA extends Statement {
	public String tableName;
	public List<String> values;
	
	public StatementInsertA() {
		this.type=Statement.insertA;
		values=new ArrayList<String>();
	}
}
