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
	
	
	
	public static byte[] serialize(Schema sc) throws UnsupportedEncodingException, IOException  {
        ByteArrayOutputStream byteOutStream = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(byteOutStream);
       
        oos.writeObject(sc);
        oos.flush();
        return byteOutStream.toByteArray();

	}
	
	public static Schema desierialize(byte[] bytes) throws ClassNotFoundException, IOException {
		ByteArrayInputStream byteInStream = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(byteInStream);
        Schema sc = (Schema)ois.readObject();
        ois.close();
        return sc;
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException, IOException, ClassNotFoundException {
		Schema sc = new Schema();
		sc.descriptors.put("1223", (byte)12);
		sc.descriptors.put("1224", (byte)112);
		byte[] arr=Schema.serialize(sc);
		Schema sb= Schema.desierialize(arr);
		return;
		
	}



}
