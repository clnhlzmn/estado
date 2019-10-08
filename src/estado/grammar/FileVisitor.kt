package estado.grammar

import estado.ast.nodes.State
import estadoBaseVisitor
import estadoParser

class FileVisitor: estadoBaseVisitor<List<State>>() {
    override fun visitFile(ctx: estadoParser.FileContext?) =
        ctx!!.state().map { s -> s.accept(StateVisitor()) }
}