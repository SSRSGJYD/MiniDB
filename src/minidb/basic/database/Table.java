package minidb.basic.database;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map.Entry;

import minidb.basic.database.Schema;
import minidb.basic.index.PrimaryIndex;
import minidb.basic.index.PrimaryKey;
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
				dos.writeChars((String)res);
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
				PrimaryKey<Integer> keyi = new PrimaryKey<Integer>((Integer)key);
				index.insert(keyi, row);	
				break;
			case TypeConst.VALUE_TYPE_LONG:
				PrimaryKey<Long> keyl = new PrimaryKey<Long>((Long)key);
				index.insert(keyl, row);	
				break;
			case TypeConst.VALUE_TYPE_FLOAT:
				PrimaryKey<Float> keyf = new PrimaryKey<Float>((Float)key);
				index.insert(keyf, row);	
				break;
			case TypeConst.VALUE_TYPE_DOUBLE:
				PrimaryKey<Double> keyd = new PrimaryKey<Double>((Double)key);
				index.insert(keyd, row);	
				break;
			case TypeConst.VALUE_TYPE_STRING:
				PrimaryKey<String> keys = new PrimaryKey<String>((String)key);
				index.insert(keys, row);	
				break;
			}
	}
}
