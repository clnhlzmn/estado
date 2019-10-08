package estado.ast.nodes

sealed class Definition() {
    sealed class Let(val node: Statement.Let) : Definition() {
        class Global(node: Statement.Let): Let(node)
        class Local(node: Statement.Let): Let(node)
        class NonLocal(node: Statement.Let): Let(node)
    }
    sealed class Param(val node: Expr.Fun.Param) : Definition() {
        class Local(node: Expr.Fun.Param): Param(node)
        class NonLocal(node: Expr.Fun.Param): Param(node)
    }
}