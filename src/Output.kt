
class Output {
    companion object {
        fun stateFunction(state: State): String {
            val name = "state_${state.fullName}"
            return "void $name(struct pair *instance, intptr_t event) {\n" +
            "    switch (event) {\n" +
            "    }\n" +
            "}"
        }
    }
}