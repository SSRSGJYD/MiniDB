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
	
	public Result execute(Statement st,HashMap<String,Permission> perms,boolean isRoot) throws IOException, ClassNotFoundException {
		Result res = null;
		Table tb;
		Pair<Object,Row> pair;
		switch(st.type) {
		case Statement.create:
			StatementCreate sc=(StatementCreate) st;
			if(!tables.containsKey(sc.tableName)) {
				Schema sa=new Schema(sc.descriptors);
				sa.types=sc.types;
				this.createTable(sc.tableName,sa,sc.hasPrimary);
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
			List<String> values=tb.fixValues(sia.values);
			pair=tb.mkRow(values);
			tb.simpleInsert(pair.l,pair.r);
			tb.insertIndexs(pair.l, values);
			res=new BoolResult();
			break;
		case Statement.insertB:
			StatementInsertB sib=(StatementInsertB) st;
			if(!this.tables.containsKey(sib.tableName)) {
				throw new IllegalArgumentException("table not exist");
			}
			tb=tables.get(sib.tableName);
			HashMap<String,String> pairs=tb.fixPairs(sib.pairs);
			pair=tb.mkRowB(pairs);
			tb.simpleInsert(pair.l,pair.r);
			tb.insertIndexsB(pair.l, pairs);
			res=new BoolResult();
			break;
		case Statement.selectA:
			StatementSelectA sla=(StatementSelectA) st;
			if(!isRoot&&!perms.get(sla.tableName).canSelect) {
				throw new IllegalArgumentException("no select permission");
			}
			if(!this.tables.containsKey(sla.tableName)) {
				throw new IllegalArgumentException("table not exist");
			}
			tb=tables.get(sla.tableName);
			if(sla.isStar) {
				List<String> names=new ArrayList<String>(tb.schema.descriptors.keySet());
				res=tb.queryT(names, sla.existWhere, sla.lt);
					
			}
			else
				res=tb.queryT(sla.names, sla.existWhere, sla.lt);
			break;
		case Statement.selectB:
			StatementSelectB slb=(StatementSelectB) st;
			for(Pair<String,Integer> jname:slb.jnames) {
				if(!isRoot&&!perms.get(jname.l).canSelect) {
					throw new IllegalArgumentException("no select permission");
				}
			}
			res=Table.queryJT(slb.isStar,tables,slb.cnames,slb.jnames,slb.onConditions,slb.existWhere,slb.lt);
			break;

		case Statement.update:
			StatementUpdate su=(StatementUpdate) st;
			if(!isRoot&&!perms.get(su.tableName).canUpdate) {
				throw new IllegalArgumentException("no select permission");
			}
			if(!this.tables.containsKey(su.tableName)) {
				throw new IllegalArgumentException("table not exist");
			}
			tb=tables.get(su.tableName);
			tb.update(su.lt,su.setName,su.setValue);
			res=new BoolResult();
			break;

		case Statement.delete:
			StatementDelete sds=(StatementDelete) st;
			if(!this.tables.containsKey(sds.tableName)) {
				throw new IllegalArgumentException("table not exist");
			}
			tb=tables.get(sds.tableName);
			tb.delete(sds.lt);
			res=new BoolResult();
			break;
		}
		return res;
	}
	
	protected void addTable(Table tb) {
		tables.put(tb.tableName, tb);
	}
	
	public void createTable(String tableName, Schema sa,boolean hasPrimary) throws IOException {
		Table tb =new Table(tableName,sa,hasPrimary);
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
