package neatlin.operators

import java.awt.Point

operator fun Point.unaryMinus(): Point {
    return Point(-x, -y)
}