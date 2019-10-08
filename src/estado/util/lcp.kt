package estado.util

/*find the longest common prefix of a set of strings*/
fun lcp(sa: List<String>): String {
    if (sa.isEmpty()) return ""
    if (sa.size == 1) return sa[0]
    val minLength = sa.map { it.length }.min()!!
    var oldPrefix = ""
    var newPrefix: String
    for (i in 1 .. minLength) {
        newPrefix = sa[0].substring(0, i)
        for (j in 1 until sa.size)
            if (!sa[j].startsWith(newPrefix)) return oldPrefix
        oldPrefix = newPrefix
    }
    return oldPrefix
}