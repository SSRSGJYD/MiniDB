// Generated from MiniSQL.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MiniSQLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MiniSQLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MiniSQLParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(MiniSQLParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code create}
	 * labeled alternative in {@link MiniSQLParser#sql}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate(MiniSQLParser.CreateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code attrcons}
	 * labeled alternative in {@link MiniSQLParser#schema}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrcons(MiniSQLParser.AttrconsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code normalattr}
	 * labeled alternative in {@link MiniSQLParser#attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalattr(MiniSQLParser.NormalattrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primarykey}
	 * labeled alternative in {@link MiniSQLParser#constraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimarykey(MiniSQLParser.PrimarykeyContext ctx);
}