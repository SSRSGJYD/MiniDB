package minidb.basic.database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import minidb.result.BoolResult;
import minidb.result.QueryResult;
import minidb.result.Result; 

//TODO rhs value of where
public class DataBase{
	

	String name;
	HashMap<String,Table> tables;
	public DataBase(String n) throws ClassNotFoundException, IOException {
		tables=new HashMap<String,Table>();
		name=n;
		open();
	}
	
	
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
			tb.createPrimaryIndex();

			for(Entry<String, SchemaDescriptor> entry:tb.schema.descriptors.entrySet()) {
				SchemaDescriptor sd=entry.getValue();
				if(!sd.isPrimary()) {
					tb.createSecondaryIndex(entry);
				}
			}

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
			if(!tables.containsKey(sc.tableName)) {
				Schema sa=new Schema(sc.descriptors);
				sa.types=sc.types;
				this.createTable(sc.tableName,sa);
			}
//			else {
//				throw new IllegalArgumentException("table already exist");
//			}
			res=new BoolResult();
			break;
		case Statement.drop:
			StatementDrop sd=(StatementDrop) st;
			if(!this.tables.containsKey(sd.tableName)) {
				throw new IllegalArgumentException("table not exist");
			}

			dropTable(sd.tableName);
			res=new BoolResult();
			break;
		case Statement.insertA:
			StatementInsertA sia=(StatementInsertA) st;
			if(!this.tables.containsKey(sia.tableName)) {
				throw new IllegalArgumentException("table not exist");
			}

			tb=tables.get(sia.tableName);
			pair=tb.mkRow(sia.values);
			tb.simpleInsert(pair.l,pair.r);
			tb.insertIndexs(pair.l, sia.values);
			res=new BoolResult();
			break;
		case Statement.insertB:
			StatementInsertB sib=(StatementInsertB) st;
			if(!this.tables.containsKey(sib.tableName)) {
				throw new IllegalArgumentException("table not exist");
			}
			tb=tables.get(sib.tableName);
			pair=tb.mkRowB(sib.pairs);
			tb.simpleInsert(pair.l,pair.r);
			tb.insertIndexsB(pair.l, sib.pairs);
			res=new BoolResult();
			break;
		case Statement.selectA:
			StatementSelectA sla=(StatementSelectA) st;
			if(!this.tables.containsKey(sla.tableName)) {
				throw new IllegalArgumentException("table not exist");
			}
			tb=tables.get(sla.tableName);
			if(sla.isStar) {
				List<String> names=new ArrayList<String>(tb.schema.descriptors.keySet());
				if(sla.isImme)
					res=tb.query(names, sla.existWhere, sla.cdName, sla.cdValue, sla.op);
				else
					res=tb.queryI(names, sla.existWhere, sla.cdName, sla.cdNamer, sla.op);
					
			}
			else
				if(sla.isImme)
					res=tb.query(sla.names, sla.existWhere, sla.cdName, sla.cdValue, sla.op);
				else
					res=tb.queryI(sla.names, sla.existWhere, sla.cdName, sla.cdNamer, sla.op);
			break;
		case Statement.selectB:
			StatementSelectB slb=(StatementSelectB) st;
			res=Table.queryJ(slb.isStar,tables,slb.cnames,slb.jnames,slb.onConditions,slb.existWhere,slb.isImme,slb.cdNameP,slb.cdValue,slb.cdNamerP,slb.op);
			break;

		case Statement.update:
			StatementUpdate su=(StatementUpdate) st;
			if(!this.tables.containsKey(su.tableName)) {
				throw new IllegalArgumentException("table not exist");
			}
			tb=tables.get(su.tableName);
			tb.update(su.cdName,su.cdValue,su.op,su.setName,su.setValue);
			res=new BoolResult();
			break;

		case Statement.delete:
			StatementDelete sds=(StatementDelete) st;
			if(!this.tables.containsKey(sds.tableName)) {
				throw new IllegalArgumentException("table not exist");
			}
			tb=tables.get(sds.tableName);
			tb.delete(sds.cdName,sds.cdValue,sds.op);
			res=new BoolResult();
			break;
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
		Table tb=tables.get(name);
		tables.remove(name);
		for(String n:tb.schema.descriptors.keySet()) {
			File filef = new File(name.concat("_").concat(n).concat(".index"));
			filef.delete();
		}
		File file = new File(name.concat(".schema"));
		file.delete();
		File file1 = new File(name.concat(".index"));
		file1.delete();
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
