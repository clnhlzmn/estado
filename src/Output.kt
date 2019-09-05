
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
            out.apply {
                println("enum event {")
                indent {
                    Compiler.getEvents(states).forEach { println("$it,") }
                }
                println("};")
            }
        }

        fun stateDeclaration(state: State, out: IndentedPrintWriter) {
            out.println("void state_${state.fullName}(struct pair *, intptr_t);")
        }

        fun stateDefinition(state: State, out: IndentedPrintWriter) {
            out.apply {
                println("void state_${state.fullName}(struct pair *instance, intptr_t event) {")
                indent {
                    val handlers = Compiler.getHandlers(state).groupBy { it.event }
                    println("switch (event) {")
                    indent {
                        handlers.forEach { handler(state, it.value[0], this) }
                    }
                    println("}")
                }
                println("}")
            }
        }

        fun handler(state: State, handler: Handler, out: IndentedPrintWriter) {
            out.apply {
                println("case ${handler.event}: {")
                indent {
                    if (state.top && handler.event == "entry") {
                        //initialization of this instance, have to enter all initial substates
                        (listOf(state) + state.getInitialEntrySet()).forEach {
                            println("printf(\"entered ${it.fullName}\\n\");")
                        }
                    } else if (handler.target != null) {
                        //handler has transition, do exit actions for exit set, handler action, and entry actions for entry set
                        val target = state.findTarget(handler.target)
                        if (target == null) throw RuntimeException("invalid target ${handler.target} in ${state.fullName}")
                        val exitSet = State.getExitSet(state, target)
                        val entrySet = State.getEntrySet(state, target)
                        exitSet.forEach {
                            println("printf(\"exited ${it.fullName}\\n\");")
                        }
                        println("printf(\"handled ${handler.event} in ${state.fullName}\\n\");")
                        entrySet.forEach {
                            println("printf(\"entered ${it.fullName}\\n\");")
                        }
                    } else {
                        //just do handler action
                        println("printf(\"handled ${handler.event} in ${state.fullName}\\n\");")
                    }
                    println("break;")
                }
                println("}")
            }
        }
    }
}