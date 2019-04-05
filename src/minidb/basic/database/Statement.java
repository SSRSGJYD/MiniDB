package minidb.basic.database;

import minidb.basic.database.DataBase;

public abstract class Statement {
	
	StatementType stType;
	
	
	public enum StatementType
	{ 
	    Create,Drop,Insert,Delete,Update,Select; 
	}

	
	public abstract Result execute(DataBase db);
	
}
