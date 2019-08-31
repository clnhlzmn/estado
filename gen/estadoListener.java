// Generated from C:/code/estado/src\estado.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link estadoParser}.
 */
public interface estadoListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link estadoParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(estadoParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link estadoParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(estadoParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link estadoParser#state}.
	 * @param ctx the parse tree
	 */
	void enterState(estadoParser.StateContext ctx);
	/**
	 * Exit a parse tree produced by {@link estadoParser#state}.
	 * @param ctx the parse tree
	 */
	void exitState(estadoParser.StateContext ctx);
	/**
	 * Enter a parse tree produced by {@link estadoParser#handler}.
	 * @param ctx the parse tree
	 */
	void enterHandler(estadoParser.HandlerContext ctx);
	/**
	 * Exit a parse tree produced by {@link estadoParser#handler}.
	 * @param ctx the parse tree
	 */
	void exitHandler(estadoParser.HandlerContext ctx);
	/**
	 * Enter a parse tree produced by {@link estadoParser#transition}.
	 * @param ctx the parse tree
	 */
	void enterTransition(estadoParser.TransitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link estadoParser#transition}.
	 * @param ctx the parse tree
	 */
	void exitTransition(estadoParser.TransitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link estadoParser#action}.
	 * @param ctx the parse tree
	 */
	void enterAction(estadoParser.ActionContext ctx);
	/**
	 * Exit a parse tree produced by {@link estadoParser#action}.
	 * @param ctx the parse tree
	 */
	void exitAction(estadoParser.ActionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code messageStatement}
	 * labeled alternative in {@link estadoParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterMessageStatement(estadoParser.MessageStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code messageStatement}
	 * labeled alternative in {@link estadoParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitMessageStatement(estadoParser.MessageStatementContext ctx);
}