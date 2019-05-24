package th.foju.metriken.abc

import java.util.*

class MetricForJavaFiles : Metric {

    override fun analyse(content: String): Score {
        var assignments = 0
        var branches = 0
        var conditionals = 0
        val tokens = StringTokenizer(content)
        while (tokens.hasMoreTokens()) {
            val token = tokens.nextToken()
            if (isAssignment(token)) {
                assignments = assignments.inc()
            }
            if (isBranch(token)) {
                branches = branches.inc()
            }
            if (isConditional(token)) {
                conditionals = conditionals.inc()
            }
        }
        return Score(assignments, branches, conditionals)
    }

    private fun isAssignment(token: String): Boolean {
        return when (token) {
            "=" -> true
            "*=" -> true
            "/=" -> true
            "%=" -> true
            "+=" -> true
            "<<=" -> true
            ">>=" -> true
            "&=" -> true
            "|=" -> true
            "^=" -> true
            ">>>=" -> true
            "++" -> true
            "--" -> true
            else -> false
        }
    }

    private fun isBranch(token: String): Boolean {
        return when (token) {
            "new" -> true
            //TODO
            else -> false
        }
    }

    private fun isConditional(token: String): Boolean {
        return when (token) {
            "==" -> true
            "!=" -> true
            "<=" -> true
            ">=" -> true
            "<" -> true
            ">" -> true
            "if" -> true
            "else" -> true
            "case" -> true
            "default" -> true
            "try" -> true
            "catch" -> true
            "?" -> true
            else -> false
        }
    }

}
