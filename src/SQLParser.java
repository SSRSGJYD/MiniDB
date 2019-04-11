import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import minidb.basic.database.DataBase;

public class SQLParser{
	
	public static void main( String[] args) throws Exception 
	{
		InputStreamReader in=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(in);
		DataBase db=new DataBase();
		while(true) {
			String cmd=br.readLine();
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
				
				db.execute(extractor.st);
//			}
//			catch(Exception e) {
//				System.out.println(e);
//			}

		}
	}
} 
