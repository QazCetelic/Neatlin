package neatlin.collections.string

operator fun StringBuilder.plusAssign(value: Any) {
    append(value)
}

operator fun StringBuilder.plus(string: String): String {
    return this.append(string).toString()
}

operator fun StringBuilder.get(range: IntRange): String {
    return substring(range.first, range.last)
}