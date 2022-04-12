package neatlin

fun <T> T.applyIf(condition: Boolean, block: T.() -> T): T {
    return if (condition) block(this)
    else this
}