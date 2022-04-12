package neatlin.io

import java.io.File

/**
 * Checks if Folder contains other file/folder
 */
operator fun File.contains(childFile: File): Boolean {
    return childFile.exists() && childFile.toString().startsWith(this.toString())
}

operator fun File.div(childFile: String): File {
    return resolve(childFile)
}

val File.files: List<File>
    get() = (this.listFiles() ?: emptyArray<File>()).toList()