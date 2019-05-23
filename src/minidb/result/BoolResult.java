package minidb.result;

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
}
