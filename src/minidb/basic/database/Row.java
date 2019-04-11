package minidb.basic.database;

import minidb.basic.index.Value;

public class Row extends Value {
	public byte[] array;
    public Row() {
        super();
    }

    public Row(byte[] fileContent) {
    	array=fileContent;
    }
}
