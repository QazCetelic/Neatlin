package neatlin

import kotlin.math.max

fun List<IntRange>.merge(): List<IntRange> {
    val result = mutableListOf<IntRange>()
    var current = this[0]
    for (i in 1 until size) {
        val next = this[i]
        current = if (current.last + 1 >= next.first)
            IntRange(current.first, max(current.last, next.last))
        else {
            result.add(current)
            next
        }
    }
    result += current
    return result
}