package th.foju.intellij.plugin

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.actionSystem.PlatformDataKeys
import com.intellij.openapi.ui.Messages
import th.foju.metriken.abc.Metric
import th.foju.metriken.abc.MetricForJavaFiles
import th.foju.metriken.abc.MetricProvider
import th.foju.metriken.abc.UnknownFileType


class InEditorAction : AnAction("Hallo") {

    val metricProvider = MetricProvider()

    override fun actionPerformed(event: AnActionEvent) {
        val project = event.project
        val editor = event.getRequiredData(CommonDataKeys.EDITOR)
        val document = editor.document

        val file = event.getRequiredData(PlatformDataKeys.VIRTUAL_FILE)
        val type = file.fileType
        val text = document.text

        try {
            val metric = metricProvider.metricFor(type)
            val score = metric.analyse(text)
            val message =
                "Found file of type ${type.name} with ${text.length} characters on ${document.lineCount} lines.\nAnalysis results are:\n ...\n ... \n ...\n Score: ${score.total()}"
            Messages.showMessageDialog(project, message, "Results for abc-metric", Messages.getInformationIcon())
        } catch (e: UnknownFileType) {
            Messages.showErrorDialog("unknown file type", "unknown file type")
        }

    }

}