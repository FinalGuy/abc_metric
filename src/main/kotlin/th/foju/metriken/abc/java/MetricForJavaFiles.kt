package th.foju.metriken.abc.java

import com.intellij.psi.PsiFile
import th.foju.metriken.abc.Metric
import th.foju.metriken.abc.Score

class MetricForJavaFiles : Metric {

    override fun analyse(content: PsiFile): Score {
        val assignmentsCounter = AssignmentCountingJavaRecursiveElementVisitor()
        // branches
        val conditionalsCounter = ConditionalCountingJavaRecursiveElementVisitor()

        content.accept(assignmentsCounter)
        // branches
        content.accept(conditionalsCounter)

        return Score(assignmentsCounter.count(), 0, conditionalsCounter.count())
    }

}
