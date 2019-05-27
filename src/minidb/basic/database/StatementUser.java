package minidb.basic.database;

public class StatementUser extends Statement {

	public String username;
	public String password;
	public StatementUser() {
		this.type=Statement.User;
	}

}
