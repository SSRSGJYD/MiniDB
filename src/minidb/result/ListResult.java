package minidb.result;

import java.util.ArrayList;

public class ListResult extends Result {

	public ArrayList<String> data;
	@Override
	public void display() {
		System.out.print(data);

	}
	@Override
	public String json() {
		// TODO Auto-generated method stub
		return null;
	}

}
