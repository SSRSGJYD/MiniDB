import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import minidb.basic.database.MiniDB;
import minidb.result.Result;
import com.alibaba.fastjson.JSON;

public class SQLParser{
	

	
	public static void main( String[] args) throws Exception 
	{
        Path path = Paths.get("input.sql");
		byte[] bArray = Files.readAllBytes(path);
 
		String cmds="create database db\n"
				+ "use database db\n"
				+ "create table playr(id char(4),name int)\n"
//				+ "create table playt(id int,name int,primary key(id))\n"
//				+ "create table playd(id int,name int,primary key(id))\n"

				+ "insert into playr values('1332',17)\n"
				+ "insert into playr values('1333',390)\n"
				+ "insert into playr values('1333',990)\n"
				+ "delete from playr where name=90\n"
				+ "delete from playr where name=390\n"
//
//				+ "insert into playt values(133,90)\n"
//				+ "insert into playt(id) values(134)\n"
//				+ "insert into playt values(13,990)\n"
//
//				+ "insert into playd values(133,90)\n"
//				+ "insert into playd(id) values(134)\n"
//				+ "insert into playd values(13,990)\n"
////
				+ "select * from playr where name=17\n"
//				+ "select * from playr where (name>100 or name <400) and id>='1333'\n"
//				+ "select * from playr join playt on playr.name=playt.name where playt.name>100 or playt.id<40\n"
//				+ "                    join playd on playd.name=playr.name\n"

				+ "drop table playr\n";
//				+ "drop table playd\n"
//				+ "drop table playt\n";

		InputStream targetStream = new ByteArrayInputStream(bArray);
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
				System.out.println(res.json());
//			}
//			catch(Exception e) {
//				System.out.println(e);
//			}

		}
	}
} 
