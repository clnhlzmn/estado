import org.junit.jupiter.api.Assertions.*

internal class StateTest {

    //               s1            s2
    //             /   \           |
    //           /      \         s21
    //         s11      s12
    //        /  \      /  \
    //     s111 s112 s121 s122

    val s111 = State("s111")
    val s112 = State("s112")
    val s11 = State("s11", listOf(s111, s112))

    val s121 = State("s121")
    val s122 = State("s122")
    val s12 = State("s12", listOf(s121, s122))

    val s1 = State("s1", listOf(s11, s12))

    val s21 = State("s21")
    val s2 = State("s2", listOf(s21))

    init {
        s111.parent = s11
        s112.parent = s11

        s121.parent = s12
        s122.parent = s12

        s11.parent = s1
        s12.parent = s1

        s21.parent = s2
    }

    @org.junit.jupiter.api.Test
    fun ancestors() {
        assertEquals(listOf(s11, s1), s111.ancestors)
    }

    @org.junit.jupiter.api.Test
    fun isDescendant() {

    }

    @org.junit.jupiter.api.Test
    fun findLCCA() {
        assertEquals(s11, State.findLCCA(listOf(s111, s112)))
        assertEquals(s1, State.findLCCA(listOf(s111, s122)))
        assertEquals(s1, State.findLCCA(listOf(s111, s12)))
        assertEquals(s1, State.findLCCA(listOf(s11, s12)))
        assertEquals(null, State.findLCCA(listOf(s11, s21)))
    }

    @org.junit.jupiter.api.Test
    fun getEntrySet() {
        assertEquals(listOf(s12, s121), State.getEntrySet(s111, s121))
        assertEquals(listOf(s1, s11, s111), State.getEntrySet(s2, s111))
    }

    @org.junit.jupiter.api.Test
    fun getExitSet() {
        assertEquals(listOf(s111, s11), State.getExitSet(s111, s121))
        assertEquals(listOf(s2), State.getExitSet(s2, s111))

    }
}