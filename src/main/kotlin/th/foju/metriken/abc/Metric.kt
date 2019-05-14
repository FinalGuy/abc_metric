package th.foju.metriken.abc

interface Metric {

    fun analyse(content: String): Score

}