

class SubStateVisitor: estadoBaseVisitor<List<Pair<String, String>>>() {

    override fun visitFile(ctx: estadoParser.FileContext?): List<Pair<String, String>> =
        ctx!!.state()
            ?.map { s -> s.accept(this) }
            ?.fold(emptyList()) { acc, list -> acc + list }!!

    override fun visitState(ctx: estadoParser.StateContext?): List<Pair<String, String>> =
        ctx!!.state()
            ?.map { s -> s.accept(this) + Pair(s.ID().text!!, ctx.ID().text!!) }
            ?.fold(emptyList()) { acc, list -> acc + list }!!

}
