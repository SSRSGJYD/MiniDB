package minidb.basic.database;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class User  implements Serializable{
	private static final long serialVersionUID = 1L;

	public String username;
	public String password;
	Set<String> granteddb;
	HashMap<String,HashMap<String,Permission>> perms;
	boolean isRoot;
	
	public User(String un,String pw) {
		String rootun="root";
		if(un.equals(rootun)) {
			this.isRoot=true;
		}
		else 
			this.isRoot=false;
		this.username=un;
		this.password=pw;
		this.granteddb=new HashSet<String>();
		perms=new HashMap<String,HashMap<String,Permission>>();
	}
	
	public void grantDB(String dbn) {
		this.granteddb.add(dbn);
		perms.put(dbn, new HashMap<String,Permission>());
	}

	public void revokePerm(String dbn,String tbn,Permission pm) {
		if(perms.containsKey(dbn)) {
			HashMap<String,Permission> map=perms.get(dbn);
			if(map.containsKey(tbn)) {
				map.get(tbn).revoke(pm);
			}
		}
	}
	
	public void grantPerm(String dbn,String tbn,Permission pm) {
		if(perms.containsKey(dbn)) {
			HashMap<String,Permission> map=perms.get(dbn);
			if(map.containsKey(tbn)) {
				map.get(tbn).merge(pm);
			}
			else {
				map.put(tbn, pm);
			}
		}
		else {
			HashMap<String,Permission> map=new HashMap<String,Permission>();
			map.put(tbn,pm);
			perms.put(dbn, map);
		}
	}
	
	public boolean isGrantedDB(String dbn) {
		return this.granteddb.contains(dbn);
	}
}

