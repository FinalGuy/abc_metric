package th.foju.metriken.abc

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ScoreTest {

    @Test
    fun sollDenScoreAlsLängeDesVektorsBerechnen() {
        val cut = Score(1, 1, 1)
        assertEquals(Math.sqrt(3.0), cut.total())
    }
}