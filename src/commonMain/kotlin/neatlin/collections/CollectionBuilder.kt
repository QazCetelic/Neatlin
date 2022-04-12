package neatlin.collections

/**
 * [fillList] can be used instead of *`mutableListOf().apply{ CODE }.toList()`*
 * @return List<T>
 */
// Soon, it's currently still experimental: @Deprecated("The stdlib now has this as experimental features under the name \"buildList\"", ReplaceWith("buildList"))
fun <T> fillList(lambda: MutableList<T>.() -> Unit): List<T> {
    return mutableListOf<T>().apply(lambda).toList()
}

/**
 * [fillMap] can be used instead of *`mutableMapOf().apply{ CODE }.toMap()`*
 * @return Map<T>
 */
// Soon, it's currently still experimental: @Deprecated("The stdlib now has this as experimental features under the name \"buildList\"", ReplaceWith("buildMap"))
fun <K, V> fillMap(lambda: MutableMap<K, V>.() -> Unit): Map<K, V> {
    return mutableMapOf<K, V>().apply(lambda).toMap()
}