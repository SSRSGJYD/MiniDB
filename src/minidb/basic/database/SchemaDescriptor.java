package minidb.basic.database;

import java.io.Serializable;


public class SchemaDescriptor implements Serializable{

	private static final long serialVersionUID = 1L;
	
	int descriptor;
	
	public SchemaDescriptor(){	
		descriptor=0;
	}
	
	public int getType() {
		return 0b1111&(descriptor>>4);
	}
	public int getSize() {
		return 0xffff&(descriptor>>16);
	}

	public boolean isNotNull() {
		return 0!=(0b0001&descriptor);
	}
	public boolean isPrimary() {
		return 0!=(0b0010&descriptor);
	}
	public void setNotNull() {
		descriptor=(int) descriptor|0b0001;
	}
	public void setPrimary() {
		descriptor=(int) descriptor|0b0010;
	}
	public void setType(int type) {
		descriptor=(int) ((descriptor&0xffffff0f)|type<<4);
	}
	public void setSize(int size) {
		descriptor=(int) ((descriptor&0x0000ffff)|size<<16);
	}
}
