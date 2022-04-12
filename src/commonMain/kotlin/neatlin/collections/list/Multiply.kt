package neatlin.collections.list

/**
 * Multiply the contents of a list
 * @param list Original list
 * @param times The amount of times the content should be multiplied
 */
operator fun <T> List<T>.times(times: Int): List<T> {
    if (times < 1) return emptyList()

    val tempList = mutableListOf<T>()
    repeat(times) {
        tempList.addAll(this)
    }
    return tempList
}
/**
 * Multiply the contents of a list
 * @param list Original list
 * @param times The amount of times the content should be multiplied
 */
operator fun <T> Int.times(list: List<T>) = list.times(this)