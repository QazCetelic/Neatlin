package neatlin.collections.list

/**
 * Allows you to use the **`get`** operator instead of [List.subList].
 */
operator fun <T> List<T>.get(range: IntRange): List<T> {
    return this.subList(range.first, range.last)
}

/**
 * Sets a certain range with **one** value
 * ```kotlin
 * val list = mutableListOf(1, 1, 2, 2, 2, 1)
 * list[2..4] = 1
 * // list: 1, 1, 1, 1, 1, 1
 * ```
 */
operator fun <T> MutableList<T>.set(range: IntRange, value: T) {
    for (i in range) {
        this[i] = value
    }
}