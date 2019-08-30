
class Output {
    companion object {
        fun stateFunction(state: State): String {
            val ancestors = state.ancestors().reversed()
            val name = "state_${state.fullName}"
            return "void $name(struct pair *instance, intptr_t event) {\n" +
            "    switch (event) {\n" +
            "    }\n" +
            "}"
        }
    }
}