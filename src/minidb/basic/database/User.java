package minidb.basic.database;

import java.util.HashSet;
import java.util.Set;

public class User {
	public String username;
	public String password;
	Set<String> granteddb;
	boolean isRoot;
	
	public User(String un,String pw) {
		if(un.equals("root"))
			this.isRoot=true;
		else 
			this.isRoot=false;
		this.username=un;
		this.password=pw;
		this.granteddb=new HashSet<String>();
	}
	
	public void grantDB(String dbn) {
		this.granteddb.add(dbn);
	}
	
	public boolean isGrantedDB(String dbn) {
		return this.granteddb.contains(dbn);
	}
}

