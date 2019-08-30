
class State(var id: String,
            var parent: State?,
            val subStates: List<State>,
            val handlers: List<Handler>) {

    //returns a list of this state's ancestors starting with parents, then grandparents, etc..
    val ancestors: List<State> get() {
        var current = this
        val iterator = object: Iterator<State> {
            override fun hasNext() = current.parent != null
            override fun next(): State {
                current = current.parent!!
                return current
            }
        }
        return iterator.asSequence().toList()
    }

    val siblings: List<State> get() {
        return if (parent == null)
            emptyList()
        else {
            //return sub states of parent that are not this state
            parent!!.subStates.filter { it.id != id }
        }
    }

    override fun toString(): String {
        return "State(id='$id')"
    }

    val fullName: String
        get() = (ancestors.reversed() + this).joinToString("_") { it.id }

}
