
class State(val id: String,
            var parent: State?,
            val subStates: List<State>,
            val handlers: List<Handler>) {

    //returns a list of this state's parents in closest related order
    fun parents(): List<State> {
        var current = this
        val iter = object: Iterator<State> {
            override fun hasNext() = current.parent != null
            override fun next(): State {
                current = current.parent!!
                return current
            }
        }
        return iter.asSequence().toList()
    }
}
