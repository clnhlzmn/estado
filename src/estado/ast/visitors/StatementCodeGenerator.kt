package gig.ast.visitors

import estado.ast.nodes.Statement
import estado.ast.visitors.BaseASTVisitor
import estado.codegen.CDecl
import estado.util.Output

class StatementCodeGenerator(val out: Output): BaseASTVisitor<Unit>() {

    override fun visit(s: Statement.While) {
        out.code.run {
            println("while (true) {")
            indent {
                val condId = s.cond.accept(ExprCodeGenerator(out))
                println("if (!$condId) break;")
                s.body.accept(this@StatementCodeGenerator)
            }
            println("}")
        }
    }

    override fun visit(s: Statement.Assign) {
        super.visit(s)
    }

    override fun visit(s: Statement.If) {
        val condId = s.cond.accept(ExprCodeGenerator(out))
        out.code.println("if ($condId) {")
        out.code.indent {
            s.csq.accept(StatementCodeGenerator(out))
        }
        if (s.alt != null) {
            out.code.println("} else {")
            out.code.indent {
                s.alt.accept(StatementCodeGenerator(out))
            }
        }
        out.code.println("}")
    }

    override fun visit(s: Statement.Let) {
        TODO("not implemented")
    }

    override fun visit(s: Statement.Break) {
        out.code.println("break;")
    }

    override fun visit(s: Statement.Return) {
        if (s.expr == null) {
            out.code.println("return;")
        } else {
            val exprId = s.expr.accept(ExprCodeGenerator(out))
            out.code.println("return $exprId;")
        }
    }

    override fun visit(s: Statement.Expr) {
        val exprId = s.expr.accept(ExprCodeGenerator(out))
        out.code.println("(void) $exprId;")
    }

    override fun visit(s: Statement.Block) {
        s.statements.forEach { it.accept(this) }
    }

}