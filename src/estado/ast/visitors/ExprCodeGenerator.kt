package gig.ast.visitors

import estado.ast.nodes.Definition
import estado.ast.nodes.Expr
import estado.ast.nodes.Type
import estado.ast.visitors.BaseASTVisitor
import estado.codegen.CDecl
import estado.util.IndentedPrintWriter
import estado.util.Output
import java.io.StringWriter
import java.lang.RuntimeException

//generates code for an expression and returns the name of it's identifier
class ExprCodeGenerator(val out: Output): BaseASTVisitor<String>() {

    companion object {
        private var index = 0
        private fun id(): String {
            return "_${index++}"
        }
        private fun withNewId(block: (String)->Unit): String {
            val id = id()
            block(id)
            return id
        }
    }

    override fun visit(e: Expr.New): String {
        TODO("not implemented")
    }

    override fun visit(e: Expr.Boolean): String {
        return withNewId { id ->
            out.code.run {
                println("${CDecl(e.t, id)} = ${e.value};")
            }
        }
    }

    override fun visit(e: Expr.Text): String {
        return withNewId { id ->
            out.code.run {
                println("${CDecl(e.t, id)} = malloc(sizeof(struct text));")
                println("init(&$id, NULL);")
                println("$id->buffer = \"${e.value}\";")
                println("$id->count = ${e.value.length};")
            }
        }
    }

    override fun visit(e: Expr.Natural): String {
        return withNewId { id ->
            out.code.println("${CDecl(e.t, id)} = ${e.value};")
        }
    }

    override fun visit(e: Expr.Ref): String {
        TODO("not implemented")
    }

    override fun visit(e: Expr.Apply): String {
        when (e.fn.t) {
            is Type.Op.Fun.Ref ->
                return withNewId { id ->
                    val funId = e.fn.accept(this)
                    val argIds = listOf(funId) + e.args.map { it.accept(this) }
                    out.code.println("retain($funId);")
                    argIds.drop(1).zip(e.args).forEach {
                        if (it.second.t.isManaged())
                            out.code.println("retain(${it.first});")
                    }
                    out.code.println("${CDecl(e.t, id)} = ((${CDecl.refFunImplDecl(e.fn.t as Type.Op.Fun.Ref, "(*)")})$funId->fun)(${argIds.joinToString(", ")});")
                    out.code.println("release($funId);")
                    argIds.drop(1).zip(e.args).forEach {
                        if (it.second.t.isManaged())
                            out.code.println("release(${it.first});")
                    }

                }
            is Type.Op.Fun.Native ->
                return withNewId { id ->
                    val funId = e.fn.accept(this)
                    val argIds = e.args.map { it.accept(this) }
                    argIds.zip(e.args).forEach {
                        if (it.second.t.isManaged())
                            out.code.println("retain(${it.first});")
                    }
                    out.code.println("${CDecl(e.t, id)} = ((${CDecl(e.fn.t)})$funId)(${argIds.joinToString(", ")});")
                    argIds.zip(e.args).forEach {
                        if (it.second.t.isManaged())
                            out.code.println("release(${it.first});")
                    }
                }
        }
        throw RuntimeException("shouldn't happen")
    }

    override fun visit(e: Expr.Unary): String {
        val operandId = e.operand.accept(this)
        return withNewId {
            out.code.println("${CDecl(e.t, it)} = ${e.operator}$operandId;")
        }
    }

    override fun visit(e: Expr.Binary): String {
        //TODO: short circuit && and ||
        val lhsId = e.lhs.accept(this)
        val rhsId = e.rhs.accept(this)
        return withNewId {
            out.code.println("${CDecl(e.t, it)} = $lhsId ${e.operator} $rhsId;")
        }
    }

    override fun visit(e: Expr.Fun.Native): String {

        //create param string
        val paramString = e.params.map { CDecl(it.t, it.id).toString() }.joinToString(", ")

        //create function signature
        val signature = "${CDecl(e.retType)} ${e.cId()}($paramString)"

        //generate declaration
        out.decls.run {
            println("$signature;")
        }

        //compile function body using new writer for output
        val bodyStringWriter = StringWriter()
        val bodyWriter = IndentedPrintWriter(bodyStringWriter)
        bodyWriter.run {
            println("$signature {")
            indent {
                e.body.accept(StatementCodeGenerator(Output(this, out.decls, out.defs)))
            }
            println("}")
        }
        //print fun body to def area
        out.defs.print(bodyStringWriter.buffer.toString())

        //allocate fun obj and initialize
        return withNewId { id ->
            out.code.run {
                println("${CDecl(e.t, id)} = ${e.cId()};")
            }
        }
    }

    override fun visit(e: Expr.Fun.Ref): String {

        //create param string
        val paramString =
            (listOf("struct fun *self") + e.params.map { "${CDecl(it.t, it.id)}" })
                .joinToString(", ")

        //create function signature
        val signature = "${CDecl(e.retType)} ${e.cId()}($paramString)"

        //generate declaration
        out.decls.run {
            println("$signature;")
        }

        //generate type of this function
        out.defs.run {
            println("struct ${e.cId()} {")
            indent {
                println("struct fun base;")
                e.captures.forEach { println("${CDecl(it.t, it.id)};") }
            }
            println("};")
        }

        //generate deinit function which releases captures
        if (e.captures.size != 0) {
            out.defs.run {
                println("void ${e.cId()}_deinit(struct obj *self) {")
                indent {
                    println("struct ${e.cId()} *fun_ptr = (struct ${e.cId()} *)self;")
                    e.captures.forEach {
                        if (it.t.isManaged()) {
                            println("release(&fun_ptr->${it.id}->base);")
                        }
                    }
                }
                println("};")
            }
        }

        //compile function body using new writer for output
        val bodyStringWriter = StringWriter()
        val bodyWriter = IndentedPrintWriter(bodyStringWriter)
        bodyWriter.run {
            println("$signature {")
            indent {
                e.body.accept(StatementCodeGenerator(Output(this, out.decls, out.defs)))
            }
            println("}")
        }
        //print fun body to def area
        out.defs.print(bodyStringWriter.buffer.toString())

        //allocate fun obj and initialize
        return withNewId { id ->
            out.code.run {
                println("struct ${e.cId()} *$id = malloc(sizeof(struct ${e.cId()}));")
                if (e.captures.size != 0)
                    println("init($id, ${e.cId()}_deinit);")
                else
                    println("init($id, NULL);")
                println("$id->base.fun = ${e.cId()};")
                e.captures.forEach {
                    val captureId = it.accept(this@ExprCodeGenerator)
                    println("$id->${it.id} = $captureId;")
                    if (it.t.isManaged())
                        println("retain(&$id->${it.id});")
                }
            }
        }
    }

    override fun visit(e: Expr.Extern): String {
        //generate extern decl
        out.decls.println("${CDecl.externDecl(e.t, e.id)};")
        //get fun type
        val t = e.t as Type.Op
        //allocate gig function
        return withNewId { id ->
            out.code.run {
                println("${CDecl(e.t, id)} = ${e.id};")
            }
        }
    }

}