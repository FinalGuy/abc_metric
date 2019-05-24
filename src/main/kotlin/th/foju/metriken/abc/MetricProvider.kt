package th.foju.metriken.abc

import com.intellij.ide.highlighter.JavaFileType
import com.intellij.openapi.fileTypes.FileType
import th.foju.metriken.abc.java.MetricForJavaFiles

class MetricProvider{

    fun metricFor(fileType: FileType): Metric {
        if (fileType is JavaFileType) {
            return MetricForJavaFiles()
        } else {
            throw UnknownFileType(fileType)
        }
    }

}