

class Compiler {

    class Transition(val from: State, val to: State)

    companion object {

        private fun hasDuplicates(states: List<State>): Boolean {
            return states.groupingBy { it.id }.eachCount().any { it.value > 1 }
                    || states.any { hasDuplicates(it.subStates) }
        }

        fun check(actors: List<State>): Boolean {
            //check for duplicates
            if (hasDuplicates(actors)) return false
            return true
        }

        fun getEvents(states: List<State>): List<String> {
            val ret = ArrayList<String>()
            State.forEach(states) { ret.addAll(it.handlers.map { it.event }) }
            return ret.toSet().toList()
        }

        fun getTransitions(states: List<State>): List<Transition> {
            val ret = ArrayList<Transition>()

            return ret
        }

    }
}
