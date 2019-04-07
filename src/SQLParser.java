
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import minidb.basic.database.Statement;
import minidb.basic.database.StatementCreate;

public class SQLParser{
	
	public static void main( String[] args) throws Exception 
	{

		ANTLRInputStream input = new ANTLRInputStream( System.in);

		MiniSQLLexer lexer = new MiniSQLLexer(input);

		CommonTokenStream tokens = new CommonTokenStream(lexer);

		MiniSQLParser parser = new MiniSQLParser(tokens);
		ParseTree tree = parser.sql(); // begin parsing at rule 'r'
		EvalVisitor eval=new EvalVisitor();
		eval.visit(tree);
		System.out.println(tree.toStringTree(parser)); // print LISP-style tree
		switch(eval.type) {
		case Statement.create:
			StatementCreate sc=eval.sc;
			break;
		}
	}
} 
