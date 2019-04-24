package th.foju.intellij.plugin

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.ui.Messages


class HelloAction : AnAction("Hallo") {

    override fun actionPerformed(event: AnActionEvent) {
        val project = event.getProject()
        val document = event.getData(CommonDataKeys.EDITOR)?.document
        val text = document?.text
        val message =
            if (text == null) {
                "Kein Editor selektiert."
            } else {
                "Habe ${text.length} Zeichen gefunden. Die Analyse nach ABC-Metrik ergab folgende Ergebnisse:\n ...\n ... \n ..."
            }
        Messages.showMessageDialog(project, message, "Greeting", Messages.getInformationIcon())

    }

}