class StatementVisitor: estadoBaseVisitor<Statement>() {
    override fun visitMessageStatement(ctx: estadoParser.MessageStatementContext?): Statement {
        return Statement()
    }
}