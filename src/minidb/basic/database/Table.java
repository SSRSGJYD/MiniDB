package minidb.basic.database;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import minidb.basic.database.Schema;
import minidb.basic.index.PrimaryIndex;
import minidb.basic.index.PrimaryKey;
import minidb.basic.index.Value;
import minidb.result.QueryResult;
import minidb.result.SearchResult;
import minidb.types.TypeConst;

public class Table implements Serializable{

	private static final long serialVersionUID = 1L;
	
	String tableName;
	Schema schema;
	transient PrimaryIndex index;
	int keySize;
	int keyType;
	int valueSize=0;
	
	public Table(String tableName,Schema schema) throws IOException {
		this.tableName=tableName;
		this.schema=schema;

		for(Entry<String, SchemaDescriptor> entry:schema.descriptors.entrySet()) {
			SchemaDescriptor sd=entry.getValue();
			if(sd.isPrimary()) {
				keyType=sd.getType();
				this.schema.primaryKey=entry.getKey();
				keySize=sd.getSize();
			}
			valueSize+=sd.getSize()+TypeConst.VALUE_SIZE_NULL;
		}

		this.schema.keyType=keyType;
		this.createIndex();

	}
	
	
	protected LinkedHashMap<String,Object> filterNames(List<String> names,LinkedHashMap<String,Object> data){
		LinkedHashMap<String,Object> res=new LinkedHashMap<String,Object>();
		for(String name:names) {
			res.put(name, data.get(name));
		}
		return res;
		
	}

	protected QueryResult queryX(List<String> names,Boolean existWhere,String cdName,String cdValue, int op) throws IOException, ClassNotFoundException {
		LinkedList<Value> rows=index.searchAll().rows;
		return null;

//    searchByRange(PrimaryKey<K> lbound, boolean uselbound, PrimaryKey<K> hbound, boolean usehbound)
		
	}
	protected QueryResult query(List<String> names,Boolean existWhere,String cdName,String cdValue, int op) throws IOException, ClassNotFoundException {
		LinkedList<Value> rows=index.searchAll().rows;
		ArrayList<LinkedHashMap<String,Object>> rowl=fromRaw(rows);
		ArrayList<LinkedHashMap<String,Object>> res=new ArrayList<LinkedHashMap<String,Object>>();
		if(existWhere) {
			RowFilter rf= buildFilter(cdName,op,cdValue);
			for(LinkedHashMap<String,Object> objs:rowl) {
				if(rf.method(objs)) {
					LinkedHashMap<String,Object> nobjs=filterNames(names,objs);
					res.add(nobjs);
				}
			}
		}
		else{
			for(LinkedHashMap<String,Object> objs:rowl) {
				LinkedHashMap<String,Object> nobjs=filterNames(names,objs);
				res.add(nobjs);
			}
		}
		QueryResult qr=new QueryResult();
		qr.data=res;
		qr.types=this.schema.types;
		return qr;
	}
	
	protected RowFilter buildFilter(String cdName,int op,String cdValue) {
		SchemaDescriptor sd = this.schema.descriptors.get(cdName);
		RowFilter rf=(row)->this.compare(op,sd.getType(),row.get(cdName),cdValue);
		return rf;
	}
	
	protected <T extends Comparable <T>> boolean compareT(int op,T va,T vb) {
		int res=va.compareTo(vb);
		switch(op) {
		case Statement.eq:
			return res==0;
		case Statement.lg:
			return res>0;
		case Statement.lt:
			return res<0;
		case Statement.lge:
			return res>=0;
		case Statement.lte:
			return res<=0;
		}
		return true;
	}

	protected boolean compare(int op,int type,Object va,String vb) {
		switch(type) {
		case TypeConst.VALUE_TYPE_INT:
			return compareT(op,(Integer)va,Integer.parseInt(vb));
		case TypeConst.VALUE_TYPE_LONG:
			return compareT(op,(Long)va,Long.parseLong(vb));
		case TypeConst.VALUE_TYPE_FLOAT:
			return compareT(op,(Float)va,Float.parseFloat(vb));
		case TypeConst.VALUE_TYPE_DOUBLE:
			return compareT(op,(Double)va,Double.parseDouble(vb));
		case TypeConst.VALUE_TYPE_STRING:
			return compareT(op,(String)va,(String)vb);
		}
		return true;
		
	}

	protected ArrayList<LinkedHashMap<String,Object>> fromRaw(LinkedList<Value> rows) throws ClassNotFoundException, IOException{
		ArrayList<LinkedHashMap<String,Object>> res=new ArrayList<LinkedHashMap<String,Object>>();
		int c=0;
		for(Value v:rows) {
			res.add(extract((Row)v));
			c++;
		}
		return res;
	}
	
	protected LinkedHashMap<String,Object> extract(Row row) throws IOException, ClassNotFoundException{
		LinkedHashMap<String,Object> objs=new LinkedHashMap<String,Object>();
		int pos=0;
		for(Entry<String,SchemaDescriptor> e:this.schema.descriptors.entrySet()) {
			SchemaDescriptor sd=e.getValue();
			byte[] nulls = Arrays.copyOfRange(row.array, pos, pos+2);
			byte[] slice = Arrays.copyOfRange(row.array, pos+2, pos+2+sd.getSize()+2);
			pos+=sd.getSize()+2;
		    ByteArrayInputStream in = new ByteArrayInputStream(slice);
		    DataInputStream inst=new DataInputStream(in);
		    ByteArrayInputStream inn = new ByteArrayInputStream(nulls);
		    DataInputStream instn=new DataInputStream(inn);
		    char isnull=instn.readChar();
		    if(isnull=='n') {
		    	objs.put(e.getKey(), null);
		    	continue;
		    }
		    switch(sd.getType()) {
		    case TypeConst.VALUE_TYPE_INT:
				objs.put(e.getKey(),(Object)inst.readInt());
		    	break;
		    case TypeConst.VALUE_TYPE_LONG:
				objs.put(e.getKey(),(Object)inst.readLong());
		    	break;
		    case TypeConst.VALUE_TYPE_DOUBLE:
				objs.put(e.getKey(),(Object)inst.readDouble());
		    	break;
		    case TypeConst.VALUE_TYPE_FLOAT:
				objs.put(e.getKey(),(Object)inst.readFloat());
		    	break;
		    case TypeConst.VALUE_TYPE_STRING:
				String str="";
				int len=sd.getSize()/TypeConst.VALUE_SIZE_CHAR;
		    	for(int i=0;i<len;i++) {
		    		str+=inst.readChar();
		    	}
				objs.put(e.getKey(),(Object)str);
		    	break;
		    }
		}
		return objs;
	}
	
	public void createIndex() throws IOException {
		switch(keyType) {
		case TypeConst.VALUE_TYPE_INT:
			index=new PrimaryIndex<Integer>(1024, keyType, keySize, valueSize, 1024, tableName.concat(".index"));
			break;
		case TypeConst.VALUE_TYPE_LONG:
			index=new PrimaryIndex<Long>(1024, keyType, keySize, valueSize, 1024, tableName.concat(".index"));
			break;
		case TypeConst.VALUE_TYPE_DOUBLE:
			index=new PrimaryIndex<Double>(1024, keyType, keySize, valueSize, 1024, tableName.concat(".index"));
			break;
		case TypeConst.VALUE_TYPE_FLOAT:
			index=new PrimaryIndex<Float>(1024, keyType, keySize, valueSize, 1024, tableName.concat(".index"));
			break;
		case TypeConst.VALUE_TYPE_STRING:
			index=new PrimaryIndex<String>(1024, keyType, keySize, valueSize, 1024, tableName.concat(".index"));
			break;
		}
	}
	
	public static Table loadFromFile(String path) throws ClassNotFoundException, IOException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
        Table db = (Table)ois.readObject();
        ois.close();
        return db;
	}
	
	public void storeToFile (String path) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
        oos.writeObject(this);
        oos.close();
        logToFile();
	}

	public void logToFile () throws IOException {
	    BufferedWriter writer = new BufferedWriter(new FileWriter("schema.log",true));
	    writer.append(this.tableName.concat(".schema"));
	    writer.append('\n');
	    writer.close();
	}
	
	public void update(String cdName,String cdValue,int op,String setName,String setValue) throws IOException, ClassNotFoundException {
		LinkedList<Value> rows=index.searchAll().rows;
		ArrayList<LinkedHashMap<String,Object>> rowl=fromRaw(rows);

		RowFilter rf= buildFilter(cdName,op,cdValue);
		for(LinkedHashMap<String,Object> objs:rowl) {
			if(rf.method(objs)) {
//				LinkedHashMap<String,Object> nobjs=modify(objs,cdName,cdValue);
//				Row nrow=toRow(nobjs);
//				index.update(nobjs.get(this.schema.primaryKey), nrow);
			}
		}
	}
	
//	public LinkedHashMap<String,Object> modify(LinkedHashMap<String,Object> objs,String cdName,String cdValue){
//		switch(this.schema.descriptors.get(cdName).getType()) {
//			case TypeConst.VALUE_TYPE_INT:
//			case TypeConst.VALUE_TYPE_LONG:
//			case TypeConst.VALUE_TYPE_FLOAT:
//			case TypeConst.VALUE_TYPE_DOUBLE:
//			case TypeConst.VALUE_TYPE_STRING:
//		}
//	}

	public Pair<Object,Row> mkRowB(HashMap<String,String> pairs) throws NumberFormatException, IOException {
		List<String> values=new ArrayList<String>();
		for(String key:this.schema.descriptors.keySet()) {
			if(pairs.containsKey(key)) {
				values.add(pairs.get(key));
			}
			else {
				values.add(null);
			}
		}
		return mkRow(values);
	}

	public Pair<Object,Row> mkRow(List<String> values) throws NumberFormatException, IOException {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(outputStream);
		Row row=new Row();
		Object res= null;
		Object key= null;
		int c=0;
		for(SchemaDescriptor s:schema.descriptors.values()) {
			String t=values.get(c);
			switch(s.getType()) {
			case TypeConst.VALUE_TYPE_INT:
				if(t!=null) {
					dos.writeChar(0);
					res=Integer.parseInt(t);
					dos.writeInt((Integer)res);
				}else {
					dos.writeChar('n');
					dos.writeInt(0);
				}
				break;
			case TypeConst.VALUE_TYPE_LONG:
				if(t!=null) {
					dos.writeChar(0);
					res=Long.parseLong(t);
					dos.writeLong((Long)res);
				}else {
					dos.writeChar('n');
					dos.writeLong(0);
				}
				break;
			case TypeConst.VALUE_TYPE_FLOAT:
				if(t!=null) {
					dos.writeChar(0);
					res=Float.parseFloat(t);
					dos.writeFloat((Float)res);
				}else {
					dos.writeChar('n');
					dos.writeFloat(0);
				}
				break;
			case TypeConst.VALUE_TYPE_DOUBLE:
				if(t!=null) {
					dos.writeChar(0);
					res=Double.parseDouble(t);
					dos.writeDouble((Double)res);
				}else {
					dos.writeChar('n');
					dos.writeDouble(0);
				}
				break;
			case TypeConst.VALUE_TYPE_STRING:
				if(t!=null) {
					dos.writeChar(0);
					res=t;
					dos.writeChars((String)t);
					for(int i=0;i<s.getSize()/TypeConst.VALUE_SIZE_CHAR-t.length();i++) {
						dos.writeChar(0);
					}
				}else {
					dos.writeChar('n');
					for(int i=0;i<s.getSize()/TypeConst.VALUE_SIZE_CHAR;i++) {
						dos.writeChar(0);
					}
				}
				break;
			}
			if(s.isPrimary()) {
				key=(Object)res;
			}
			c++;
		}
		dos.flush();
		byte[] array=outputStream.toByteArray();
		row.array=array;
		return new Pair<Object,Row>(key,row); 
	}


	@SuppressWarnings({ "unchecked", "null" })
	public void simpleInsert(Object key, Row row) throws IOException {
		switch(keyType) {
			case TypeConst.VALUE_TYPE_INT:
				PrimaryKey<Integer> keyi = new PrimaryKey<Integer>((Integer)key, TypeConst.VALUE_TYPE_INT, TypeConst.VALUE_SIZE_INT);
				index.insert(keyi, row);	
				break;
			case TypeConst.VALUE_TYPE_LONG:
				PrimaryKey<Long> keyl = new PrimaryKey<Long>((Long)key, TypeConst.VALUE_TYPE_LONG, TypeConst.VALUE_SIZE_LONG);
				index.insert(keyl, row);	
				break;
			case TypeConst.VALUE_TYPE_FLOAT:
				PrimaryKey<Float> keyf = new PrimaryKey<Float>((Float)key, TypeConst.VALUE_TYPE_FLOAT, TypeConst.VALUE_SIZE_FLOAT);
				index.insert(keyf, row);	
				break;
			case TypeConst.VALUE_TYPE_DOUBLE:
				PrimaryKey<Double> keyd = new PrimaryKey<Double>((Double)key, TypeConst.VALUE_TYPE_DOUBLE, TypeConst.VALUE_SIZE_DOUBLE);
				index.insert(keyd, row);	
				break;
			case TypeConst.VALUE_TYPE_STRING:
				PrimaryKey<String> keys = new PrimaryKey<String>((String)key, TypeConst.VALUE_TYPE_STRING, keySize);
				index.insert(keys, row);	
				break;
			}
	}
}
