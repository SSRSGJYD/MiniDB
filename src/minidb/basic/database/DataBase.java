package minidb.basic.database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import minidb.result.BoolResult;
import minidb.result.QueryResult;
import minidb.result.Result; 

public class DataBase{
	

	String name;
	HashMap<String,Table> tables;
	
	
	public DataBase() throws ClassNotFoundException, IOException {
		tables=new HashMap<String,Table>();
		open();
	}
	
	public void open() throws IOException, ClassNotFoundException {
		File file = new File("schema.log"); 
		if(!file.exists())
			return;
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader(file)); 
		String st; 
		while ((st = br.readLine()) != null) {
			Table tb=Table.loadFromFile(st);
			tb.createIndex();
			addTable(tb);
		}
    }
	
	public Result execute(Statement st) throws IOException, ClassNotFoundException {
		Result res = null;
		Table tb;
		Pair<Object,Row> pair;
		switch(st.type) {
		case Statement.create:
			StatementCreate sc=(StatementCreate) st;
			Schema sa=new Schema(sc.descriptors);
			sa.types=sc.types;
			this.createTable(sc.tableName,sa);
			res=new BoolResult();
			break;
		case Statement.drop:
			StatementDrop sd=(StatementDrop) st;
			dropTable(sd.tableName);
			res=new BoolResult();
			break;
		case Statement.insertA:
			StatementInsertA sia=(StatementInsertA) st;
			tb=tables.get(sia.tableName);
			pair=tb.mkRow(sia.values);
			tb.simpleInsert(pair.l,pair.r);
			res=new BoolResult();
			break;
		case Statement.insertB:
			StatementInsertB sib=(StatementInsertB) st;
			tb=tables.get(sib.tableName);
			pair=tb.mkRowB(sib.pairs);
			tb.simpleInsert(pair.l,pair.r);
			res=new BoolResult();
			break;
		case Statement.selectA:
			StatementSelectA sla=(StatementSelectA) st;
			tb=tables.get(sla.tableName);
			res=tb.query(sla.names, sla.existWhere, sla.cdName, sla.cdValue, sla.op);
			break;

//		case statement.update:
//			statementupdate su=(statementupdate) st;
//			tb=tables.get(su.tablename);
//			tb.update(su.cdname,su.cdvalue,su.op,su.setname,su.setvalue);
//			res=new boolresult();
//			break;

		}
		return res;
	}
	
	protected void addTable(Table tb) {
		tables.put(tb.tableName, tb);
	}
	
	public void createTable(String tableName, Schema sa) throws IOException {
		Table tb =new Table(tableName,sa);
		tb.storeToFile(tb.tableName.concat(".schema"));
		addTable(tb);
	}
	
	public void dropTable(String name) throws IOException {
		tables.remove(name);
		File file = new File(name.concat(".schema"));
		file.delete();
		File file2 = new File("schema.log");
		file2.delete();
		refreshLog();
	}
	
	protected void refreshLog() throws IOException {
		for(Table table:tables.values()) {
			table.logToFile();
		}
	}
	
}
