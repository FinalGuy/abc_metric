package th.foju.metriken.abc

import com.intellij.openapi.fileTypes.FileType
import java.lang.Exception

class UnknownFileType(val fileType: FileType) : Exception("Unknown file type " + fileType.name)