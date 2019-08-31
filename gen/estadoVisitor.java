// Generated from C:/code/estado/src\estado.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link estadoParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface estadoVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link estadoParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(estadoParser.FileContext ctx);
	/**
	 * Visit a parse tree produced by {@link estadoParser#state}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitState(estadoParser.StateContext ctx);
	/**
	 * Visit a parse tree produced by {@link estadoParser#handler}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHandler(estadoParser.HandlerContext ctx);
	/**
	 * Visit a parse tree produced by {@link estadoParser#transition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransition(estadoParser.TransitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link estadoParser#action}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAction(estadoParser.ActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code messageStatement}
	 * labeled alternative in {@link estadoParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMessageStatement(estadoParser.MessageStatementContext ctx);
}