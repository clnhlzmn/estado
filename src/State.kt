
class State(var id: String,
            var parent: State?,
            val subStates: List<State>,
            val handlers: List<Handler>) {

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

    override fun toString(): String {
        return "State(id='$id')"
    }

}
