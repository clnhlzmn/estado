
fun List<State>.forEachIncludingSubStates(func: (State)->Unit): Unit =
    forEach {
        func(it)
        it.subStates.forEachIncludingSubStates(func)
    }

fun List<State>.find(target: String): State? {
    var ret: State? = null
    forEachIncludingSubStates { if (it.id == target) ret = it }
    return ret
}