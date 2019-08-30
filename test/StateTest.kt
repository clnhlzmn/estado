import org.junit.jupiter.api.Assertions.*

internal class StateTest {

    @org.junit.jupiter.api.Test
    fun getProperAncestors() {
        val child = State("child", emptyList(), emptyList(), null)
        val parent = State("parent", listOf(child), emptyList(), null)
        child.parent = parent
        assertEquals(parent, child.ancestors[0])
    }

    @org.junit.jupiter.api.Test
    fun isDescendant() {

    }

    @org.junit.jupiter.api.Test
    fun findLCCA() {

        //               s1            s2
        //             /   \           |
        //           /      \         s21
        //         s11      s12
        //        /  \      /  \
        //     s111 s112 s121 s122

        val s111 = State("s111")
        val s112 = State("s112")
        val s11 = State("s11", listOf(s111, s112))
        s111.parent = s11
        s112.parent = s11

        val s121 = State("s121")
        val s122 = State("s122")
        val s12 = State("s12", listOf(s121, s122))
        s121.parent = s12
        s122.parent = s12

        val s1 = State("s1", listOf(s11, s12))
        s11.parent = s1
        s12.parent = s1

        val s21 = State("s21")
        val s2 = State("s2", listOf(s21))
        s21.parent = s2

        assertEquals(s11, State.findLCCA(listOf(s111, s112)))
        assertEquals(s1, State.findLCCA(listOf(s111, s122)))
        assertEquals(s1, State.findLCCA(listOf(s111, s12)))
        assertEquals(s1, State.findLCCA(listOf(s11, s12)))
        assertEquals(null, State.findLCCA(listOf(s11, s21)))
    }

    @org.junit.jupiter.api.Test
    fun getEntrySet() {

        //               s1            s2
        //             /   \           |
        //           /      \         s21
        //         s11      s12
        //        /  \      /  \
        //     s111 s112 s121 s122

        val s111 = State("s111")
        val s112 = State("s112")
        val s11 = State("s11", listOf(s111, s112))
        s111.parent = s11
        s112.parent = s11

        val s121 = State("s121")
        val s122 = State("s122")
        val s12 = State("s12", listOf(s121, s122))
        s121.parent = s12
        s122.parent = s12

        val s1 = State("s1", listOf(s11, s12))
        s11.parent = s1
        s12.parent = s1

        val s21 = State("s21")
        val s2 = State("s2", listOf(s21))
        s21.parent = s2

        assertEquals(listOf(s12, s121), State.getEntrySet(s111, s121))
        assertEquals(listOf(s1, s11, s111), State.getEntrySet(s2, s111))

    }

    @org.junit.jupiter.api.Test
    fun getExitSet() {

        //               s1            s2
        //             /   \           |
        //           /      \         s21
        //         s11      s12
        //        /  \      /  \
        //     s111 s112 s121 s122

        val s111 = State("s111")
        val s112 = State("s112")
        val s11 = State("s11", listOf(s111, s112))
        s111.parent = s11
        s112.parent = s11

        val s121 = State("s121")
        val s122 = State("s122")
        val s12 = State("s12", listOf(s121, s122))
        s121.parent = s12
        s122.parent = s12

        val s1 = State("s1", listOf(s11, s12))
        s11.parent = s1
        s12.parent = s1

        val s21 = State("s21")
        val s2 = State("s2", listOf(s21))
        s21.parent = s2

        assertEquals(listOf(s111, s11), State.getExitSet(s111, s121))
        assertEquals(listOf(s2), State.getExitSet(s2, s111))

    }
}