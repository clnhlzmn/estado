
class HandlerVisitor: estadoBaseVisitor<Handler>() {
    override fun visitHandler(ctx: estadoParser.HandlerContext?) =
        Handler(ctx!!.ID().text, ctx.transition()?.ID()?.text)
}
