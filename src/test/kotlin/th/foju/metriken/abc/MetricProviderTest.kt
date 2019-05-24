package th.foju.metriken.abc

import com.intellij.ide.highlighter.JavaFileType
import com.intellij.openapi.fileTypes.PlainTextFileType
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import th.foju.metriken.abc.java.MetricForJavaFiles

internal class MetricProviderTest {

    val cut = MetricProvider()

    @Test
    fun shouldContainMetricForJavaFiles() {
        val result = cut.metricFor(JavaFileType.INSTANCE)
        assert(result is MetricForJavaFiles)
    }

    @Test
    fun shouldThrowExcpetionForUnknownFileTypes() {
        assertThrows(UnknownFileType::class.java) { cut.metricFor(PlainTextFileType.INSTANCE) }
    }
}