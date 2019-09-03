
class State(
    var id: String,
    val subStates: List<State> = emptyList(),
    val handlers: List<Handler> = emptyList(),
    var parent: State? = null
) {

    val fullName: String
        get() = (ancestors.reversed() + this).joinToString("_") { it.id }

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

    //If state is null, returns the set of all ancestors of this in ancestry order
    //(this's parent followed by the parent's parent, etc).
    //If state is non-null, returns in ancestry order the set of all ancestors of this,
    //up to but not including state. (A "proper ancestor" of a state is its parent, or the parent's parent,
    //or the parent's parent's parent, etc.)
    //If state is this's parent, or equal to this, or a descendant of this, returns the empty set.
    fun getProperAncestors(state: State?): List<State> {
        return if (state == null) ancestors
            else if (this == state || state.isDescendant(this)) emptyList()
            else ancestors.filterNot { a -> (listOf(state) + state.ancestors).contains(a) }
    }

    //return true if this is descendant of state
    fun isDescendant(state: State): Boolean = ancestors.contains(state)

    fun findTarget(target: String): State? {
        //look at this+siblings, then parent+parents siblings and so on
        return when {
            id == target -> this
            siblings.find { it.id == target } != null -> siblings.find { it.id == target }
            parent != null -> parent!!.findTarget(target)
            else -> null
        }
    }

    override fun toString(): String {
        return "State(id='$id')"
    }

    //gets a list of the substates that should be entered when entering this
    fun getInitialEntrySet(): List<State> {
        return if (subStates.isEmpty()) emptyList()
        else listOf(subStates.first()) + subStates.first().getInitialEntrySet()
    }

    companion object {

        //find the least common compound ancestor of a list of states
        //see https://www.w3.org/TR/scxml/#AlgorithmforSCXMLInterpretation
        fun findLCCA(states: List<State>): State? {
            if (states.size <= 1) return null
            states.first().ancestors.forEach { a ->
                if (states.drop(1).all { s -> s.isDescendant(a) }) return a
            }
            return null
        }

        fun getEntrySet(source: State, target: State) =
            (listOf(target) + target.getProperAncestors(findLCCA(listOf(source, target)))).reversed()

        fun getExitSet(source: State, target: State) =
            listOf(source) + source.getProperAncestors(findLCCA(listOf(source, target)))
    }

}
