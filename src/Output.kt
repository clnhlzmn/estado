
class Output {
    companion object {
        fun events(states: List<State>): String {
            return "enum event {\n" +
               "    " + Compiler.getEvents(states).joinToString(",\n    ") + "\n" +
               "};"
        }
        fun stateFunction(state: State): String {
            return "void state_${state.fullName}(struct pair *instance, intptr_t event) {\n" +
            "    switch (event) {\n" +
            "    }\n" +
            "}"
        }
    }
}