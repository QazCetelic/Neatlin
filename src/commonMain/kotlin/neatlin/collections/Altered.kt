package neatlin.collections

/**
 * Edit an *immutable* [Map] by converting it to a *mutable* [Map],
 * applying the provided lambda and make it *immutable* again.
 */
fun <K, V> Map<K, V>.altered(lambda: MutableMap<K, V>.() -> Unit): Map<K, V> {
    val mutableMap = this.toMutableMap()
    lambda(mutableMap)
    return mutableMap.toMap()
}

/**
 * Edit an *immutable* [List] by converting it to a *mutable* [List],
 * applying the provided lambda and make it *immutable* again.
 */
fun <V> List<V>.altered(lambda: MutableList<V>.() -> Unit): List<V> {
    val mutableList = this.toMutableList()
    lambda(mutableList)
    return mutableList.toList()
}

/**
 * Edit an *immutable* [Set] by converting it to a *mutable* [Set],
 * applying the provided lambda and make it *immutable* again.
 */
fun <V> Set<V>.altered(lambda: MutableSet<V>.() -> Unit): Set<V> {
    val mutableSet = this.toMutableSet()
    lambda(mutableSet)
    return mutableSet.toSet()
}