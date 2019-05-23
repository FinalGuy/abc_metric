package th.foju.metriken.abc

class MetricForJavaFiles : Metric {

    override fun analyse(content: String): Score {
        content.split("\n").stream()
        return Score(0, 0, 0)
    }

}