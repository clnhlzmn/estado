package estado.grammar

import estado.ast.nodes.Handler
import estadoBaseVisitor
import estadoParser

class HandlerVisitor: estadoBaseVisitor<Handler>() {
    override fun visitHandler(ctx: estadoParser.HandlerContext?): Handler {
        val action =
            if (ctx!!.action() == null) emptyList<Statement>()
            else ctx.action().statement().map { it.accept(StatementVisitor()) }
        return Handler(ctx.ID().text, ctx.transition()?.ID()?.text, action)
    }
}
