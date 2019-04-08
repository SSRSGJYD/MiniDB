// Generated from MiniSQL.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MiniSQLParser}.
 */
public interface MiniSQLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MiniSQLParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(MiniSQLParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniSQLParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(MiniSQLParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniSQLParser#op}.
	 * @param ctx the parse tree
	 */
	void enterOp(MiniSQLParser.OpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniSQLParser#op}.
	 * @param ctx the parse tree
	 */
	void exitOp(MiniSQLParser.OpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniSQLParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(MiniSQLParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniSQLParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(MiniSQLParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code create}
	 * labeled alternative in {@link MiniSQLParser#sql}.
	 * @param ctx the parse tree
	 */
	void enterCreate(MiniSQLParser.CreateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code create}
	 * labeled alternative in {@link MiniSQLParser#sql}.
	 * @param ctx the parse tree
	 */
	void exitCreate(MiniSQLParser.CreateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code drop}
	 * labeled alternative in {@link MiniSQLParser#sql}.
	 * @param ctx the parse tree
	 */
	void enterDrop(MiniSQLParser.DropContext ctx);
	/**
	 * Exit a parse tree produced by the {@code drop}
	 * labeled alternative in {@link MiniSQLParser#sql}.
	 * @param ctx the parse tree
	 */
	void exitDrop(MiniSQLParser.DropContext ctx);
	/**
	 * Enter a parse tree produced by the {@code insertA}
	 * labeled alternative in {@link MiniSQLParser#sql}.
	 * @param ctx the parse tree
	 */
	void enterInsertA(MiniSQLParser.InsertAContext ctx);
	/**
	 * Exit a parse tree produced by the {@code insertA}
	 * labeled alternative in {@link MiniSQLParser#sql}.
	 * @param ctx the parse tree
	 */
	void exitInsertA(MiniSQLParser.InsertAContext ctx);
	/**
	 * Enter a parse tree produced by the {@code insertB}
	 * labeled alternative in {@link MiniSQLParser#sql}.
	 * @param ctx the parse tree
	 */
	void enterInsertB(MiniSQLParser.InsertBContext ctx);
	/**
	 * Exit a parse tree produced by the {@code insertB}
	 * labeled alternative in {@link MiniSQLParser#sql}.
	 * @param ctx the parse tree
	 */
	void exitInsertB(MiniSQLParser.InsertBContext ctx);
	/**
	 * Enter a parse tree produced by the {@code delete}
	 * labeled alternative in {@link MiniSQLParser#sql}.
	 * @param ctx the parse tree
	 */
	void enterDelete(MiniSQLParser.DeleteContext ctx);
	/**
	 * Exit a parse tree produced by the {@code delete}
	 * labeled alternative in {@link MiniSQLParser#sql}.
	 * @param ctx the parse tree
	 */
	void exitDelete(MiniSQLParser.DeleteContext ctx);
	/**
	 * Enter a parse tree produced by the {@code update}
	 * labeled alternative in {@link MiniSQLParser#sql}.
	 * @param ctx the parse tree
	 */
	void enterUpdate(MiniSQLParser.UpdateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code update}
	 * labeled alternative in {@link MiniSQLParser#sql}.
	 * @param ctx the parse tree
	 */
	void exitUpdate(MiniSQLParser.UpdateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code selectA}
	 * labeled alternative in {@link MiniSQLParser#sql}.
	 * @param ctx the parse tree
	 */
	void enterSelectA(MiniSQLParser.SelectAContext ctx);
	/**
	 * Exit a parse tree produced by the {@code selectA}
	 * labeled alternative in {@link MiniSQLParser#sql}.
	 * @param ctx the parse tree
	 */
	void exitSelectA(MiniSQLParser.SelectAContext ctx);
	/**
	 * Enter a parse tree produced by the {@code selectB}
	 * labeled alternative in {@link MiniSQLParser#sql}.
	 * @param ctx the parse tree
	 */
	void enterSelectB(MiniSQLParser.SelectBContext ctx);
	/**
	 * Exit a parse tree produced by the {@code selectB}
	 * labeled alternative in {@link MiniSQLParser#sql}.
	 * @param ctx the parse tree
	 */
	void exitSelectB(MiniSQLParser.SelectBContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniSQLParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(MiniSQLParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniSQLParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(MiniSQLParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniSQLParser#set}.
	 * @param ctx the parse tree
	 */
	void enterSet(MiniSQLParser.SetContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniSQLParser#set}.
	 * @param ctx the parse tree
	 */
	void exitSet(MiniSQLParser.SetContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniSQLParser#names}.
	 * @param ctx the parse tree
	 */
	void enterNames(MiniSQLParser.NamesContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniSQLParser#names}.
	 * @param ctx the parse tree
	 */
	void exitNames(MiniSQLParser.NamesContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniSQLParser#cname}.
	 * @param ctx the parse tree
	 */
	void enterCname(MiniSQLParser.CnameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniSQLParser#cname}.
	 * @param ctx the parse tree
	 */
	void exitCname(MiniSQLParser.CnameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniSQLParser#cnames}.
	 * @param ctx the parse tree
	 */
	void enterCnames(MiniSQLParser.CnamesContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniSQLParser#cnames}.
	 * @param ctx the parse tree
	 */
	void exitCnames(MiniSQLParser.CnamesContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniSQLParser#onCondition}.
	 * @param ctx the parse tree
	 */
	void enterOnCondition(MiniSQLParser.OnConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniSQLParser#onCondition}.
	 * @param ctx the parse tree
	 */
	void exitOnCondition(MiniSQLParser.OnConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniSQLParser#jnames}.
	 * @param ctx the parse tree
	 */
	void enterJnames(MiniSQLParser.JnamesContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniSQLParser#jnames}.
	 * @param ctx the parse tree
	 */
	void exitJnames(MiniSQLParser.JnamesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code values}
	 * labeled alternative in {@link MiniSQLParser#sqlsqlsqlsqlsqlsqlsqlsqlschemaattributeattributeconstraint}.
	 * @param ctx the parse tree
	 */
	void enterValues(MiniSQLParser.ValuesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code values}
	 * labeled alternative in {@link MiniSQLParser#sqlsqlsqlsqlsqlsqlsqlsqlschemaattributeattributeconstraint}.
	 * @param ctx the parse tree
	 */
	void exitValues(MiniSQLParser.ValuesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code attrcons}
	 * labeled alternative in {@link MiniSQLParser#schema}.
	 * @param ctx the parse tree
	 */
	void enterAttrcons(MiniSQLParser.AttrconsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code attrcons}
	 * labeled alternative in {@link MiniSQLParser#schema}.
	 * @param ctx the parse tree
	 */
	void exitAttrcons(MiniSQLParser.AttrconsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code normalattr}
	 * labeled alternative in {@link MiniSQLParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterNormalattr(MiniSQLParser.NormalattrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code normalattr}
	 * labeled alternative in {@link MiniSQLParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitNormalattr(MiniSQLParser.NormalattrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notnullattr}
	 * labeled alternative in {@link MiniSQLParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterNotnullattr(MiniSQLParser.NotnullattrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notnullattr}
	 * labeled alternative in {@link MiniSQLParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitNotnullattr(MiniSQLParser.NotnullattrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primarykey}
	 * labeled alternative in {@link MiniSQLParser#constraint}.
	 * @param ctx the parse tree
	 */
	void enterPrimarykey(MiniSQLParser.PrimarykeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primarykey}
	 * labeled alternative in {@link MiniSQLParser#constraint}.
	 * @param ctx the parse tree
	 */
	void exitPrimarykey(MiniSQLParser.PrimarykeyContext ctx);
}