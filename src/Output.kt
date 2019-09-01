
class Output {
    companion object {
        fun events(states: List<State>): String {
            return "enum event {\n" +
               "    " + Compiler.getEvents(states).joinToString(",\n    ") + "\n" +
               "};"
        }
        fun stateDeclaration(state: State): String {
            return "void state_${state.fullName}(struct pair *, intptr_t);"
        }
        fun stateDefinition(state: State): String {
            return "void state_${state.fullName}(struct pair *instance, intptr_t event) {\n" +
                Compiler.getHandlers(state).map { handler(it) }.joinToString(" else ") + "\n" +
            "}"
        }
        fun handler(handler: Handler): String {
            return "    if (event == ${handler.event}) {\n" +
                   "        printf(\"handled ${handler.event}\");\n" +
                   "    }"
        }
    }
}