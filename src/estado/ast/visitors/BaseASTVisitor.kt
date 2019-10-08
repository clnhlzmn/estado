package estado.ast.visitors

import estado.ast.nodes.Expr
import estado.ast.nodes.File
import estado.ast.nodes.Program
import estado.ast.nodes.Statement

open class BaseASTVisitor<T> : ASTVisitor<T> {

    override fun visit(p: Program): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(f: File): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(s: Statement.If): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    override fun visit(s: Statement.While): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    override fun visit(s: Statement.Let): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    override fun visit(s: Statement.Break): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    override fun visit(s: Statement.Return): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    override fun visit(s: Statement.Assign): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    override fun visit(s: Statement.Expr): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    override fun visit(s: Statement.Block): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(e: Expr.New): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    override fun visit(e: Expr.Boolean): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    override fun visit(e: Expr.Text): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    override fun visit(e: Expr.Natural): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    override fun visit(e: Expr.Ref): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    override fun visit(e: Expr.Apply): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    override fun visit(e: Expr.Unary): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    override fun visit(e: Expr.Binary): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    override fun visit(e: Expr.Cond): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    override fun visit(e: Expr.Fun.Native): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    override fun visit(e: Expr.Fun.Ref): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    override fun visit(e: Expr.Extern): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}