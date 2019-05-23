package th.foju.metriken.abc

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ScoreTest {

    @Test
    fun shouldComputeScoreAsTheLengthOfTheThreeDimensionalVector() {
        testScoreComputationResultsIn(Math.sqrt(3.0), Score(1, 1, 1))
        testScoreComputationResultsIn(Math.sqrt(12.0), Score(2, 2, 2))
    }

    private fun testScoreComputationResultsIn(expected: Double, cut: Score) {
        assertEquals(expected, cut.total())
    }
}