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
			valueSize+=sd.getSize();
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
		else
			res=rowl;
		QueryResult qr=new QueryResult();
		qr.data=res;
		qr.types=this.schema.types;
		return qr;
	}
	
	protected RowFilter buildFilter(String cdName,int op,Object cdValue) {
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

	protected boolean compare(int op,int type,Object va,Object vb) {
		switch(type) {
		case TypeConst.VALUE_TYPE_INT:
			compareT(op,(Integer)va,(Integer)vb);
			break;
		case TypeConst.VALUE_TYPE_LONG:
			compareT(op,(Long)va,(Long)vb);
			break;
		case TypeConst.VALUE_TYPE_FLOAT:
			compareT(op,(Float)va,(Float)vb);
			break;
		case TypeConst.VALUE_TYPE_DOUBLE:
			compareT(op,(Double)va,(Double)vb);
			break;
		case TypeConst.VALUE_TYPE_STRING:
			compareT(op,(String)va,(String)vb);
			break;
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
			byte[] slice = Arrays.copyOfRange(row.array, pos, sd.getSize());
		    ByteArrayInputStream in = new ByteArrayInputStream(slice);
		    DataInputStream inst=new DataInputStream(in);
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
		    	String str=inst.readUTF();
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
	

	public Pair<Object,Row> mkRow(List<String> values) throws NumberFormatException, IOException {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(outputStream);
		Row row=new Row();
		Object res= null;
		Object key= null;
		int c=0;
		for(SchemaDescriptor s:schema.descriptors.values()) {
			switch(s.getType()) {
			case TypeConst.VALUE_TYPE_INT:
				res=Integer.parseInt(values.get(c));
				dos.write((Integer)res);
				break;
			case TypeConst.VALUE_TYPE_LONG:
				res=Long.parseLong(values.get(c));
				dos.writeLong((Long)res);
				break;
			case TypeConst.VALUE_TYPE_FLOAT:
				res=Float.parseFloat(values.get(c));
				dos.writeFloat((Float)res);
				break;
			case TypeConst.VALUE_TYPE_DOUBLE:
				res=Double.parseDouble(values.get(c));
				dos.writeDouble((Double)res);
				break;
			case TypeConst.VALUE_TYPE_STRING:
				res=values.get(c);
				dos.writeUTF((String)res);
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
