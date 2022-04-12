package neatlin.io.zipfile

import java.awt.image.BufferedImage
import java.nio.charset.Charset
import java.util.zip.ZipEntry
import java.util.zip.ZipFile
import javax.imageio.ImageIO

/**
 * Shortcut to read all bytes from input stream and converts it to a string
 */
fun ZipFile.getText(zipEntry: ZipEntry): String {
    val stream = this.getInputStream(zipEntry)
    val bytes = stream.readBytes()
    stream.close()
    return bytes.toString(Charset.defaultCharset())
}

/**
 * Shortcut to read all bytes from input stream and converts it to a java awt image
 */
fun ZipFile.getAWTImage(zipEntry: ZipEntry?): BufferedImage? {
    if (zipEntry != null) {
        val stream = this.getInputStream(zipEntry)
        val image = ImageIO.read(stream)
        stream.close()

        return image
    }
    else return null
}

/**
 * Shortcut to read all bytes from input stream and converts it to a string
 */
fun ZipFile.getText(entry: String): String? {
    val zipEntry = this[entry]
    return if (zipEntry != null) {
        val stream = this.getInputStream(zipEntry)
        val bytes = stream.readBytes()
        stream.close()

        bytes.toString(Charset.defaultCharset())
    } else null
}

/**
 * Shortcut to read all bytes from input stream and converts it to a java awt image
 */
fun ZipFile.getAWTImage(entry: String): BufferedImage? {
    val zipEntry = this[entry]
    if (zipEntry != null) {
        val stream = this.getInputStream(zipEntry)
        val image = ImageIO.read(stream)
        stream.close()

        return image
    } else return null
}

operator fun ZipFile.get(entry: String): ZipEntry? {
    return this.getEntry(entry)
}