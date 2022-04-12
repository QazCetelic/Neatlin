package neatlin.collections.string

import neatlin.iterator

/**
 * Takes the text from a string within int ranges
 */
operator fun String.get(range: IntRange): String {
    return this.substring(range)
}

// OPERATORS

operator fun String.minus(otherString: String): String {
    return removeSuffix(otherString)
}

operator fun String.times(times: Number) = buildString {
    for (i in times.toInt()) {
        append(this)
    }
}
operator fun Number.times(string: String): String = string.times(this)

// This is kinda pointless
operator fun String.div(number: Number): String {
    return chunked(number.toInt())[0]
}

fun String.isUpperCase() = this.all { it.isUpperCase() }
fun String.isLowerCase() = this.all { it.isLowerCase() }