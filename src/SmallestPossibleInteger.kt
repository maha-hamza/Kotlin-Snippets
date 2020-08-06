fun main() {
    val n = intArrayOf(1, 3, 6, 4, 1, 2, 5, 8)
    println(smallestPossibleInteger(n))
}

fun smallestPossibleInteger(n: IntArray): Int {
    var temp = 0
    n.distinct().sorted().forEach {
        if (temp > 0 && temp != it - 1) {
            return temp + 1
        }
        temp = it
    }

    return 0
}