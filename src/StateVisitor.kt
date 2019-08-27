
class StateVisitor: estadoBaseVisitor<State>() {
    override fun visitState(ctx: estadoParser.StateContext?): State {
        val handlers = ctx!!.handler().map { h -> h.accept(HandlerVisitor()) }
        val subStates = ctx.state().map { s -> s.accept(this) }
        val state = State(ctx.ID().text, null, subStates, handlers)
        state.subStates.forEach { ss -> ss.parent = state }
        return state
    }
}