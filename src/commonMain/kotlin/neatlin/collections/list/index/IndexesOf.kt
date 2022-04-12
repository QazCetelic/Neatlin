package neatlin.collections.list.index

/**
 * All the indexes where the element occurs in the [List]
 */
fun <T> List<T>.indexesOf(element: T, startIndex: Int = 0): List<Int> {
    if (startIndex < 0 || startIndex > lastIndex) throw IllegalArgumentException()
    val indexes = mutableListOf<Int>()
    for (i in (startIndex..lastIndex)) {
        if (this[i] == element) indexes += i
    }
    return indexes.toList()
}

fun <T> List<T>.indexesOf(pattern: List<T>, startIndex: Int = 0): List<IntRange> {
    val indexes = mutableListOf<IntRange>()
    var currentIndex: Int? = startIndex
    while (currentIndex != lastIndex) {
        currentIndex = this.indexOf(pattern, startIndex = currentIndex!!)?.first
        if (currentIndex == null) return indexes
        indexes += (currentIndex)..(currentIndex + pattern.size)
        currentIndex += 1
    }
    return indexes.toList()
}

/**
 * All the indexes where the predicate matches an element in the [List]
 */
fun <T> List<T>.indexesOf(predicate: (Int, T) -> Boolean): List<Int> {
    val indexes = mutableListOf<Int>()
    for (i in this.indices) {
        if (predicate(i, this[i])) indexes += i
    }
    return indexes.toList()
}

/**
 * All the indexes where the element occurs in the [CharSequence]
 */
fun CharSequence.indexesOf(char: Char): List<Int> {
    val indexes = mutableListOf<Int>()
    for (i in this.indices) {
        if (this[i] == char) indexes += i
    }
    return indexes.toList()
}

/**
 * All the indexes where the element occurs in the [CharSequence]
 */
fun CharSequence.indexesOf(string: String): List<IntRange> {
    return this.toList().indexesOf(string.toList())
}

/**
 * All the indexes where the predicate matches an element in the [CharSequence]
 */
fun CharSequence.indexesOf(predicate: (Int, Char) -> Boolean): List<Int> {
    val indexes = mutableListOf<Int>()
    for (i in this.indices) {
        if (predicate(i, this[i])) indexes += i
    }
    return indexes.toList()
}