
class FileVisitor: estadoBaseVisitor<List<String>>() {

    override fun visitFile(ctx: estadoParser.FileContext?): List<String> {
        return if (ctx!!.state() != null) {
            ctx.state().map { state -> state.ID().text }
        } else {
            emptyList()
        }
    }

}