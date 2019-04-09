package minidb.basic.database;

public class Pair<L, R> {
	L l;
	R r;
	public Pair(L l,R r) {
		this.l=l;
		this.r=r;
	}
	public L getL() {
		return l;
	}
	public R getR() {
		return r;
	}
}
