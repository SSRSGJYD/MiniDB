package minidb.basic.database;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import minidb.result.BoolResult;
import minidb.result.ListResult;
import minidb.result.Result;

public class MiniDB {
	HashMap<String,DataBase> dbs;
	HashMap<String,User> users;
	DataBase current;
	User curUser;
	
	public MiniDB(){
		dbs=new HashMap<String,DataBase>();
		curUser=new User("root","root");
		users=new HashMap<String,User> ();
		users.put("root", curUser);
	}
	
	public void createUser(String un,String pw) {
		users.put(un, new User(un,pw));
	}
	public boolean login(String un,String pw) {
		User user=users.get(un);
		if(user.password==pw) {
			curUser=user;
			return true;
		}
		return false;
	}


	public Result execute(Statement st) throws IOException, ClassNotFoundException {
		Result res = null;
		if(st.type==Statement.User) {
			StatementUser suser=(StatementUser)st;
			switch(suser.stType) {
			case StatementUser.grant:
				Permission pm=new Permission();
				if(suser.perm.equals("select")) {
					pm.canSelect=true;
					if(suser.isOption) {
						pm.canGrantSelect=true;
					}
				}else if(suser.perm.equals("update")) {
					pm.canUpdate=true;
					if(suser.isOption) {
						pm.canGrantUpdate=true;
					}
				}
				users.get(suser.userName).grantPerm(current.name, suser.tableName, pm);
				break;
			case StatementUser.revoke:
				pm=new Permission();
				if(suser.perm.equals("select")) {
					pm.canSelect=false;
					pm.canGrantSelect=false;
					pm.canUpdate=true;
					pm.canGrantUpdate=true;
				}else if(suser.perm.equals("update")) {
					pm.canSelect=true;
					pm.canGrantSelect=true;
					pm.canUpdate=false;
					pm.canGrantUpdate=false;
				}
				users.get(suser.userName).revokePerm(current.name, suser.tableName, pm);
				break;
			}
		}
		else if(st.type==Statement.DB) {
			StatementDB sdb=(StatementDB)st;
			switch(sdb.stType) {
			case StatementDB.create:
				DataBase db=new DataBase(sdb.dbName);
				dbs.put(sdb.dbName, db);
				if(this.curUser.isRoot)
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
				dbs.remove(sdb.dbName);
				res=new BoolResult();
				break;
			case StatementDB.use:
				if(!curUser.isGrantedDB(sdb.dbName)) {
					res=new BoolResult(false);
					return res;
				}

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
			res=current.execute(st,curUser.perms.get(current.name),curUser.isRoot);
		}
		return res;
	}
	
}
