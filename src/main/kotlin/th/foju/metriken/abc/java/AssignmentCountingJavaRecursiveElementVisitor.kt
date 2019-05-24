package th.foju.metriken.abc.java

import com.intellij.psi.JavaRecursiveElementVisitor
import com.intellij.psi.PsiAssignmentExpression

/*
 * http://www.jetbrains.org/intellij/sdk/docs/basics/architectural_overview/navigating_psi.html
 */

class AssignmentCountingJavaRecursiveElementVisitor : JavaRecursiveElementVisitor() {

    var numberOfAssignments = 0

    override fun visitAssignmentExpression(expression: PsiAssignmentExpression?) {
        super.visitAssignmentExpression(expression)
        println("Assignment gefunden: "+expression?.text + " " +expression?.textRange)
        numberOfAssignments++
    }

    fun count() : Int {
        return numberOfAssignments
    }
}