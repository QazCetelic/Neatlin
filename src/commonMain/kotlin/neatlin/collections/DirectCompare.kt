package neatlin.collections

/**
 * Directly compare collections
 */
operator fun <T> Collection<T>.compareTo(otherList: Collection<T>): Int {
    return this.size - otherList.size
}