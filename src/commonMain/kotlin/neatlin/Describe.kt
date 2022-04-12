package neatlin

import neatlin.collections.contentToString

/**
 * Returns and optionally prints a string of the provided object in the following format:
 *
 * `object-type[optionally-added-size]: "object-value"`
 *
 * e.g: `CharArray[3]: "[a, b, c]"`
 *
 * Specifically for debugging and logging it therefore automatically prints the returned value,
 * this can be turned off however by setting the `print` argument to `false`.
 */
inline fun <reified T : Any> T.describe(print: Boolean = true): String {
    val value: Pair<Int?, String> = when (this) {
        // All arrays with primitive types need separate code
        is CharArray -> Pair(size, contentToString())
        is ByteArray -> Pair(size, contentToString())
        is ShortArray -> Pair(size, contentToString())
        is IntArray -> Pair(size, contentToString())
        is LongArray -> Pair(size, contentToString())
        is FloatArray -> Pair(size, contentToString())
        is DoubleArray -> Pair(size, contentToString())

        // For arrays that don't contain primitives
        is Array<*> -> Pair(size, "$this")

        is String -> Pair(this.length, this)

        else -> Pair((if (this is Collection<*>) size else null), "$this")
    }

    val description = "${
        // Starts with the name of the object…
        T::class.simpleName
    }${ // …maybe adds the amount of entries if it's a collection…
        if (value.first != null) "[${value.first}]" else ""
        // …then adds the object as string
    }: \"${value.second}\""

    // Prints it by default unless it's specified as an optional parameter…
    if (print) println(description)
    // …also returns the String
    return description
}