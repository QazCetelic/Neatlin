package neatlin.collections.list

import neatlin.collections.list.index.*

/**
 * Replace every occurrence of a certain value in a list.
 */
fun <T> List<T>.replace(old: T, new: T): List<T> {
    return this.map {
        if (it == old) new
        else it
    }
}

/**
 * Replace a list of values every occurrence of a certain value in a list.
 */
tailrec fun <T> List<T>.replace(old: List<T>, new: List<T>): List<T> {
    // Returns itself when no match is found
    val matchIndex: IntRange = indexOf(old) ?: return this

    val beforeFirstMatch =
        if (matchIndex.first != 0) this[0 .. (matchIndex.first - 1).coerceAtLeast(0)]
        else emptyList()

    val afterFirstMatch =
        if (matchIndex.last != lastIndex) this[(matchIndex.last + 1) .. lastIndex]
        else emptyList()

    val newList = beforeFirstMatch + new + afterFirstMatch

    return newList.replace(old, new)
}