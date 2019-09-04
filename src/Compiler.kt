import java.lang.RuntimeException

class Compiler {

    data class Transition(val from: State, val to: State)

    companion object {

        private fun hasDuplicates(states: List<State>): Boolean {
            return states.groupingBy { it.id }.eachCount().any { it.value > 1 }
                    || states.any { hasDuplicates(it.subStates) }
        }

        private fun hasDuplicateHandlers(state: State): Boolean {
            return state.handlers.groupingBy { it.event }.eachCount().any { it.value > 1 }
        }

        fun check(states: List<State>): Boolean {
            //check for duplicates
            if (hasDuplicates(states)) return false
            if (states.flatten().any { hasDuplicateHandlers(it) }) return false
            return true
        }

        fun getEvents(states: List<State>): List<String> {
            val ret = ArrayList<String>()
            states.forEachIncludingSubStates { s -> ret.addAll(s.handlers.map { h -> h.event }) }
            ret.addAll(listOf("entry", "exit"))
            return ret.toSet().toList()
        }

        fun getTransitions(states: List<State>): List<Transition> {
            val ret = ArrayList<Transition>()
            states.forEachIncludingSubStates { s ->
                s.handlers.filter { h -> h.target != null }.forEach { h ->
                    val target = states.find(h.target!!) ?: throw RuntimeException("invalid target ${h.target}")
                    ret.add(Transition(s, target))
                }
            }
            return ret
        }

        //get the list of handlers that an instance of the given state will actually see at runtime
        //(may be different than the handlers listed in the state definition)
        fun getHandlers(state: State): List<Handler> {
            when {
                state.top -> {
                    val entryHandlers = (listOf(state) + state.getInitialEntrySet())
                        .map { it.handlers }.flatten().filter { it.event == "entry" }
                    //TODO combine entry handlers into one handler with all actions
                    val combinedEntryHandler = Handler("entry")
                    return listOf(combinedEntryHandler) + state.handlers
                        .filterNot { it.event == "entry" || it.event == "exit" }
                }
                state.atomic -> {
                    val exitHandlers = (listOf(state) + state.ancestors)
                        .map { it.handlers }.flatten().filter { it.event == "exit" }
                    //TODO combine exit handlers into one handler with all actions
                    val combinedExitHandler = Handler("exit")
                    return listOf(combinedExitHandler) + state.handlers
                        .filterNot { it.event == "entry" || it.event == "exit" }
                }
                else ->
                    return (listOf(state) + state.ancestors).map { it.handlers }.flatten()
                        .filterNot { it.event == "entry" || it.event == "exit" }
            }
        }

    }
}
