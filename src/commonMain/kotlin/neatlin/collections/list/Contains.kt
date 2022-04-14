package neatlin.collections.list

import neatlin.collections.list.index.indexOf

operator fun <T> List<T>.contains(pattern: List<T>): Boolean {
    return this.indexOf(pattern) != null
}