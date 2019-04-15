package minidb.basic.database;

import minidb.basic.index.Value;

public class Row extends Value {
    public Row() {
        super();
    }

    public Row(byte[] fileContent) {
    	super(fileContent);
    }
}
