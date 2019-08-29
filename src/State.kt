
class State(val id: String,
            var parent: State?,
            val subStates: List<State>,
            val handlers: List<Handler>) {

    //returns a list of this state's ancestors starting with parents, then grandparents, etc..
    fun ancestors(): List<State> {
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

    fun siblings(): List<State> {
        return if (parent == null)
            emptyList()
        else {
            //return sub states of parent that are not this state
            parent!!.subStates.filter { it.id != id }
        }
    }

    fun fullName(): String = (ancestors().reversed() + this).joinToString("_") { it.id }

    companion object {
        //call func for each state and sub state
        fun forEach(states: List<State>, func:(State)->Unit) {
            states.forEach { func(it); forEach(it.subStates, func) }
        }

        //find the target state given a source state and target state name
        fun findTarget(states: List<State>, target: String): State? {
            var ret: State? = null
            forEach(states) { if (it.id == target) ret = it }
            return ret
        }
    }

}
