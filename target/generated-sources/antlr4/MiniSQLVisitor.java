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
	 * Visit a parse tree produced by {@link MiniSQLParser#op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp(MiniSQLParser.OpContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniSQLParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(MiniSQLParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code create}
	 * labeled alternative in {@link MiniSQLParser#sql}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate(MiniSQLParser.CreateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code drop}
	 * labeled alternative in {@link MiniSQLParser#sql}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop(MiniSQLParser.DropContext ctx);
	/**
	 * Visit a parse tree produced by the {@code insertA}
	 * labeled alternative in {@link MiniSQLParser#sql}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsertA(MiniSQLParser.InsertAContext ctx);
	/**
	 * Visit a parse tree produced by the {@code insertB}
	 * labeled alternative in {@link MiniSQLParser#sql}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsertB(MiniSQLParser.InsertBContext ctx);
	/**
	 * Visit a parse tree produced by the {@code delete}
	 * labeled alternative in {@link MiniSQLParser#sql}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDelete(MiniSQLParser.DeleteContext ctx);
	/**
	 * Visit a parse tree produced by the {@code update}
	 * labeled alternative in {@link MiniSQLParser#sql}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdate(MiniSQLParser.UpdateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code selectA}
	 * labeled alternative in {@link MiniSQLParser#sql}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectA(MiniSQLParser.SelectAContext ctx);
	/**
	 * Visit a parse tree produced by the {@code selectB}
	 * labeled alternative in {@link MiniSQLParser#sql}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectB(MiniSQLParser.SelectBContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniSQLParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(MiniSQLParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniSQLParser#set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSet(MiniSQLParser.SetContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniSQLParser#names}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNames(MiniSQLParser.NamesContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniSQLParser#cname}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCname(MiniSQLParser.CnameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniSQLParser#cnames}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCnames(MiniSQLParser.CnamesContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniSQLParser#onCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOnCondition(MiniSQLParser.OnConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniSQLParser#jnames}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJnames(MiniSQLParser.JnamesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code values}
	 * labeled alternative in {@link MiniSQLParser#sqlsqlsqlsqlsqlsqlsqlsqlschemaattributeattributeconstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValues(MiniSQLParser.ValuesContext ctx);
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
	 * Visit a parse tree produced by the {@code notnullattr}
	 * labeled alternative in {@link MiniSQLParser#attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotnullattr(MiniSQLParser.NotnullattrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primarykey}
	 * labeled alternative in {@link MiniSQLParser#constraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimarykey(MiniSQLParser.PrimarykeyContext ctx);
}