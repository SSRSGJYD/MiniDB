package minidb.basic.database;

import java.io.Serializable;


public class SchemaDescriptor implements Serializable{

	private static final long serialVersionUID = 1L;
	
	byte descriptor;
	
	public SchemaDescriptor(){	
	}
	
	public int getType() {
		return 0b1111&(descriptor>>4);
	}
	public boolean isNotNull() {
		return 0!=(0b0001&descriptor);
	}
	public boolean isPrimary() {
		return 0!=(0b0010&descriptor);
	}
	public void setNotNull(boolean is) {
		descriptor=(byte) (is?(descriptor|0b0001):(descriptor&0b1110));
	}
	public void setPrimary(boolean is) {
		descriptor=(byte) (is?(descriptor|0b0010):(descriptor&0b1101));
	}
	public void setType(int type) {
		descriptor=(byte) (descriptor|type<<4);
	}
}
