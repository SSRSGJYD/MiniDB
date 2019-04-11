package minidb.basic.database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap; 

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
	
	public void execute(Statement st) throws IOException {
		switch(st.type) {
		case Statement.create:
			StatementCreate sc=(StatementCreate) st;
			Schema sa=new Schema(sc.descriptors);
			this.createTable(sc.tableName,sa);
			break;
		case Statement.drop:
			StatementDrop sd=(StatementDrop) st;
			dropTable(sd.tableName);
			break;
		case Statement.insertA:
			StatementInsertA sia=(StatementInsertA) st;
			Table tb=tables.get(sia.tableName);
			Pair<Object,Row> pair=tb.mkRow(sia.values);
			tb.simpleInsert(pair.l,pair.r);
			break;
		}
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
