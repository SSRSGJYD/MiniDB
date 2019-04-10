package minidb.basic.database;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

import minidb.basic.database.Schema;
import minidb.basic.index.PrimaryIndex;
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
		for(SchemaDescriptor sd:schema.descriptors.values()) {
			if(sd.isPrimary()) {
				keyType=sd.getType();
				keySize=TypeConst.type2size(sd.getType());
			}
			valueSize+=TypeConst.type2size(sd.getType());
		}
		switch(keyType) {
		case TypeConst.VALUE_TYPE_INT:
			index=new PrimaryIndex<Integer>(1024, keySize, valueSize, 1024, tableName);
			break;
		case TypeConst.VALUE_TYPE_LONG:
			index=new PrimaryIndex<Long>(1024, keySize, valueSize, 1024, tableName);
			break;
		case TypeConst.VALUE_TYPE_DOUBLE:
			index=new PrimaryIndex<Double>(1024, keySize, valueSize, 1024, tableName);
			break;
		case TypeConst.VALUE_TYPE_FLOAT:
			index=new PrimaryIndex<Float>(1024, keySize, valueSize, 1024, tableName);
			break;
		case TypeConst.VALUE_TYPE_STRING:
			index=new PrimaryIndex<String>(1024, keySize, valueSize, 1024, tableName);
			break;
		}
		
	}
		
	protected static Table loadFromFile(String path) throws ClassNotFoundException, IOException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
        Table db = (Table)ois.readObject();
        ois.close();
        return db;
	}
	
	protected void storeToFile (String path) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
        oos.writeObject(this);
        oos.close();
	}


	public Row mkRow(List<String> values) {
		return null;
	}


	public void simpleInsert(Row row) {
			
	}
}
