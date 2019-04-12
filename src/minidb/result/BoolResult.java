package minidb.result;

public class BoolResult extends Result {
	boolean isOk;
	public BoolResult() {
		this.isOk=true;
	}
	void setFalse() {
		this.isOk=false;
	}
}
