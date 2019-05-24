package th.foju.metriken.abc.java

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MetricForJavaFilesTest {

    val cut = MetricForJavaFiles()

    @Test
    internal fun `should return number of assignments`() {
        cut.analyse()
    }
}