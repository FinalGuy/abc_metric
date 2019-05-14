package th.foju.metriken.abc

class MetricForJavaFiles(val fileContent : String) : Metric {

    override fun analyse(content: String): Score {
        fileContent.split("\n").stream()
        return Score(0,0,0)
    }

}