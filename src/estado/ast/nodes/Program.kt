package estado.ast.nodes

import estado.ast.visitors.ASTVisitor
import estado.util.SourceLocation
import estado.util.lcp
import java.nio.file.Paths

class Program(val files: List<File>): BaseASTNode(SourceLocation("program", 0, 0)) {

    fun sourceRoot(): String {
        if (files.size == 1) return files.first().name.removeSuffix(Paths.get(files.first().name).fileName.toString())
        else return lcp(files.map { it.name })
    }

    override fun <T> accept(visitor: ASTVisitor<T>): T {
        return visitor.visit(this)
    }

    override fun toString(): String {
        return files.map { it.toString() }.joinToString(" ")
    }
}