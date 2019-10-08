package estado.ast.nodes

import estado.ast.visitors.ASTVisitor
import estado.util.SourceLocation
import estado.util.toCIdentifier

open class BaseASTNode(val loc: SourceLocation) : ASTNode {

    override var program: Program? = null
        get() = field
        set(value) { field = value }

    override fun <T> accept(visitor: ASTVisitor<T>): T {
        TODO("not implemented")
    }
    //return a unique name based on source location that is a valid C identifier
    fun cId(): String {
        val sourceRoot = program!!.sourceRoot()
        return loc.fileName.removePrefix(sourceRoot).toCIdentifier() + "_" + loc.lineNumber + "_" + loc.column
    }
}