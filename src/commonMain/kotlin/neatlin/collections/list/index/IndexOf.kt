package neatlin.collections.list.index

/**
 * Matches a list with a smaller pattern list e.g
 * ```
 * val list = listOf(1, 2, 3, 4, 5)
 * val pattern = listOf(3, 4)
 * list.indexOf(pattern) // 2..3
 * ```
 */
@Throws(IndexOutOfBoundsException::class)
fun <T> List<T>.indexOf(patternList: List<T>, startIndex: Int = 0): IntRange? {
    // The last index it can check without going out of bounds
    val lastSearchIndex = lastIndex - patternList.lastIndex
    if (lastSearchIndex > lastIndex || startIndex < 0) throw IndexOutOfBoundsException()

    // Goes through every index where it has to attempt to match the pattern
    for (listIndex in (startIndex .. lastSearchIndex)) {
        // Goes through every element from the pattern and tries to match it
        for (patternIndex in patternList.indices) {
            if (this[listIndex + patternIndex] == patternList[patternIndex]) {
                if (patternIndex == patternList.lastIndex) {
                    return (listIndex) .. (listIndex + patternList.lastIndex)
                }
            }
            else break
        }
    }
    return null
}

/**
 * @return The first index where any of the specified elements are found or null if nothing is found.
 */
fun <T> List<T>.indexOfAny(vararg elements: T): Int? {
    for (i in this.indices) {
        if (elements.any { it == this[i] }) return i
    }
    return null
}