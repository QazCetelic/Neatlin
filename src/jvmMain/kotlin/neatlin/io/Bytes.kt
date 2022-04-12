package neatlin.io

import java.io.File

/**
 * The bytes contained in the file
 */
var File.bytes: ByteArray
    get() = this.readBytes()
    set(value) = this.writeBytes(value)

/**
 * The bytes contained in the file **or** the contents, if it's a directory.
 */
val File.allBytes: ByteArray
    get() {
        val bytes = mutableListOf<Byte>()
        for (file in this.walk()) {
            if (file.isFile) {
                for (byte in file.readBytes()) {
                    bytes += byte
                }
            }
        }
        return bytes.toByteArray()
    }