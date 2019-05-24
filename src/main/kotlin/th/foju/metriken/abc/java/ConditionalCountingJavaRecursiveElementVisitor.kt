package th.foju.metriken.abc.java

import com.intellij.psi.JavaRecursiveElementVisitor
import com.intellij.psi.PsiConditionalExpression

/*
 * http://www.jetbrains.org/intellij/sdk/docs/basics/architectural_overview/navigating_psi.html
 */

class ConditionalCountingJavaRecursiveElementVisitor : JavaRecursiveElementVisitor() {

    var numberOfConditionals = 0

    override fun visitConditionalExpression(expression: PsiConditionalExpression?) {
        super.visitConditionalExpression(expression)
        println("Conditional gefunden: "+expression?.text + " " +expression?.textRange)
        numberOfConditionals++
    }

    fun count() : Int {
        return numberOfConditionals
    }
}