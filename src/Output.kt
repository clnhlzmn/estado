
class Output {
    companion object {

        fun program(states: List<State>, out: IndentedPrintWriter) {
            out.apply {
                println("#include <stdio.h>")
                println("#include \"ert.c\"")
                events(states, this)
                states.flatten().filter { it.top || it.atomic }.forEach { s -> stateDeclaration(s, this) }
                states.flatten().filter { it.top || it.atomic }.forEach { s -> stateDefinition(s, this) }
                println("int main(void) {")
                indent {
                    println("ert_init();")
                    println("struct pair *main_instance = ert_lalloc(1);")
                    println("*ert_index(main_instance, 0) = (intptr_t)state_Main;")
                    println("ert_send_event(main_instance, entry);")
                    println("while (1) {")
                    indent {
                        println("struct pair *instance = NULL;")
                        println("intptr_t event = 0;")
                        println("if (ert_deque_event(&instance, &event) == 0) {")
                        indent {
                            println("void (*state)(struct pair *, intptr_t) = (void (*)(struct pair *, intptr_t))*ert_index(instance, 0);")
                            println("state(instance, event);")
                        }
                        println("}")
                    }
                    println("}")
                }
                println("}")
            }
        }

        fun events(states: List<State>, out: IndentedPrintWriter) {
            out.println("enum event {")
            out.indent {
                Compiler.getEvents(states).forEach { println("$it,") }
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