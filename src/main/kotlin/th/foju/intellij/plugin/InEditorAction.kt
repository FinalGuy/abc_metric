package th.foju.intellij.plugin

import com.intellij.openapi.actionSystem.*
import com.intellij.openapi.ui.Messages
import th.foju.metriken.abc.MetricProvider
import th.foju.metriken.abc.UnknownFileType


class InEditorAction : AnAction("ABC-Metric") {

    val metricProvider = MetricProvider()

    override fun actionPerformed(event: AnActionEvent) {
        val project = event.project
        val editor = event.getRequiredData(CommonDataKeys.EDITOR)
        val document = editor.document

        val file = event.getRequiredData(PlatformDataKeys.VIRTUAL_FILE)
        val type = file.fileType
        val text = document.text

        try {
            val psiFile = event.getData(DataKeys.PSI_FILE)?:throw IllegalStateException()
            val score = metricProvider.metricFor(type).analyse(psiFile)
            val message =
                "Found file of type ${type.name} with ${text.length} characters on ${document.lineCount} lines.\nAnalysis results are:\n\n"+
                        "Assignments:\t${score.assignments}\n"+
                        "Branches:\t\t${score.branches}\n"+
                        "Conditionals:\t${score.conditionals}\n\n"+
                        "Overall score:\t${score.total()}"
            Messages.showMessageDialog(project, message, "Results for abc-metric", Messages.getInformationIcon())
        } catch (e: UnknownFileType) {
            Messages.showErrorDialog("Unable to analyse files of type ${e.fileType.name}. Feature is not yet implemented for those file types.","Unknown file type")
        }

    }

}