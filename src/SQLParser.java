import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import minidb.basic.database.MiniDB;
import minidb.result.Result;

public class SQLParser{
	

	public static void main( String[] args) throws Exception 
	{
		String cmds="create database db\n"
				+ "use database db\n"
				+ "create table playr(id char(4),name int)\n"
				+ "create table playt(id int,name int,primary key(id))\n"

				+ "insert into playr values('1332',90)\n"
				+ "insert into playr values('1333',990)\n"

				+ "insert into playt values(133,90)\n"
				+ "insert into playt(id) values(134)\n"
				+ "insert into playt values(13,990)\n"

//				+ "select * from playr\n"
//				+ "select * from playr where id>'1333'\n"
				+ "select * from playr join playt on playr.name=playt.name\n"

				+ "drop table playr\n"
				+ "drop table playt\n";


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
