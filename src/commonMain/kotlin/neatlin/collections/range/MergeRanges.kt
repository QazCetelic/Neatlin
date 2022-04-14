package neatlin.collections.range

import neatlin.max
import neatlin.min

/*
------
    -----
   ---
             ----
                  --------
          ---------

1    2
    1   2
   1  2
             1  2
                  1      2
          1        2


    
 */
fun <T : Comparable<T>> List<ClosedRange<T>>.merge(): List<ClosedRange<T>> {
    val copy = this.toMutableList()
    val result = mutableListOf<ClosedRange<T>>()
    while (copy.isNotEmpty()) {
        var range = copy.removeAt(0)
        var i1 = 0
        while (i1 < copy.size) {
            val other = copy.removeAt(i1)
            if (range overlaps other) range = range combine other
            else result += other
            i1++
        }
        var i2 = 0
        while (i2 < result.size) {
            val other = result[i2]
            if (range overlaps other) {
                result.removeAt(i2)
                range = range combine other
            }
            i2++
        }

        result += range
    }
    return result
}

infix fun <T : Comparable<T>> ClosedRange<T>.overlaps(other: ClosedRange<T>): Boolean {
    return this.start in other || this.endInclusive in other || other.start in this || other.endInclusive in this
}

/**
 * Takes the smallest start and largest end of the two ranges and uses those to create a new range.
 */
infix fun <T : Comparable<T>> ClosedRange<T>.combine(other: ClosedRange<T>): ClosedRange<T> {
    return min(this.start, other.start) .. max(this.endInclusive, other.endInclusive)
}