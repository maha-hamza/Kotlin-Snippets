package leetcode_august

fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {

    return when (intervals.isNotEmpty()) {
        true -> intervals
                .toList()
                .sortedBy { it.first() }
                .let {
                    var count = 0
                    var last = it[0].last()
                    it.forEachIndexed { index, ints ->
                        when (ints.first() < last && index >= 1) {
                            true -> {
                                last = last.coerceAtMost(ints.last())
                                count++
                            }
                            false -> last = ints.last()
                        }
                    }
                    count
                }
        false -> 0
    }
}

fun main() {
    println(eraseOverlapIntervals(arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 4), intArrayOf(1, 3))))//1
    println(eraseOverlapIntervals(arrayOf(intArrayOf(1, 2), intArrayOf(2, 3)))) //0
    println(eraseOverlapIntervals(arrayOf(intArrayOf(1, 2), intArrayOf(1, 2), intArrayOf(1, 2)))) // 2
    println(eraseOverlapIntervals(arrayOf(intArrayOf(1, 100), intArrayOf(11, 22), intArrayOf(1, 11), intArrayOf(2, 12)))) // 2
    println(eraseOverlapIntervals(arrayOf(intArrayOf(1, 2), intArrayOf(1, 3), intArrayOf(1, 4)))) // 2
}

