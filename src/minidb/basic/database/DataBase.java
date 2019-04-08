package minidb.basic.database;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.HashMap; 

public class DataBase implements Serializable{
	
	private static final long serialVersionUID = 1L;

	String name;
	HashMap<String,Table> tables;
	transient String currentTable;
	
	
	public DataBase() {
		// TODO 
		tables=new HashMap<String,Table>();
	}
	
	public void open() {
		//load schema from disk to memory
    	//load index
    }
	
	public void execute(Statement st) {
		switch(st.type) {
		case Statement.create:
			StatementCreate sc=(StatementCreate) st;
			Schema sa=new Schema(sc.descriptors);
			Table tb=new Table(sc.tableName,sa);
			addTable(tb);
			break;
		case Statement.drop:
			StatementDrop sd=(StatementDrop) st;
			dropTable(sd.tableName);
			break;
		}
	}
	
	protected static DataBase loadFromFile(String path) throws ClassNotFoundException, IOException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
        DataBase db = (DataBase)ois.readObject();
        ois.close();
        return db;
	}
	
	protected void storeToFile (String path) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
        oos.writeObject(this);
        oos.close();
	}

	
	protected void addTable(Table tb) {
		tables.put(tb.tableName, tb);
	}
	
	public void createTable(String tableName, Schema sc) {
		Table tb=new Table(tableName,sc);
		addTable(tb);
		//TODO insert into schema file
	}
	
	public void dropTable(String name) {
		tables.remove(name);
		//TODO remove from index and schema file
	}

	public static void main(String[] args) throws UnsupportedEncodingException, IOException, ClassNotFoundException {
		Schema sc = new Schema();
		SchemaDescriptor sd=new SchemaDescriptor();
		sd.setNotNull(true);
		sd.setType(1);
		sc.descriptors.put("1223", sd);

		Table tb=new Table("table", sc);
		DataBase db=new DataBase();
		db.name="dba";
		db.tables.put(tb.tableName, tb);
		db.storeToFile("filea");
		
		DataBase db1=DataBase.loadFromFile("filea");
		return;
		
	}

	
}
