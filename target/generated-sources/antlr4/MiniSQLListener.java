// Generated from MiniSQL.g4 by ANTLR 4.4
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MiniSQLParser}.
 */
public interface MiniSQLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code drop}
	 * labeled alternative in {@link MiniSQLParser#sql}.
	 * @param ctx the parse tree
	 */
	void enterDrop(@NotNull MiniSQLParser.DropContext ctx);
	/**
	 * Exit a parse tree produced by the {@code drop}
	 * labeled alternative in {@link MiniSQLParser#sql}.
	 * @param ctx the parse tree
	 */
	void exitDrop(@NotNull MiniSQLParser.DropContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniSQLParser#jnames}.
	 * @param ctx the parse tree
	 */
	void enterJnames(@NotNull MiniSQLParser.JnamesContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniSQLParser#jnames}.
	 * @param ctx the parse tree
	 */
	void exitJnames(@NotNull MiniSQLParser.JnamesContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniSQLParser#logictree}.
	 * @param ctx the parse tree
	 */
	void enterLogictree(@NotNull MiniSQLParser.LogictreeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniSQLParser#logictree}.
	 * @param ctx the parse tree
	 */
	void exitLogictree(@NotNull MiniSQLParser.LogictreeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code values}
	 * labeled alternative in {@link MiniSQLParser#sqlsqlsqlsqlsqlsqlsqlsqlschemasqlattributesqlsqlsqlattributesqlsqlconstraint}.
	 * @param ctx the parse tree
	 */
	void enterValues(@NotNull MiniSQLParser.ValuesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code values}
	 * labeled alternative in {@link MiniSQLParser#sqlsqlsqlsqlsqlsqlsqlsqlschemasqlattributesqlsqlsqlattributesqlsqlconstraint}.
	 * @param ctx the parse tree
	 */
	void exitValues(@NotNull MiniSQLParser.ValuesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code show}
	 * labeled alternative in {@link MiniSQLParser#sql}.
	 * @param ctx the parse tree
	 */
	void enterShow(@NotNull MiniSQLParser.ShowContext ctx);
	/**
	 * Exit a parse tree produced by the {@code show}
	 * labeled alternative in {@link MiniSQLParser#sql}.
	 * @param ctx the parse tree
	 */
	void exitShow(@NotNull MiniSQLParser.ShowContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniSQLParser#ccondition}.
	 * @param ctx the parse tree
	 */
	void enterCcondition(@NotNull MiniSQLParser.CconditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniSQLParser#ccondition}.
	 * @param ctx the parse tree
	 */
	void exitCcondition(@NotNull MiniSQLParser.CconditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniSQLParser#cname}.
	 * @param ctx the parse tree
	 */
	void enterCname(@NotNull MiniSQLParser.CnameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniSQLParser#cname}.
	 * @param ctx the parse tree
	 */
	void exitCname(@NotNull MiniSQLParser.CnameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code update}
	 * labeled alternative in {@link MiniSQLParser#sql}.
	 * @param ctx the parse tree
	 */
	void enterUpdate(@NotNull MiniSQLParser.UpdateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code update}
	 * labeled alternative in {@link MiniSQLParser#sql}.
	 * @param ctx the parse tree
	 */
	void exitUpdate(@NotNull MiniSQLParser.UpdateContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniSQLParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(@NotNull MiniSQLParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniSQLParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(@NotNull MiniSQLParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniSQLParser#lop}.
	 * @param ctx the parse tree
	 */
	void enterLop(@NotNull MiniSQLParser.LopContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniSQLParser#lop}.
	 * @param ctx the parse tree
	 */
	void exitLop(@NotNull MiniSQLParser.LopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code delete}
	 * labeled alternative in {@link MiniSQLParser#sql}.
	 * @param ctx the parse tree
	 */
	void enterDelete(@NotNull MiniSQLParser.DeleteContext ctx);
	/**
	 * Exit a parse tree produced by the {@code delete}
	 * labeled alternative in {@link MiniSQLParser#sql}.
	 * @param ctx the parse tree
	 */
	void exitDelete(@NotNull MiniSQLParser.DeleteContext ctx);
	/**
	 * Enter a parse tree produced by the {@code insertB}
	 * labeled alternative in {@link MiniSQLParser#sql}.
	 * @param ctx the parse tree
	 */
	void enterInsertB(@NotNull MiniSQLParser.InsertBContext ctx);
	/**
	 * Exit a parse tree produced by the {@code insertB}
	 * labeled alternative in {@link MiniSQLParser#sql}.
	 * @param ctx the parse tree
	 */
	void exitInsertB(@NotNull MiniSQLParser.InsertBContext ctx);
	/**
	 * Enter a parse tree produced by the {@code insertA}
	 * labeled alternative in {@link MiniSQLParser#sql}.
	 * @param ctx the parse tree
	 */
	void enterInsertA(@NotNull MiniSQLParser.InsertAContext ctx);
	/**
	 * Exit a parse tree produced by the {@code insertA}
	 * labeled alternative in {@link MiniSQLParser#sql}.
	 * @param ctx the parse tree
	 */
	void exitInsertA(@NotNull MiniSQLParser.InsertAContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notnullattr}
	 * labeled alternative in {@link MiniSQLParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterNotnullattr(@NotNull MiniSQLParser.NotnullattrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notnullattr}
	 * labeled alternative in {@link MiniSQLParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitNotnullattr(@NotNull MiniSQLParser.NotnullattrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code showdb}
	 * labeled alternative in {@link MiniSQLParser#sql}.
	 * @param ctx the parse tree
	 */
	void enterShowdb(@NotNull MiniSQLParser.ShowdbContext ctx);
	/**
	 * Exit a parse tree produced by the {@code showdb}
	 * labeled alternative in {@link MiniSQLParser#sql}.
	 * @param ctx the parse tree
	 */
	void exitShowdb(@NotNull MiniSQLParser.ShowdbContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newline}
	 * labeled alternative in {@link MiniSQLParser#sql}.
	 * @param ctx the parse tree
	 */
	void enterNewline(@NotNull MiniSQLParser.NewlineContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newline}
	 * labeled alternative in {@link MiniSQLParser#sql}.
	 * @param ctx the parse tree
	 */
	void exitNewline(@NotNull MiniSQLParser.NewlineContext ctx);
	/**
	 * Enter a parse tree produced by the {@code create}
	 * labeled alternative in {@link MiniSQLParser#sql}.
	 * @param ctx the parse tree
	 */
	void enterCreate(@NotNull MiniSQLParser.CreateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code create}
	 * labeled alternative in {@link MiniSQLParser#sql}.
	 * @param ctx the parse tree
	 */
	void exitCreate(@NotNull MiniSQLParser.CreateContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniSQLParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(@NotNull MiniSQLParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniSQLParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(@NotNull MiniSQLParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primarykey}
	 * labeled alternative in {@link MiniSQLParser#constraint}.
	 * @param ctx the parse tree
	 */
	void enterPrimarykey(@NotNull MiniSQLParser.PrimarykeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primarykey}
	 * labeled alternative in {@link MiniSQLParser#constraint}.
	 * @param ctx the parse tree
	 */
	void exitPrimarykey(@NotNull MiniSQLParser.PrimarykeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniSQLParser#op}.
	 * @param ctx the parse tree
	 */
	void enterOp(@NotNull MiniSQLParser.OpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniSQLParser#op}.
	 * @param ctx the parse tree
	 */
	void exitOp(@NotNull MiniSQLParser.OpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code selectB}
	 * labeled alternative in {@link MiniSQLParser#sql}.
	 * @param ctx the parse tree
	 */
	void enterSelectB(@NotNull MiniSQLParser.SelectBContext ctx);
	/**
	 * Exit a parse tree produced by the {@code selectB}
	 * labeled alternative in {@link MiniSQLParser#sql}.
	 * @param ctx the parse tree
	 */
	void exitSelectB(@NotNull MiniSQLParser.SelectBContext ctx);
	/**
	 * Enter a parse tree produced by the {@code selectA}
	 * labeled alternative in {@link MiniSQLParser#sql}.
	 * @param ctx the parse tree
	 */
	void enterSelectA(@NotNull MiniSQLParser.SelectAContext ctx);
	/**
	 * Exit a parse tree produced by the {@code selectA}
	 * labeled alternative in {@link MiniSQLParser#sql}.
	 * @param ctx the parse tree
	 */
	void exitSelectA(@NotNull MiniSQLParser.SelectAContext ctx);
	/**
	 * Enter a parse tree produced by the {@code usedb}
	 * labeled alternative in {@link MiniSQLParser#sql}.
	 * @param ctx the parse tree
	 */
	void enterUsedb(@NotNull MiniSQLParser.UsedbContext ctx);
	/**
	 * Exit a parse tree produced by the {@code usedb}
	 * labeled alternative in {@link MiniSQLParser#sql}.
	 * @param ctx the parse tree
	 */
	void exitUsedb(@NotNull MiniSQLParser.UsedbContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniSQLParser#set}.
	 * @param ctx the parse tree
	 */
	void enterSet(@NotNull MiniSQLParser.SetContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniSQLParser#set}.
	 * @param ctx the parse tree
	 */
	void exitSet(@NotNull MiniSQLParser.SetContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniSQLParser#cnames}.
	 * @param ctx the parse tree
	 */
	void enterCnames(@NotNull MiniSQLParser.CnamesContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniSQLParser#cnames}.
	 * @param ctx the parse tree
	 */
	void exitCnames(@NotNull MiniSQLParser.CnamesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code attrcons}
	 * labeled alternative in {@link MiniSQLParser#schema}.
	 * @param ctx the parse tree
	 */
	void enterAttrcons(@NotNull MiniSQLParser.AttrconsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code attrcons}
	 * labeled alternative in {@link MiniSQLParser#schema}.
	 * @param ctx the parse tree
	 */
	void exitAttrcons(@NotNull MiniSQLParser.AttrconsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniSQLParser#onCondition}.
	 * @param ctx the parse tree
	 */
	void enterOnCondition(@NotNull MiniSQLParser.OnConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniSQLParser#onCondition}.
	 * @param ctx the parse tree
	 */
	void exitOnCondition(@NotNull MiniSQLParser.OnConditionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dropdb}
	 * labeled alternative in {@link MiniSQLParser#sql}.
	 * @param ctx the parse tree
	 */
	void enterDropdb(@NotNull MiniSQLParser.DropdbContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dropdb}
	 * labeled alternative in {@link MiniSQLParser#sql}.
	 * @param ctx the parse tree
	 */
	void exitDropdb(@NotNull MiniSQLParser.DropdbContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniSQLParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(@NotNull MiniSQLParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniSQLParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(@NotNull MiniSQLParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniSQLParser#names}.
	 * @param ctx the parse tree
	 */
	void enterNames(@NotNull MiniSQLParser.NamesContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniSQLParser#names}.
	 * @param ctx the parse tree
	 */
	void exitNames(@NotNull MiniSQLParser.NamesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code normalattr}
	 * labeled alternative in {@link MiniSQLParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterNormalattr(@NotNull MiniSQLParser.NormalattrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code normalattr}
	 * labeled alternative in {@link MiniSQLParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitNormalattr(@NotNull MiniSQLParser.NormalattrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code createdb}
	 * labeled alternative in {@link MiniSQLParser#sql}.
	 * @param ctx the parse tree
	 */
	void enterCreatedb(@NotNull MiniSQLParser.CreatedbContext ctx);
	/**
	 * Exit a parse tree produced by the {@code createdb}
	 * labeled alternative in {@link MiniSQLParser#sql}.
	 * @param ctx the parse tree
	 */
	void exitCreatedb(@NotNull MiniSQLParser.CreatedbContext ctx);
}