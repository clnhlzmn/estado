
class State(val id: String,
            var parent: State?,
            val subStates: List<State>,
            val handlers: List<Handler>)
