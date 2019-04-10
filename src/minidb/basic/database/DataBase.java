package minidb.basic.database;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import minidb.types.TypeConst; 

public class DataBase{
	

	String name;
	HashMap<String,Table> tables;
	String currentTable;
	
	
	public DataBase() {
		// TODO 
		tables=new HashMap<String,Table>();
	}
	
	public void open() {
		//load schema from disk to memory
    	//load index
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
			Row row=tb.mkRow(sia.values);
			tb.simpleInsert(row);
			break;
		}
	}
	
	protected void addTable(Table tb) {
		tables.put(tb.tableName, tb);
	}
	
	public void createTable(String tableName, Schema sa) throws IOException {
		Table tb =new Table(tableName,sa);
		addTable(tb);
	}
	
	public void dropTable(String name) {
		tables.remove(name);
		//TODO remove from index and schema file
	}
	
}
