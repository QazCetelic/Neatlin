package neatlin.numbers

val Byte.even: Boolean
    get() = this % (2).toByte() == 0

val Short.even: Boolean
    get() = this % (2).toShort() == 0

val Int.even: Boolean
    get() = this % 2 == 0

val Long.even: Boolean
    get() = this % 2L == 0L

val Float.even: Boolean
    get() = this % 2F == 0F

val Double.even: Boolean
    get() = this % 2.0 == 0.0

val Number.even: Boolean
    get() = when (this) {
        is Byte -> this.even
        is Short -> this.even
        is Int -> this.even
        is Long -> this.even
        is Float -> this.even
        is Double -> this.even
        else -> this.toDouble().even
    }