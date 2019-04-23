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
import minidb.result.Result;

public class SQLParser{
	
	public static void mainl( String[] args) throws Exception {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(outputStream);
		dos.writeChars("1234");
		byte[]array=outputStream.toByteArray();

		ByteArrayInputStream in = new ByteArrayInputStream(array);
		DataInputStream inst=new DataInputStream(in);
		String str="";
		for(int i=0;i<4;i++) {
			char s=inst.readChar();
			str+=s;
		}
		System.out.print(str);
	}

	public static void main( String[] args) throws Exception 
	{
		String cmds="create table playt(id int,age int,primary key(id))\n"
				+ "create table playr(id int,name int,primary key(id))\n"
				+ "create table playd(id int,info int,primary key(id))\n"

				+ "insert into playt values(1834,199)\n"
				+ "insert into playt values(134,299)\n"
				+ "insert into playt values(13,29)\n"

				+ "insert into playr values(134,9)\n"
				+ "insert into playr values(13,99)\n"
				+ "insert into playr values(133,9)\n"

				+ "insert into playd values(1324,2)\n"
				+ "insert into playd values(13,9)\n"
				+ "insert into playd values(3,99)\n"
				+ "insert into playd values(133,299)\n"

//				+ "select * from playt join playr on playt.id=playr.id\n";
//				+ "select * from playr join playd on playd.info=playr.name\n";
				+ "select * from playt join playr on playt.id=playr.id join playd on playd.info=playr.name\n";

		InputStream targetStream = new ByteArrayInputStream(cmds.getBytes());
		InputStreamReader in=new InputStreamReader(targetStream);
		BufferedReader br=new BufferedReader(in);
		DataBase db=new DataBase();
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
