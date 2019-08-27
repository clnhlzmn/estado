
class TopLevelStateVisitor: estadoBaseVisitor<List<String>>() {

    override fun visitFile(ctx: estadoParser.FileContext?): List<String> =
        ctx!!.state()?.map { s -> s.ID().text!! }!!

}