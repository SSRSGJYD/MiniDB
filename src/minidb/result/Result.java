package minidb.result;

public abstract class Result {
	public long time;
	public Result(){
	}
	public abstract void display();
	public abstract String json(long time);
}
