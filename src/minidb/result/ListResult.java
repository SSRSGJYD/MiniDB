package minidb.result;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ListResult extends Result {

	public ArrayList<String> data;
	@Override
	public void display() {
		System.out.print(data);

	}
	@Override
	public String json(long timeT) {

		  JSONObject obj = new JSONObject();
	      JSONArray list =new JSONArray();
	      JSONArray rows=new JSONArray();
		  list.add("name");
	      for(String row:data) {
			  JSONObject objt = new JSONObject();
			  objt.put("name", row);
	    	  rows.add(objt);
	      }
	      obj.put("attributes",list);
	      obj.put("rows",rows);
	      obj.put("time",timeT);
	      obj.put("data",true);
	      return obj.toString();

	}

}
