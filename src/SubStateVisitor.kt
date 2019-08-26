

class SubStateVisitor: estadoBaseVisitor<Map<String, String>>() {

    var currentState: String? = null
    val states = HashMap<String, String>()

    override fun visitFile(ctx: estadoParser.FileContext?): Map<String, String> {
        ctx?.state()?.forEach { stateCtx ->
            currentState = stateCtx.ID().text
            stateCtx.accept(this)
        }
        return states;
    }

    override fun visitState(ctx: estadoParser.StateContext?): Map<String, String> {
        return super.visitState(ctx)
    }

}
