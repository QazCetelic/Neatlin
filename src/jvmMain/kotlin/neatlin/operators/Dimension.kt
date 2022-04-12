package neatlin.operators

import java.awt.Dimension

operator fun Dimension.div(number: Int): Dimension {
    val newHeight   = height / number
    val newWidth    = width / number
    return Dimension(newWidth, newHeight)
}

operator fun Dimension.times(number: Int): Dimension {
    val newHeight   = height * number
    val newWidth    = width * number
    return Dimension(newWidth, newHeight)
}

infix fun Int.by(int: Int): Dimension = Dimension(this, int)