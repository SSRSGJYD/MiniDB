package minidb.result;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class QueryResult extends Result {
	//TODO HashMap
	public ArrayList<LinkedHashMap<String,Object>> data;
	public HashMap<String,Integer> types;
	public QueryResult() {
	}
	@Override
	public void display() {
		System.out.print(data);
	}
}
