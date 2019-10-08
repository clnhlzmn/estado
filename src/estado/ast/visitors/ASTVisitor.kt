package estado.ast.visitors

import estado.ast.nodes.Expr
import estado.ast.nodes.File
import estado.ast.nodes.Program
import estado.ast.nodes.Statement

interface ASTVisitor<T> {
    fun visit(p: Program): T

    fun visit(f: File): T

    fun visit(s: Statement.Expr): T
    fun visit(s: Statement.Block): T
    fun visit(s: Statement.If): T
    fun visit(s: Statement.While): T
    fun visit(s: Statement.Let): T
    fun visit(s: Statement.Break): T
    fun visit(s: Statement.Return): T
    fun visit(s: Statement.Assign): T

    fun visit(e: Expr.New): T
    fun visit(e: Expr.Boolean): T
    fun visit(e: Expr.Natural): T
    fun visit(e: Expr.Text): T
    fun visit(e: Expr.Ref): T
    fun visit(e: Expr.Apply): T
    fun visit(e: Expr.Unary): T
    fun visit(e: Expr.Binary): T
    fun visit(e: Expr.Cond): T
    fun visit(e: Expr.Fun.Native): T
    fun visit(e: Expr.Fun.Ref): T
    fun visit(e: Expr.Extern): T
}