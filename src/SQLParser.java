import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import minidb.basic.database.DataBase;
import minidb.basic.database.MiniDB;
import minidb.result.Result;

public class SQLParser{
	

	public static void main( String[] args) throws Exception 
	{
		String cmds="create database db\n"
				+ "use database db\n"
				+ "create table playt2(id int,age int,primary key(id))\n"
				+ "create table playr(id int,name int,primary key(id))\n"

				+ "insert into playt2 values(1834,199)\n"
				+ "insert into playt2 values(134,299)\n"
				+ "insert into playt2 values(13,29)\n"

				+ "insert into playr values(133,9)\n"
				+ "insert into playr(id,ir) values('134',22)\n"
				+ "insert into playr values(13,99)\n"

				+ "select * from playt2 join playr on playt2.id=playr.id where playr.id>80\n"

				+ "show databases\n";


		InputStream targetStream = new ByteArrayInputStream(cmds.getBytes());
		InputStreamReader in=new InputStreamReader(targetStream);
		BufferedReader br=new BufferedReader(in);
		MiniDB db=new MiniDB();
		while(true) {
			String cmd=br.readLine();
			if(cmd==null || cmd.length()==0)continue;
			CharStream input = CharStreams.fromString(cmd);
			MiniSQLLexer lexer = new MiniSQLLexer(input);
			lexer.removeErrorListeners();
			lexer.addErrorListener(ThrowingErrorListener.INSTANCE);
	
			CommonTokenStream tokens = new CommonTokenStream(lexer);
	
			MiniSQLParser parser = new MiniSQLParser(tokens);
			parser.removeErrorListeners();
			parser.addErrorListener(ThrowingErrorListener.INSTANCE);
	
//			try {
				ParseTree tree = parser.sql();
				
				MyListener extractor = new MyListener();
				ParseTreeWalker walker=new ParseTreeWalker();
				walker.walk(extractor, tree);		
				
				Result res=db.execute(extractor.st);
				res.display();
//			}
//			catch(Exception e) {
//				System.out.println(e);
//			}

		}
	}
} 
