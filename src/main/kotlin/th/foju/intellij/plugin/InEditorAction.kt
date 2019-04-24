package th.foju.intellij.plugin

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.ui.Messages


class InEditorAction : AnAction("Hallo") {

    override fun actionPerformed(event: AnActionEvent) {
        val project = event.getProject()
        val document = event.getRequiredData(CommonDataKeys.EDITOR).document
        val text = document.text
        val message = "Found ${text.length} characters. Analysis results are:\n ...\n ... \n ..."
        Messages.showMessageDialog(project, message, "Results for abc-metric", Messages.getInformationIcon())

    }

}