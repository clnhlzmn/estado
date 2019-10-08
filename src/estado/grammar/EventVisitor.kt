package estado.grammar

import estadoBaseVisitor
import estadoParser

class EventVisitor: estadoBaseVisitor<Set<String>>() {
    override fun visitFile(ctx: estadoParser.FileContext?): Set<String> =
        ctx!!.state()
            ?.map { s -> s.accept(this) }
            ?.fold(emptySet()) { acc, list -> acc + list }!!

    override fun visitState(ctx: estadoParser.StateContext?): Set<String> =
        ctx!!.handler()?.map { h -> h.ID().text!! }?.toSet()!! +
            ctx.state().map { s -> s.accept(this) }.fold(emptySet()) { acc:Set<String>, set -> acc + set }

}