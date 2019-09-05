
class Output {
    companion object {
        fun program(states: List<State>, out: IndentedPrintWriter) {
            out.println("#include \"ert.c\"")
            events(states, out)
            states.flatten().filter { it.top || it.atomic }.forEach { s -> out.println(Output.stateDeclaration(s)) }
            states.flatten().filter { it.top || it.atomic }.forEach { s -> out.println(Output.stateDefinition(s)) }
        }
        fun events(states: List<State>, out: IndentedPrintWriter) {
            out.println("enum event {")
            out.indent {
                Compiler.getEvents(states).forEach { println(it) }
            }
            out.println("};")
        }
        fun stateDeclaration(state: State): String {
            return "void state_${state.fullName}(struct pair *, intptr_t);"
        }
        fun stateDefinition(state: State): String {
            return "void state_${state.fullName}(struct pair *instance, intptr_t event) {\n" +
                "    " + Compiler.getHandlers(state).joinToString(" else ") { handler(state, it) } + "\n" +
            "}"
        }
        fun handler(state: State, handler: Handler): String {
            if (state.parent == null && handler.event == "entry") {
                //initialization of this instance, have to enter all initial substates
            } else if (handler.target != null) {
                //handler has transition, do exit actions for exit set, handler action, and entry actions for entry set
            } else {
                //just do handler action
            }
            return "if (event == ${handler.event}) {\n" +
                   "        printf(\"handled ${handler.event}\");\n" +
                   "    }"
        }
    }
}