package neatlin

/**
 * Get the separate digits of a number as [Int] without converting to [String]
 */
val Int.digits: List<Int>
    get() {
        val digits = mutableListOf<Int>()
        var i = this
        while (i > 0) {
            digits.add(0, i % 10)
            i /= 10
        }
        return digits
    }

class IntIterator internal constructor(val max: Int) : Iterator<Int> {
    init {
        if (max < 1) throw Exception("IntIterator can't be lower than 1")
    }
    var current = -1
    /**
     * Returns `true` if the iteration has more elements.
     */
    override fun hasNext() = (current != max)

    /**
     * Returns the next [Int] in the iteration.
     */
    override fun next(): Int {
        current++
        return current
    }

}

/**
 * Makes it possible to use an [Int] directly in a for loop instead of using something like [repeat], for example:
 *
 * `for (i in `**5**`) println(i)`
 */
operator fun Int.iterator(): IntIterator = IntIterator(this)