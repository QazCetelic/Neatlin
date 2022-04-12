package neatlin.collections.list

operator fun <T> List<T>.contains(patternList: List<T>): Boolean {
    val lastSearchIndex = lastIndex - patternList.lastIndex
    main@for (i in 0 .. lastSearchIndex) {
        match@for (matchIndex in patternList.indices) {
            if (this[i + matchIndex] == patternList[matchIndex]) continue@match
            else break@main
        }
        return true
    }
    return false
}