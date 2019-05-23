package th.foju.metriken.abc

import kotlin.math.pow

class Score(val assignments: Int, val branches: Int, val conditionals: Int) {

    fun total(): Double {
        return Math.sqrt(assignments.toDouble().pow(2) + branches.toDouble().pow(2) + conditionals.toDouble().pow(2))
    }

}