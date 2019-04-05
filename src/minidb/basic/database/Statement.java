package minidb.basic.database;

public abstract class Statement {
	
	StatementType stType;
	
	
	public enum StatementType
	{ 
	    Create,Drop,Insert,Delete,Update,Select; 
	}
	public enum DataType
	{ 
		Int,Long,Float,Double,String; 
	}
	
}
