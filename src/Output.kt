
class Output {
    companion object {

        fun program(states: List<State>, out: IndentedPrintWriter) {
            out.println("#include \"ert.c\"")
            events(states, out)
            states.flatten().filter { it.top || it.atomic }.forEach { s -> stateDeclaration(s, out) }
            states.flatten().filter { it.top || it.atomic }.forEach { s -> stateDefinition(s, out) }
        }

        fun events(states: List<State>, out: IndentedPrintWriter) {
            out.println("enum event {")
            out.indent {
                Compiler.getEvents(states).forEach { println(it) }
            }
            out.println("};")
        }

        fun stateDeclaration(state: State, out: IndentedPrintWriter) {
            out.println("void state_${state.fullName}(struct pair *, intptr_t);")
        }

        fun stateDefinition(state: State, out: IndentedPrintWriter) {
            out.println("void state_${state.fullName}(struct pair *instance, intptr_t event) {")
            out.indent {
                Compiler.getHandlers(state).forEach { handler(state, it, this) }
            }
            out.println("}")
        }

        fun handler(state: State, handler: Handler, out: IndentedPrintWriter) {
            if (state.parent == null && handler.event == "entry") {
                //initialization of this instance, have to enter all initial substates
            } else if (handler.target != null) {
                //handler has transition, do exit actions for exit set, handler action, and entry actions for entry set
            } else {
                //just do handler action
            }
            out.println("if (event == ${handler.event}) {")
            out.indent {
                println("printf(\"handled ${handler.event}\");")
                println("return;")
            }
            out.println("}")
        }
    }
}