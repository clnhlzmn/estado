package estado.ast.nodes

import estado.ast.visitors.ASTVisitor
import estado.util.SourceLocation

class File(val name: String, val statements:List<Statement>):
    BaseASTNode(SourceLocation(name, 0, 0)) {
    var enclosingScope: ASTNode? = null
    override fun <T> accept(visitor: ASTVisitor<T>): T {
        return visitor.visit(this)
    }

    override fun toString(): String {
        return statements.joinToString(" ")
    }
}