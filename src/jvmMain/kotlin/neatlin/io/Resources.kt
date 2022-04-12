package neatlin.io

import java.awt.image.BufferedImage
import java.io.ByteArrayInputStream
import java.io.InputStream
import javax.imageio.ImageIO

/**
 * Used for getting resources from project
 */
object Resources {
    /**
     * Takes **relative** path from the *resources folder* root.
     * @return Text from file
     */
    fun loadText(resource: String): String {
        return this::class.java.getResource(fixPath(resource))?.readText() ?: ""

    }
    /**
     * Takes **relative** path from the *resources folder* root.
     * @return Raw data as bytes
     */
    fun loadBytes(resource: String): ByteArray {
        return this::class.java.getResource(fixPath(resource))?.readBytes() ?: byteArrayOf()
    }
    /**
     * Takes **relative** path from the *resources folder* root.
     */
    fun loadStream(resource: String): InputStream? {
        return this::class.java.getResourceAsStream(fixPath(resource))
    }

    // TODO test this
    /**
     * Takes **relative** path from the *resources folder* root.
     */
    fun loadImage(resource: String): BufferedImage? {
        return ImageIO.read(ByteArrayInputStream(loadBytes(resource)))
    }

    private fun fixPath(path: String) = if (path.startsWith("/")) path else "/$path"
}