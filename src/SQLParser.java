import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import minidb.basic.database.DataBase;
import minidb.result.Result;

public class SQLParser{
	
	public static void mainl( String[] args) throws Exception {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(outputStream);
		dos.writeInt(1234);
		byte[]array=outputStream.toByteArray();

		ByteArrayInputStream in = new ByteArrayInputStream(array);
		DataInputStream inst=new DataInputStream(in);
		int str=inst.readInt();
		System.out.print(str);
		
	}
	public static void main( String[] args) throws Exception 
	{
		InputStreamReader in=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(in);
		DataBase db=new DataBase();
		while(true) {
			String cmd=br.readLine();
			if(cmd.length()==0)continue;
			CharStream input = CharStreams.fromString(cmd);
			MiniSQLLexer lexer = new MiniSQLLexer(input);
			lexer.removeErrorListeners();
			lexer.addErrorListener(ThrowingErrorListener.INSTANCE);
	
			CommonTokenStream tokens = new CommonTokenStream(lexer);
	
			MiniSQLParser parser = new MiniSQLParser(tokens);
			parser.removeErrorListeners();
			parser.addErrorListener(ThrowingErrorListener.INSTANCE);
	
//			try {
				ParseTree tree = parser.sql(); // begin parsing at rule 'r'
				
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
