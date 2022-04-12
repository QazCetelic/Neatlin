package neatlin.collections

/**
 * Returns a string of the contents of the [CharArray] instead of the reference like done otherwise with primitive arrays in Kotlin
 * The string is in the following format:
 *
 * `[value, value, value]`
 */
fun CharArray.contentToString() = joinToString (prefix = "[", postfix = "]") { it.toString() }
/**
 * Returns a string of the contents of the [ByteArray] instead of the reference like done otherwise with primitive arrays in Kotlin
 * The string is in the following format:
 *
 * `[value, value, value]`
 */
fun ByteArray.contentToString() = joinToString (prefix = "[", postfix = "]") { it.toString() }
/**
 * Returns a string of the contents of the [ShortArray] instead of the reference like done otherwise with primitive arrays in Kotlin
 * The string is in the following format:
 *
 * `[value, value, value]`
 */
fun ShortArray.contentToString() = joinToString (prefix = "[", postfix = "]") { it.toString() }
/**
 * Returns a string of the contents of the [IntArray] instead of the reference like done otherwise with primitive arrays in Kotlin
 * The string is in the following format:
 *
 * `[value, value, value]`
 */
fun IntArray.contentToString() = joinToString (prefix = "[", postfix = "]") { it.toString() }
/**
 * Returns a string of the contents of the [LongArray] instead of the reference like done otherwise with primitive arrays in Kotlin
 * The string is in the following format:
 *
 * `[value, value, value]`
 */
fun LongArray.contentToString() = joinToString (prefix = "[", postfix = "]") { it.toString() }
/**
 * Returns a string of the contents of the [FloatArray] instead of the reference like done otherwise with primitive arrays in Kotlin
 * The string is in the following format:
 *
 * `[value, value, value]`
 */
fun FloatArray.contentToString() = joinToString (prefix = "[", postfix = "]") { it.toString() }
/**
 * Returns a string of the contents of the [DoubleArray] instead of the reference like done otherwise with primitive arrays in Kotlin
 * The string is in the following format:
 *
 * `[value, value, value]`
 */
fun DoubleArray.contentToString() = joinToString (prefix = "[", postfix = "]") { it.toString() }