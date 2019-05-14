package th.foju.intellij.plugin

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.actionSystem.PlatformDataKeys
import com.intellij.openapi.ui.Messages


class InEditorAction : AnAction("Hallo") {

    override fun actionPerformed(event: AnActionEvent) {
        val project = event.getProject()
        val editor = event.getRequiredData(CommonDataKeys.EDITOR)
        val document = editor.document
        val text = document.text

        val file = event.getRequiredData(PlatformDataKeys.VIRTUAL_FILE)
        val type = file.fileType

        val message =
            "Found file of type ${type.name} with ${text.length} characters on ${document.lineCount} lines.\nAnalysis results are:\n ...\n ... \n ..."
        Messages.showMessageDialog(project, message, "Results for abc-metric", Messages.getInformationIcon())

    }

}