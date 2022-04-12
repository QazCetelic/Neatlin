package neatlin.io

import java.io.File

/**
 * Deletes all empty (sub) directories (including itself)
 * @return If at least one file is found, which means that the folder won't be deleted.
 */
fun File.deleteEmptyDirectories(): Boolean {
    val files = this.listFiles().orEmpty()
    var fileFound = false
    for (file in files) when {
        file.isDirectory -> {
            val fileFoundInSubFolder = file.deleteEmptyDirectories()
            // Delete directories if they don't contain files
            if (!fileFoundInSubFolder) file.deleteRecursively()
            fileFound = fileFoundInSubFolder
        }
        file.isFile -> fileFound = true
    }
    if (!fileFound) delete()
    return fileFound
}
