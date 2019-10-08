package estado.ast.nodes

import estado.ast.visitors.ASTVisitor

interface ASTNode {
    fun <T> accept(visitor: ASTVisitor<T>): T
    var program: Program?
}