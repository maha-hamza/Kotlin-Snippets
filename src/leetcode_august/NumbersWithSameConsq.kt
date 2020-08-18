package leetcode_august

import java.util.*


fun numsSameConsecDiff(N: Int, K: Int): IntArray {
    var nums = IntRange(0, 9).toList()
    return if (K in nums && N == 1) {
        nums.toIntArray()
    } else {
        IntRange(2, N).flatMap {
            val internal = mutableListOf<Int>()
            nums.forEach {
                val index = it % 10
                if (it > 0 && index + K < 10) internal.add(it * 10 + index + K)
                if (it > 0 && K > 0 && index - K >= 0) internal.add(it * 10 + index - K)
            }
            nums = internal
            nums
        }.filter { it.toString().length == N }.toIntArray()
    }
}

fun num(N: Int, K: Int): IntArray {
    var cur = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
    for (i in 2 .. N) {
        val cur2: MutableList<Int> = ArrayList()
        for (x in cur) {
            val y = x % 10
            if (x > 0 && y + K < 10) cur2.add(x * 10 + y + K)
            if (x > 0 && K > 0 && y - K >= 0) cur2.add(x * 10 + y - K)
        }
        cur = cur2
    }
    return cur.stream().mapToInt { j: Int? -> j!! }.toArray()
}

fun main() {
    println(numsSameConsecDiff(3, 7).toList()) //[181,292,707,818,929]
    println(numsSameConsecDiff(2, 1).toList()) //
    println(numsSameConsecDiff(1, 0).toList()) // []
    println(numsSameConsecDiff(1, 1).toList()) //
    println(numsSameConsecDiff(2, 0).toList()) //
}