package leetcode_august

fun mincostTickets(days: IntArray, costs: IntArray): Int {
    val dp = IntArray(366)
    for (element in days) {
        dp[element] = costs[0]
    }

    for (i in days[0] .. days[days.size - 1]) {
        dp[i] += dp[i - 1]
        dp[i] = dp[i].coerceAtMost((if (i < 7) 0 else dp[i - 7]) + costs[1])
        dp[i] = dp[i].coerceAtMost((if (i < 30) 0 else dp[i - 30]) + costs[2])
    }
    return dp[days[days.size - 1]]
}

fun main() {
    println(mincostTickets(intArrayOf(1, 4, 6, 7, 8, 20), intArrayOf(2, 7, 15)))//11
    println(mincostTickets(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31), intArrayOf(2, 7, 15)))//17
}