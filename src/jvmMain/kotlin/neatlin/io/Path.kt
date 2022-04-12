package neatlin.io

import java.nio.file.Path
import java.nio.file.Paths

/**
 * Allows you to write paths in your code like this example: `basePath/"folder"/"text.txt"`.
 */
operator fun Path.div(string: String): Path = this.resolve(string)

/**
 * Directly check if Path exists, does this by converting it to a file first and then checking
 */
fun Path.exists() = this.toFile().exists()

/**
 * Path creation syntax sugar
 */
fun String.toPath() = Paths.get(this)