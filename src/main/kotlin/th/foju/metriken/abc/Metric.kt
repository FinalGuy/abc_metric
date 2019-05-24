package th.foju.metriken.abc

import com.intellij.psi.PsiFile

interface Metric {

    fun analyse(content: PsiFile): Score

}