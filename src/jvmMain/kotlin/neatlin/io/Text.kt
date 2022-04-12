package neatlin.file

import java.io.File

var File.text: String
    get() = this.readText()
    set(value) = this.writeText(value)

/**
 * Appends string to file
 */
operator fun File.plusAssign(string: String) {
    this.appendText(string)
}

/**
 * **Reads file** and checks if the file contains provided string
 */
operator fun File.contains(string: String): Boolean {
    return this.readText().contains(string)
}

/**
 * Deletes all content of a file
 */
fun File.empty() {
    this.writeBytes(byteArrayOf())
}