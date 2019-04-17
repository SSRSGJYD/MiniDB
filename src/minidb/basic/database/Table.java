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
import minidb.basic.index.PrimaryKeyValue;
import minidb.basic.index.SecondaryIndex;
import minidb.basic.index.SecondaryKey;
import minidb.basic.index.Value;
import minidb.result.QueryResult;
import minidb.result.SearchResult;
import minidb.types.TypeConst;

public class Table implements Serializable{

	private static final long serialVersionUID = 1L;
	
	String tableName;
	Schema schema;
	transient PrimaryIndex index;
	transient HashMap<String,SecondaryIndex> indexs;
	int keySize;
	int keyType;
	int valueSize=0;
	
	public Table(String tableName,Schema schema) throws IOException {
		this.tableName=tableName;
		this.schema=schema;
		this.indexs=new HashMap<String,SecondaryIndex>();

		for(Entry<String, SchemaDescriptor> entry:schema.descriptors.entrySet()) {
			SchemaDescriptor sd=entry.getValue();
			if(sd.isPrimary()) {
				keyType=sd.getType();
				this.schema.primaryKey=entry.getKey();
				keySize=sd.getSize();
				this.createPrimaryIndex();
			}else {
				this.createSecondaryIndex(entry);
			}

			valueSize+=sd.getSize()+TypeConst.VALUE_SIZE_NULL;
		}

		this.schema.keyType=keyType;

	}
	
	public void createSecondaryIndex(Entry<String, SchemaDescriptor> entry) throws IOException {
		SchemaDescriptor sd=entry.getValue();
		SecondaryIndex si=null;
		si=new SecondaryIndex(1024, sd.getType(), sd.getSize(), keyType, keySize, keySize, 1024, tableName+"_"+entry.getKey()+".index");
		if(indexs==null)
			this.indexs=new HashMap<String,SecondaryIndex>();
		indexs.put(entry.getKey(), si);	
	}
	
	public void insertIndexs(Object key,List<String> values) throws IOException {
		int c=0;
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(outputStream);
		switch(this.keyType){
		case TypeConst.VALUE_TYPE_INT:
			dos.writeInt((Integer)key);
			break;
		case TypeConst.VALUE_TYPE_LONG:
			dos.writeLong((Long)key);
			break;
		case TypeConst.VALUE_TYPE_FLOAT:
			dos.writeFloat((Float)key);
			break;
		case TypeConst.VALUE_TYPE_DOUBLE:
			dos.writeDouble((Double)key);
			break;
		case TypeConst.VALUE_TYPE_STRING:
			dos.writeChars((String)key);
			break;
		}
		dos.flush();
		byte[] array=outputStream.toByteArray();
		for(Entry<String,SchemaDescriptor> entry:this.schema.descriptors.entrySet()) {
			if(entry.getValue().isPrimary()) {
				c++;
				continue;
			}
			this.insertSecondaryIndex(entry.getKey(), entry.getValue(), values.get(c), key,array);
			c++;
		}
	}
	
	@SuppressWarnings("unchecked")
	protected void insertSecondaryIndex(String name,SchemaDescriptor sd,String value ,Object okvalue,byte[] kvalue) throws IOException {
		@SuppressWarnings("rawtypes")
		SecondaryKey key=constructSecondaryKey(sd.getType(),sd.getSize(),value,okvalue);
		PrimaryKeyValue kv=new PrimaryKeyValue(kvalue,this.keyType);
		@SuppressWarnings("rawtypes")
		SecondaryIndex index= indexs.get(name);
		index.insert(key, kv);
	}
	
	protected LinkedHashMap<String,Object> filterNames(List<String> names,LinkedHashMap<String,Object> data){
		LinkedHashMap<String,Object> res=new LinkedHashMap<String,Object>();
		for(String name:names) {
			res.put(name, data.get(name));
		}
		return res;
		
	}
		
	protected PrimaryKey constructPrimaryKeyB(byte[] cdValue) throws IOException {
		PrimaryKey keyi=null;
		ByteArrayInputStream in = new ByteArrayInputStream(cdValue);
		DataInputStream inst=new DataInputStream(in);
		switch(this.keyType) {
			case TypeConst.VALUE_TYPE_INT:
				keyi= new PrimaryKey<Integer>(inst.readInt(), TypeConst.VALUE_TYPE_INT, TypeConst.VALUE_SIZE_INT);
				break;
			case TypeConst.VALUE_TYPE_LONG:
				keyi= new PrimaryKey<Long>(inst.readLong(), TypeConst.VALUE_TYPE_LONG, TypeConst.VALUE_SIZE_LONG);
				break;
			case TypeConst.VALUE_TYPE_FLOAT:
				keyi= new PrimaryKey<Float>(inst.readFloat(), TypeConst.VALUE_TYPE_FLOAT, TypeConst.VALUE_SIZE_FLOAT);
				break;
			case TypeConst.VALUE_TYPE_DOUBLE:
				keyi= new PrimaryKey<Double>(inst.readDouble(), TypeConst.VALUE_TYPE_DOUBLE, TypeConst.VALUE_SIZE_DOUBLE);
				break;
			case TypeConst.VALUE_TYPE_STRING:
				String str="";
				int len=this.keySize/TypeConst.VALUE_SIZE_CHAR;
		    	for(int i=0;i<len;i++) {
		    		str+=inst.readChar();
		    	}
				keyi= new PrimaryKey<String>(str, TypeConst.VALUE_TYPE_STRING, this.keySize);
				break;
			}
		return keyi;

	}

	protected PrimaryKey constructPrimaryKey(String cdValue) {
		PrimaryKey keyi=null;
		switch(this.keyType) {
			case TypeConst.VALUE_TYPE_INT:
				keyi= new PrimaryKey<Integer>(Integer.parseInt(cdValue), TypeConst.VALUE_TYPE_INT, TypeConst.VALUE_SIZE_INT);
				break;
			case TypeConst.VALUE_TYPE_LONG:
				keyi= new PrimaryKey<Long>(Long.parseLong(cdValue), TypeConst.VALUE_TYPE_LONG, TypeConst.VALUE_SIZE_LONG);
				break;
			case TypeConst.VALUE_TYPE_FLOAT:
				keyi= new PrimaryKey<Float>(Float.parseFloat(cdValue), TypeConst.VALUE_TYPE_FLOAT, TypeConst.VALUE_SIZE_FLOAT);
				break;
			case TypeConst.VALUE_TYPE_DOUBLE:
				keyi= new PrimaryKey<Double>(Double.parseDouble(cdValue), TypeConst.VALUE_TYPE_DOUBLE, TypeConst.VALUE_SIZE_DOUBLE);
				break;
			case TypeConst.VALUE_TYPE_STRING:
				keyi= new PrimaryKey<String>(cdValue, TypeConst.VALUE_TYPE_STRING, keySize);
				break;
			}
		return keyi;

	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected SecondaryKey constructSecondaryKey(int type,int size,String cdValue, Object keyValue) {
			SecondaryKey keyr = null;
			switch(type) {
			case TypeConst.VALUE_TYPE_INT:
				switch(keyType) {
				case TypeConst.VALUE_TYPE_INT:
					keyr= new SecondaryKey(Integer.parseInt(cdValue), TypeConst.VALUE_TYPE_INT, TypeConst.VALUE_SIZE_INT,(Integer)keyValue,keyType,keySize);
					break;
				case TypeConst.VALUE_TYPE_LONG:
					keyr= new SecondaryKey(Integer.parseInt(cdValue), TypeConst.VALUE_TYPE_INT, TypeConst.VALUE_SIZE_INT,(Long)keyValue,keyType,keySize);
					break;
				case TypeConst.VALUE_TYPE_FLOAT:
					keyr= new SecondaryKey(Integer.parseInt(cdValue), TypeConst.VALUE_TYPE_INT, TypeConst.VALUE_SIZE_INT,(Float)keyValue,keyType,keySize);
					break;
				case TypeConst.VALUE_TYPE_DOUBLE:
					keyr= new SecondaryKey(Integer.parseInt(cdValue), TypeConst.VALUE_TYPE_INT, TypeConst.VALUE_SIZE_INT,(Double)keyValue,keyType,keySize);
					break;
				case TypeConst.VALUE_TYPE_STRING:
					keyr= new SecondaryKey(Integer.parseInt(cdValue), TypeConst.VALUE_TYPE_INT, TypeConst.VALUE_SIZE_INT,(String)keyValue,keyType,keySize);
					break;
				}
				break;
			case TypeConst.VALUE_TYPE_LONG:
				switch(keyType) {
				case TypeConst.VALUE_TYPE_INT:
					keyr= new SecondaryKey(Long.parseLong(cdValue), TypeConst.VALUE_TYPE_LONG, TypeConst.VALUE_SIZE_LONG,(Integer)keyValue,keyType,keySize);
					break;
				case TypeConst.VALUE_TYPE_LONG:
					keyr= new SecondaryKey(Long.parseLong(cdValue), TypeConst.VALUE_TYPE_LONG, TypeConst.VALUE_SIZE_LONG,(Long)keyValue,keyType,keySize);
					break;
				case TypeConst.VALUE_TYPE_FLOAT:
					keyr= new SecondaryKey(Long.parseLong(cdValue), TypeConst.VALUE_TYPE_LONG, TypeConst.VALUE_SIZE_LONG,(Float)keyValue,keyType,keySize);
					break;
				case TypeConst.VALUE_TYPE_DOUBLE:
					keyr= new SecondaryKey(Long.parseLong(cdValue), TypeConst.VALUE_TYPE_LONG, TypeConst.VALUE_SIZE_LONG,(Double)keyValue,keyType,keySize);
					break;
				case TypeConst.VALUE_TYPE_STRING:
					keyr= new SecondaryKey(Long.parseLong(cdValue), TypeConst.VALUE_TYPE_LONG, TypeConst.VALUE_SIZE_LONG,(String)keyValue,keyType,keySize);
					break;
				}
				break;
			case TypeConst.VALUE_TYPE_FLOAT:
				switch(keyType) {
				case TypeConst.VALUE_TYPE_INT:
					keyr= new SecondaryKey(Float.parseFloat(cdValue), TypeConst.VALUE_TYPE_FLOAT, TypeConst.VALUE_SIZE_FLOAT,(Integer)keyValue,keyType,keySize);
					break;
				case TypeConst.VALUE_TYPE_LONG:
					keyr= new SecondaryKey(Float.parseFloat(cdValue), TypeConst.VALUE_TYPE_FLOAT, TypeConst.VALUE_SIZE_FLOAT,(Long)keyValue,keyType,keySize);
					break;
				case TypeConst.VALUE_TYPE_FLOAT:
					keyr= new SecondaryKey(Float.parseFloat(cdValue), TypeConst.VALUE_TYPE_FLOAT, TypeConst.VALUE_SIZE_FLOAT,(Float)keyValue,keyType,keySize);
					break;
				case TypeConst.VALUE_TYPE_DOUBLE:
					keyr= new SecondaryKey(Float.parseFloat(cdValue), TypeConst.VALUE_TYPE_FLOAT, TypeConst.VALUE_SIZE_FLOAT,(Double)keyValue,keyType,keySize);
					break;
				case TypeConst.VALUE_TYPE_STRING:
					keyr= new SecondaryKey(Float.parseFloat(cdValue), TypeConst.VALUE_TYPE_FLOAT, TypeConst.VALUE_SIZE_FLOAT,(String)keyValue,keyType,keySize);
					break;
				}
			case TypeConst.VALUE_TYPE_DOUBLE:
				switch(keyType) {
				case TypeConst.VALUE_TYPE_INT:
					keyr= new SecondaryKey(Double.parseDouble(cdValue), TypeConst.VALUE_TYPE_DOUBLE, TypeConst.VALUE_SIZE_DOUBLE,(Integer)keyValue,keyType,keySize);
					break;
				case TypeConst.VALUE_TYPE_LONG:
					keyr= new SecondaryKey(Double.parseDouble(cdValue), TypeConst.VALUE_TYPE_DOUBLE, TypeConst.VALUE_SIZE_DOUBLE,(Long)keyValue,keyType,keySize);
					break;
				case TypeConst.VALUE_TYPE_FLOAT:
					keyr= new SecondaryKey(Double.parseDouble(cdValue), TypeConst.VALUE_TYPE_DOUBLE, TypeConst.VALUE_SIZE_DOUBLE,(Float)keyValue,keyType,keySize);
					break;
				case TypeConst.VALUE_TYPE_DOUBLE:
					keyr= new SecondaryKey(Double.parseDouble(cdValue), TypeConst.VALUE_TYPE_DOUBLE, TypeConst.VALUE_SIZE_DOUBLE,(Double)keyValue,keyType,keySize);
					break;
				case TypeConst.VALUE_TYPE_STRING:
					keyr= new SecondaryKey(Double.parseDouble(cdValue), TypeConst.VALUE_TYPE_DOUBLE, TypeConst.VALUE_SIZE_DOUBLE,(String)keyValue,keyType,keySize);
					break;
				}
			case TypeConst.VALUE_TYPE_STRING:
				switch(keyType) {
				case TypeConst.VALUE_TYPE_INT:
					keyr= new SecondaryKey(cdValue, TypeConst.VALUE_TYPE_STRING, size,(Integer)keyValue,keyType,keySize);
					break;
				case TypeConst.VALUE_TYPE_LONG:
					keyr= new SecondaryKey(cdValue, TypeConst.VALUE_TYPE_STRING, size,(Long)keyValue,keyType,keySize);
					break;
				case TypeConst.VALUE_TYPE_FLOAT:
					keyr= new SecondaryKey(cdValue, TypeConst.VALUE_TYPE_STRING, size,(Float)keyValue,keyType,keySize);
					break;
				case TypeConst.VALUE_TYPE_DOUBLE:
					keyr= new SecondaryKey(cdValue, TypeConst.VALUE_TYPE_STRING, size,(Double)keyValue,keyType,keySize);
					break;
				case TypeConst.VALUE_TYPE_STRING:
					keyr= new SecondaryKey(cdValue, TypeConst.VALUE_TYPE_STRING, size,(String)keyValue,keyType,keySize);
					break;
				}
			}

			return keyr;
	}
	protected LinkedList<Row> searchRows(String cdName,String cdValue, int op) throws IOException{
		LinkedList<Row> rows=null;
		if(this.schema.primaryKey.equalsIgnoreCase(cdName)) {
			@SuppressWarnings("rawtypes")
			PrimaryKey keyi=constructPrimaryKey(cdValue);
			rows=searchByOp(keyi,op);
		}else {
			SchemaDescriptor sd=this.schema.descriptors.get(cdName);
			@SuppressWarnings("rawtypes")
			SecondaryKey keyr=constructSecondaryKey(sd.getType(),sd.getSize(),cdValue,null);
			rows=searchByOpS(keyr,cdName,op);
		}
		return rows;

	}

	@SuppressWarnings("unchecked")
	protected QueryResult query(List<String> names,Boolean existWhere,String cdName,String cdValue, int op) throws IOException, ClassNotFoundException {
		LinkedList<Row> rows=null;
		if(!existWhere) {
			rows=index.searchAll().rows;
			QueryResult qr=new QueryResult();
			ArrayList<LinkedHashMap<String,Object>> rowl=fromRaw(rows);
			qr.data=rowl;
			qr.types=this.schema.types;
			return qr;
		}
		else
			rows=searchRows(cdName,cdValue,op);
		QueryResult qr=new QueryResult();
		ArrayList<LinkedHashMap<String,Object>> res=new ArrayList<LinkedHashMap<String,Object>>();
		ArrayList<LinkedHashMap<String,Object>> rowl=fromRaw(rows);
		for(LinkedHashMap<String,Object> objs:rowl) {
			LinkedHashMap<String,Object> nobjs=filterNames(names,objs);
			res.add(nobjs);
		}
	
		qr.data=res;
		qr.types=this.schema.types;
		return qr;
	}
		@SuppressWarnings("unchecked")
	protected LinkedList<Row> searchByOpS(@SuppressWarnings("rawtypes") SecondaryKey key,String keyName,int op) throws IOException{
		SecondaryIndex indext=indexs.get(keyName);
		LinkedList<PrimaryKeyValue> vs = null;
		LinkedList<Row> rows = new LinkedList<Row>();
		switch(op) {
		case Statement.lg:
			vs= indext.searchByRange(key, true, true, null, false, true,false).rows;
			break;
		case Statement.lt:
			vs= indext.searchByRange(null, false, true,key, true, true,false).rows;
			break;
		case Statement.lge:
			vs= indext.searchByRange(key, true, false, null, false, true,false).rows;
			break;
		case Statement.lte:
			vs= indext.searchByRange(null, false, true,key, true, false,false).rows;
			break;
		case Statement.eq:
			vs= indext.search(key,false).rows;
			break;
		}
		for(PrimaryKeyValue pk:vs) {
			PrimaryKey pkey=this.constructPrimaryKeyB(pk.array);
			rows.addAll(index.search(pkey).rows);
		}
		return rows;

	}

	@SuppressWarnings("unchecked")
	protected LinkedList<Row> searchByOp(@SuppressWarnings("rawtypes") PrimaryKey key,int op) throws IOException{
		switch(op) {
		case Statement.lg:
			return index.searchByRange(key, true, true, null, false, true).rows;
		case Statement.lt:
			return index.searchByRange(null, false, true,key, true, true).rows;
		case Statement.lge:
			return index.searchByRange(key, true, false, null, false, true).rows;
		case Statement.lte:
			return index.searchByRange(null, false, true,key, true, false).rows;
		case Statement.eq:
			return index.search(key).rows;
		}
		return null;
	}
	protected QueryResult queryx(List<String> names,Boolean existWhere,String cdName,String cdValue, int op) throws IOException, ClassNotFoundException {
		@SuppressWarnings("unchecked")
		LinkedList<Row> rows=index.searchAll().rows;
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

	protected ArrayList<LinkedHashMap<String,Object>> fromRaw(LinkedList<Row> rows) throws ClassNotFoundException, IOException{
		ArrayList<LinkedHashMap<String,Object>> res=new ArrayList<LinkedHashMap<String,Object>>();
		int c=0;
		for(Row v:rows) {
			res.add(extract(v));
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
			byte[] slice = Arrays.copyOfRange(row.array, pos+2, pos+2+sd.getSize());
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
	
	public void createPrimaryIndex() throws IOException {
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
		LinkedList<Row> rows=searchRows(cdName,cdValue,op);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(outputStream);
		int pos=0;
		int keypos=0;
		int keysize=0;
		int ktype = 0;
		int ksize=0;
		for(Entry<String,SchemaDescriptor> entry:this.schema.descriptors.entrySet()) {
			if(entry.getValue().isPrimary()) {
				keysize=entry.getValue().getSize();
				break;
			}else {
				keypos+=2+entry.getValue().getSize();
			}
		}
		for(Entry<String,SchemaDescriptor> entry:this.schema.descriptors.entrySet()) {
			if(entry.getKey().equals(setName)) {
				ktype=entry.getValue().getType();
				ksize=entry.getValue().getSize();
				break;
			}else {
				pos+=2+entry.getValue().getSize();
			}
		}
		dos.writeChar(0);
		Object res;
		switch(ktype) {
		case TypeConst.VALUE_TYPE_INT:
				res=Integer.parseInt(setValue);
				dos.writeInt((Integer)res);
			break;
		case TypeConst.VALUE_TYPE_LONG:
				res=Long.parseLong(setValue);
				dos.writeLong((Long)res);
			break;
		case TypeConst.VALUE_TYPE_FLOAT:
				res=Float.parseFloat(setValue);
				dos.writeFloat((Float)res);
			break;
		case TypeConst.VALUE_TYPE_DOUBLE:
				res=Double.parseDouble(setValue);
				dos.writeDouble((Double)res);
			break;
		case TypeConst.VALUE_TYPE_STRING:
				dos.writeChars((String)setValue);
				for(int i=0;i<ksize/TypeConst.VALUE_SIZE_CHAR-setValue.length();i++) {
					dos.writeChar(0);
				}
			break;
		}

		dos.flush();
		byte[] array=outputStream.toByteArray();

		for(Row row:rows) {
			for(int i=pos;i<pos+ksize+2;i++) {
				row.array[i]=array[i];
			}
			byte[] slice = Arrays.copyOfRange(row.array, keypos+2, keysize);
			ByteArrayInputStream in = new ByteArrayInputStream(slice);
			DataInputStream inst=new DataInputStream(in);
			Object key=null;
			switch(keyType) {
			case TypeConst.VALUE_TYPE_INT:
				key=(Object)inst.readInt();
				break;
			case TypeConst.VALUE_TYPE_LONG:
				key=(Object)inst.readLong();
				break;
			case TypeConst.VALUE_TYPE_FLOAT:
				key=(Object)inst.readFloat();
				break;
			case TypeConst.VALUE_TYPE_DOUBLE:
				key=(Object)inst.readDouble();
				break;
			case TypeConst.VALUE_TYPE_STRING:
				String str="";
				int len=keySize/TypeConst.VALUE_SIZE_CHAR;
		    	for(int i=0;i<len;i++) {
		    		str+=inst.readChar();
		    	}
		    	key=(Object)str;
				break;
			}
			this.simpleInsert(key, row);
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
