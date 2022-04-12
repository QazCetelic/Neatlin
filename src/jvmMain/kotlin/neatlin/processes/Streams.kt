package neatlin.processes

import java.io.InputStream

/**
 * Gets the data from an [InputStream] as a [String]
 */
val InputStream.text
    get() = String(this.readBytes())

/**
 * Reads all bytes from the [InputStream] containing the errors and turns them into a [String]
 */
val Process.errors
    get() = this.errorStream.text

/**
 * Reads all bytes from the [InputStream] containing the response and turns them into a [String]
 */
val Process.response
    get() = this.inputStream.text

/**
 * Sends string to a process
 */
fun Process.reply(string: String) {
    this.outputStream.write(string.toByteArray())
    this.outputStream.flush()
}