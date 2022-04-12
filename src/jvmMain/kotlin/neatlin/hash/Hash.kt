package neatlin.hash

import neatlin.io.allBytes
import java.io.File
import java.security.MessageDigest

enum class Hash(internal val mdName: String) {
    MD2("MD2"),
    MD5("MD5"),
    SHA1("SHA-1"),
    SHA256("SHA-256"),
    SHA384("SHA-384"),
    SHA512("SHA-512");
}

// TODO consider using something else than invoke because it's hard to use

/**
 * Digests the values with the provided hashing algorithm
 */
operator fun Hash.invoke(string: String): ByteArray = MessageDigest.getInstance(this.mdName).digest(string.toByteArray())
/**
 * Digests the values with the provided hashing algorithm
 */
operator fun Hash.invoke(file: File): ByteArray = MessageDigest.getInstance(this.mdName).digest(file.allBytes)
/**
 * Digests the values with the provided hashing algorithm
 */
operator fun Hash.invoke(any: Any): ByteArray = MessageDigest.getInstance(this.mdName).digest(any.toString().toByteArray())