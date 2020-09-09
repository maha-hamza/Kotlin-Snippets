package src

import kotlin.math.sqrt

fun mySqrt(x: Int): Int {
    return sqrt(x.toDouble()).toInt()
}

fun main() {
    println(mySqrt(8))
}