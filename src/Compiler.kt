import org.omg.CORBA.TRANSACTION_MODE
import java.lang.RuntimeException

class Compiler {

    data class Transition(val from: State, val to: State)

    companion object {

        private fun hasDuplicates(states: List<State>): Boolean {
            return states.groupingBy { it.id }.eachCount().any { it.value > 1 }
                    || states.any { hasDuplicates(it.subStates) }
        }

        fun check(states: List<State>): Boolean {
            //check for duplicates
            if (hasDuplicates(states)) return false
            return true
        }

        fun getEvents(states: List<State>): List<String> {
            val ret = ArrayList<String>()
            states.forEachIncludingSubStates { s -> ret.addAll(s.handlers.map { h -> h.event }) }
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

        //get the handlers that state responds to including those of parent states
        fun getHandlers(state: State): List<Handler> {
            val list = ArrayList<Handler>()
            (listOf(state) + state.ancestors).reversed().forEach { s ->
                s.handlers.forEach { h ->
                    list.remove(h)
                    list.add(h)
                }
            }
            return list
        }

    }
}
