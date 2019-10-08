package estado.ast.nodes

import estado.ast.visitors.ASTVisitor
import estado.util.SourceLocation

sealed class Expr(loc: SourceLocation, var t: Type = Type.Var()) : BaseASTNode(loc) {
    var enclosingScope: ASTNode? = null
    class New(val value: Expr, loc: SourceLocation): Expr(loc) {
        override fun <T> accept(visitor: ASTVisitor<T>): T =
            visitor.visit(this)

        override fun toString(): String =
            "new $value"
    }
    class Boolean(val value: kotlin.Boolean, loc: SourceLocation): Expr(loc) {
        override fun <T> accept(visitor: ASTVisitor<T>): T =
            visitor.visit(this)

        override fun toString(): String =
            value.toString()
    }
    class Natural(val value: Long, loc: SourceLocation) : Expr(loc) {

        override fun <T> accept(visitor: ASTVisitor<T>): T =
            visitor.visit(this)

        override fun toString(): String =
            value.toString()
    }
    class Text(val value: String, loc: SourceLocation) : Expr(loc) {

        override fun <T> accept(visitor: ASTVisitor<T>): T =
            visitor.visit(this)

        override fun toString(): String =
            "\"$value\""

        fun bytes(): List<Byte> {
            return value.toByteArray(Charsets.UTF_8).toList()
        }
    }
    class Ref(var id: String, loc: SourceLocation) : Expr(loc) {

        override fun <T> accept(visitor: ASTVisitor<T>): T =
            visitor.visit(this)

        override fun toString(): String =
            id

        override fun equals(other: Any?): kotlin.Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Ref

            if (id != other.id) return false

            return true
        }

        override fun hashCode(): Int {
            return id.hashCode()
        }
    }
    class Apply(val fn: Expr, val args: List<Expr>, loc: SourceLocation) : Expr(loc) {

        override fun <T> accept(visitor: ASTVisitor<T>): T =
            visitor.visit(this)

        override fun toString(): String =
            "$fn(${args.joinToString(", ")})"
    }
    class Unary(val operator: String, val operand: Expr, loc: SourceLocation) : Expr(loc) {

        companion object {
            const val NOT = "!"
            const val COMPLEMENT = "~"
            const val NEGATE = "-"
        }

        override fun <T> accept(visitor: ASTVisitor<T>): T =
            visitor.visit(this)

        override fun toString(): String =
            "($operator $operand)"
    }
    class Binary(val lhs: Expr, val operator: String, val rhs: Expr, loc: SourceLocation) : Expr(loc) {

        companion object {
            const val MULTIPLY = "*"
            const val DIVIDE = "/"
            const val MOD = "%"
            const val PLUS = "+"
            const val MINUS = "-"
            const val LEFT_SHIFT = "<<"
            const val RIGHT_SHIFT = ">>"
            const val LESS = "<"
            const val GREATER = ">"
            const val LESS_OR_EQUAL = "<="
            const val GREATER_OR_EQUAL = ">="
            const val EQUAL = "=="
            const val NOT_EQUAL = "!="
            const val BIT_AND = "&"
            const val BIT_XOR = "^"
            const val BIT_OR = "|"
            const val AND = "&&"
            const val OR = "||"
        }

        override fun <T> accept(visitor: ASTVisitor<T>): T =
            visitor.visit(this)

        override fun toString(): String =
            "($lhs $operator $rhs)"
    }
    class Cond(val cond: Expr, val csq: Expr, val alt: Expr, loc: SourceLocation) : Expr(loc) {

        override fun <T> accept(visitor: ASTVisitor<T>): T =
            visitor.visit(this)

        override fun toString(): String =
            "($cond ? $csq : $alt)"
    }
    sealed class Fun(val params: List<Param>, var retType: Type, val body: Statement, loc: SourceLocation) : Expr(loc) {

        class Param(val id: String, var t: Type) {
            override fun toString(): String =
                id
        }

        override fun toString(): String =
            "(${params.map { "${it.id} ${it.t}" }.joinToString(", ")})$retType $body"

        class Native(params: List<Param>, retType: Type, body: Statement, loc: SourceLocation): Fun(params, retType, body, loc) {
            override fun <T> accept(visitor: ASTVisitor<T>): T {
                return visitor.visit(this)
            }
        }

        class Ref(params: List<Param>, retType: Type, body: Statement, loc: SourceLocation): Fun(params, retType, body, loc) {
            val captures = HashSet<Expr.Ref>()

            override fun <T> accept(visitor: ASTVisitor<T>): T {
                return visitor.visit(this)
            }

            override fun toString(): String {
                return "new ${super.toString()}"
            }
        }

    }
    class Extern(val id: String, val declaredType: Type, loc: SourceLocation) : Expr(loc) {

        override fun <T> accept(visitor: ASTVisitor<T>): T =
            visitor.visit(this)

        override fun toString(): String =
            "extern $id $declaredType"
    }
}