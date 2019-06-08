package minidb.result;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class QueryResult extends Result {
	//TODO HashMap
	public ArrayList<LinkedHashMap<String,Object>> data;
	public LinkedHashMap<String,Integer> types;
	public ArrayList<String> names;
	public QueryResult() {
	}
	@Override
	public void display() {
		System.out.print(data);
	}
	@SuppressWarnings("unchecked")
	public String json(long timeT) {
		  JSONObject obj = new JSONObject();
	      JSONArray list =new JSONArray();
	      JSONArray rows=new JSONArray();
	      for(String at:names) {
	    	  list.add(at);
	      }
	      for(LinkedHashMap<String,Object> row:data) {
			  JSONObject objt = new JSONObject();
	    	  for(Map.Entry<String,Object> e:row.entrySet()) {
	    		  objt.put(e.getKey(), e.getValue());
	    	  }
	    	  rows.add(objt);
	      }
	      obj.put("attributes",list);
	      obj.put("rows",rows);
	      obj.put("time",timeT);
	      obj.put("data",true);
	      return obj.toString();

	}
}
