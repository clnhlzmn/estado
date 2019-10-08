package gig.ast.visitors

import estado.ast.nodes.File
import estado.ast.nodes.Program
import estado.ast.visitors.BaseASTVisitor
import estado.util.IndentedPrintWriter
import estado.util.Output
import java.io.StringWriter

class ProgramCodeGenerator(val fileWriter: IndentedPrintWriter) : BaseASTVisitor<Unit>() {

    private val declStringWriter = StringWriter()
    private val declWriter = IndentedPrintWriter(declStringWriter)

    private val defStringWriter = StringWriter()
    private val defWriter = IndentedPrintWriter(defStringWriter)

    private val mainStringWriter = StringWriter()
    private val mainWriter = IndentedPrintWriter(mainStringWriter)

    override fun visit(p: Program) {
        p.files.forEach { it.accept(this) }
        fileWriter.run {
            println("#include \"gig.h\"")
            println()
            println(declStringWriter.buffer.toString())
            println(defStringWriter.buffer.toString())
            println("int main(void) {")
            indent {
                println(mainStringWriter.buffer.toString())
                println("return 0;")
            }
            println("}")
        }
    }

    override fun visit(f: File) {
        f.statements.forEach { it.accept(StatementCodeGenerator(Output(mainWriter, declWriter, defWriter))) }
    }

}