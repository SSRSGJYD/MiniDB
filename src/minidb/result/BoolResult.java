package minidb.result;
import org.json.simple.JSONObject;


public class BoolResult extends Result {
	boolean isOk;
	public BoolResult() {
		this.isOk=true;
	}
	public BoolResult(boolean res) {
		this.isOk=res;
	}
	public void setFalse() {
		this.isOk=false;
	}
	@Override
	public void display() {
		System.out.println(isOk);
	}

	public String json(long timeT) {
		JSONObject obj=new JSONObject();
		obj.put("msg", "");
	    obj.put("data",false);
	    obj.put("time",timeT);
		return obj.toString();
	}

}
