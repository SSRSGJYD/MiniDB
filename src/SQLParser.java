import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import minidb.basic.database.MiniDB;
import minidb.result.Result;
import com.alibaba.fastjson.JSON;

public class SQLParser{
	

	
	public static void main( String[] args) throws Exception 
	{

		MiniDB db=new MiniDB();
		String cmd;
		long time=0;
		Scanner scan = new Scanner(new File("test/delete/delete_10000.script"));
//		Scanner scan = new Scanner(new File("test/insert/insert_10000.script"));
		scan.useDelimiter(Pattern.compile("\n"));
		while (scan.hasNext()) {
		    cmd = scan.next();
			if(cmd.length()<=1)continue;
		    cmd=cmd.replace('\n',' ');
		    cmd=cmd.replace('\t',' ');
			cmd=cmd.toLowerCase();
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
				
				Result res=db.execute(extractor.st,false);
				System.out.println(res.json(res.time));
				time+=res.time;
//			}
//			catch(Exception e) {
//				System.out.println(e);
//			}
		}
		db.commit();
		System.out.println(time);
	}
} 
