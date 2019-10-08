package estado.ast.nodes

import estado.ast.visitors.ASTVisitor
import estado.util.SourceLocation

sealed class Statement(loc: SourceLocation): BaseASTNode(loc) {
    var enclosingScope: ASTNode? = null
    class Expr(val expr: estado.ast.nodes.Expr, loc: SourceLocation): Statement(loc) {
        override fun <T> accept(visitor: ASTVisitor<T>): T =
            visitor.visit(this)

        override fun toString(): String {
            return "$expr;"
        }
    }
    class Block(val statements: List<Statement>, loc: SourceLocation): Statement(loc) {
        override fun <T> accept(visitor: ASTVisitor<T>): T {
            return visitor.visit(this)
        }
        override fun toString(): String {
            return "{${statements.joinToString(" ")}}"
        }
    }
    class If(val cond: estado.ast.nodes.Expr, val csq: Statement, val alt: Statement?, loc: SourceLocation): Statement(loc) {
        override fun <T> accept(visitor: ASTVisitor<T>): T =
            visitor.visit(this)

        override fun toString(): String {
            return if (alt == null) "if ($cond) $csq"
            else "if ($cond) $csq else $alt"
        }
    }
    class While(val cond: estado.ast.nodes.Expr, val body: Statement, loc: SourceLocation): Statement(loc) {
        override fun <T> accept(visitor: ASTVisitor<T>): T =
            visitor.visit(this)

        override fun toString(): String {
            return "while ($cond) $body"
        }
    }
    class Let(val weak: Boolean, val `var`: Boolean, val id: String, val declaredType: Type?,
              val value: estado.ast.nodes.Expr, val body: List<Statement>,
              loc: SourceLocation): Statement(loc) {

            override fun <T> accept(visitor: ASTVisitor<T>): T =
            visitor.visit(this)

        override fun toString(): String {
            val weakStr = if (weak) "weak" else ""
            val varStr = if (`var`) "var" else "let"
            return "$weakStr $varStr $id = $value; ${body.joinToString(" ")}"
        }
    }
    class Break(loc: SourceLocation) : Statement(loc) {
        override fun <T> accept(visitor: ASTVisitor<T>): T =
            visitor.visit(this)

        override fun toString(): String {
            return "break;"
        }
    }
    class Return(val expr: estado.ast.nodes.Expr?, loc: SourceLocation): Statement(loc) {
        override fun <T> accept(visitor: ASTVisitor<T>): T =
            visitor.visit(this)

        override fun toString(): String {
            return if (expr == null) "return;"
            else "return $expr;"
        }
    }
    class Assign(val target: estado.ast.nodes.Expr, val value: estado.ast.nodes.Expr, loc: SourceLocation): Statement(loc) {
        override fun <T> accept(visitor: ASTVisitor<T>): T =
            visitor.visit(this)

        override fun toString(): String {
            return "$target = $value;"
        }
    }
}
