// Generated from /Users/colinholzman/Documents/estado/src/estado.g4 by ANTLR 4.7.2
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
	 * Visit a parse tree produced by {@link estadoParser#fun}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFun(estadoParser.FunContext ctx);
	/**
	 * Visit a parse tree produced by {@link estadoParser#handler}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHandler(estadoParser.HandlerContext ctx);
}