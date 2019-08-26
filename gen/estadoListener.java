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
}