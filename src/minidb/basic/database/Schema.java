package minidb.basic.database;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;


public class Schema implements Serializable{
	
    private static final long serialVersionUID = 1L;

	HashMap<String,Byte> descriptors;
	
	public Schema() {
		descriptors=new HashMap<String,Byte>();
	}
	



}
