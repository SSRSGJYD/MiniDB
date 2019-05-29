package minidb.basic.database;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import minidb.result.BoolResult;
import minidb.result.ListResult;
import minidb.result.Result;
import minidb.types.TypeConst;

public class MiniDB {
	HashMap<String,DataBase> dbs;
	HashMap<String,User> users;
	DataBase current;
	User curUser;
	
	public MiniDB() throws ClassNotFoundException, IOException{
		dbs=new HashMap<String,DataBase>();
		curUser=new User("root","root");
		users=new HashMap<String,User> ();
		users.put("root", curUser);
		this.open();
	}
	
	public void createUser(String un,String pw) {
		users.put(un, new User(un,pw));
	}
	
	@SuppressWarnings("unchecked")
	public String getInfo() {
		JSONArray objs=new JSONArray();
		for(DataBase db:dbs.values()) {
			JSONObject obj=new JSONObject();
			JSONArray list=new JSONArray();
			for(Table tb:db.tables.values()) {
				JSONObject table=new JSONObject();
				table.put("schema_name", tb.tableName);
				JSONArray attrs=new JSONArray();
				for(Map.Entry<String,SchemaDescriptor> e:tb.schema.descriptors.entrySet()) {
					JSONObject objt=new JSONObject();
					objt.put("name",e.getKey());
					objt.put("type",TypeConst.toString(e.getValue().getType()));
					attrs.add(objt);
				}
				table.put("attributes", attrs);
				list.add(table);
			}
			obj.put("database_name",current.dbName);
			obj.put("schemas",list);
			objs.add(obj);
		}
		return objs.toString();
	}
	public boolean login(String un,String pw) {
		User user=users.get(un);
		if(user.password==pw) {
			curUser=user;
			return true;
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public void loadUserFromFile() throws ClassNotFoundException, IOException {
		File file = new File("user.data"); 
		if(!file.exists())
			return;

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.data"));
        users = (HashMap<String, User>) ois.readObject();
        ois.close();
	}
	
	public void storeUserToFile () throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.data"));
        oos.writeObject(this.users);
        oos.close();
	}


	public void open() throws IOException, ClassNotFoundException {
		this.loadUserFromFile();
		System.out.print(users);
		File file = new File("log.dbs"); 
		if(!file.exists())
			return;
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader(file)); 
		String st; 

		while ((st = br.readLine()) != null) {
			DataBase temp=new DataBase(st);
			dbs.put(st, temp);
			temp.open();
		}

    }


	public Result execute(Statement st) throws IOException, ClassNotFoundException {
		Result res = null;
		if(st.type==Statement.User) {
			StatementUser suser=(StatementUser)st;
			User user=new User(suser.username,suser.password);
			users.put(suser.username, user);
			this.storeUserToFile();
			res=new BoolResult();
		}
		else if(st.type==Statement.Perm) {
			StatementPerm sperm=(StatementPerm)st;
			Permission permT=curUser.perms.get(current.dbName).get(sperm.tableName);
			switch(sperm.stType) {
			case StatementPerm.grant:
				Permission pm=new Permission();
				if(sperm.perm.equals("select")) {
					if(curUser.isRoot||(permT!=null&&permT.canGrantSelect)) {
						pm.canSelect=true;
						if(sperm.isOption) {
							pm.canGrantSelect=true;
						}
					}
					else {
						throw new IllegalArgumentException("permission not granted");
					}
				}else if(sperm.perm.equals("update")) {
					if(curUser.isRoot||(permT!=null&&permT.canGrantUpdate)) {
						pm.canUpdate=true;
						if(sperm.isOption) {
							pm.canGrantUpdate=true;
						}
					}
					else {
						throw new IllegalArgumentException("permission not granted");
					}
				}
				users.get(sperm.userName).grantPerm(current.dbName, sperm.tableName, pm);
				break;
			case StatementPerm.revoke:
				pm=new Permission();
				if(sperm.perm.equals("select")) {
					pm.canSelect=false;
					pm.canGrantSelect=false;
					pm.canUpdate=true;
					pm.canGrantUpdate=true;
				}else if(sperm.perm.equals("update")) {
					pm.canSelect=true;
					pm.canGrantSelect=true;
					pm.canUpdate=false;
					pm.canGrantUpdate=false;
				}
				users.get(sperm.userName).revokePerm(current.dbName, sperm.tableName, pm);
				break;
			}
			this.storeUserToFile();
			res=new BoolResult();
		}
		else if(st.type==Statement.DB) {
			StatementDB sdb=(StatementDB)st;
			switch(sdb.stType) {
			case StatementDB.create:
				DataBase db=new DataBase(sdb.dbName);
				this.logToFile(sdb.dbName);
				dbs.put(sdb.dbName, db);
//				if(this.curUser.isRoot)
					this.curUser.grantDB(sdb.dbName);
				res=new BoolResult();
				break;
			case StatementDB.drop:
				if(!curUser.isGrantedDB(sdb.dbName)) {
					res=new BoolResult(false);
					return res;
				}
				if(!dbs.containsKey(sdb.dbName)) {
					throw new IllegalArgumentException("database not exist");
				}


				this.dropTable(sdb.dbName);

				res=new BoolResult();
				break;
			case StatementDB.use:
//				if(!curUser.isGrantedDB(sdb.dbName)) {
//					throw new IllegalArgumentException("no database permission");
//				}

				if(!dbs.containsKey(sdb.dbName)) {
					throw new IllegalArgumentException("database not exist");
				}
				current=dbs.get(sdb.dbName);
				res=new BoolResult();
				break;
			case StatementDB.show:
				ListResult lr=new ListResult();
				ArrayList<String> ls=new ArrayList<String>(dbs.keySet());
				lr.data=ls;
				res=lr;
				break;
			case StatementDB.showdb:
				if(!dbs.containsKey(sdb.dbName)) {
					throw new IllegalArgumentException("database not exist");
				}
				DataBase tdb=dbs.get(sdb.dbName);
				ListResult tlr=new ListResult();
				ArrayList<String> tls=new ArrayList<String>(tdb.tables.keySet());
				tlr.data=tls;
				res=tlr;
				break;
			}
				
		}
		else {
			res=current.execute(st,curUser.perms.get(current.dbName),curUser.isRoot);
		}
		return res;
	}

	private void dropTable(String dbName) throws IOException {
		File file = new File("log.dbs");
		file.delete();
		this.refreshLog();
		DataBase db = dbs.get(dbName);
		for(String name:db.tables.keySet()) {
			db.dropTable(name);
		}
		dbs.remove(dbName);
	}

	private void logToFile(String dbName) throws IOException {
	    BufferedWriter writer = new BufferedWriter(new FileWriter("log.dbs",true));
	    writer.append(dbName);
	    writer.append('\n');
	    writer.close();
	}
	protected void refreshLog() throws IOException {
	    BufferedWriter writer = new BufferedWriter(new FileWriter("log.dbs",true));
		for(String name:dbs.keySet()) {
			writer.append(name);
			writer.append('\n');
		}
	    writer.close();
	}

}
