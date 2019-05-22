package th.foju.metriken.abc

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class ScoreTest {

    @Test
    fun sollDenScoreAlsLängeDesVektorsBerechnen() {
        val cut = Score(1, 1, 1)
        assertEquals(Math.sqrt(3.0), cut.total())
    }
}