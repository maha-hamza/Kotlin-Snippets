package leetcode_august

import kotlin.test.assertEquals

fun main() {
    /**
     * Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
     * Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3
     */
    assertEquals(maxProfit(intArrayOf(3, 3, 5, 0, 0, 3, 1, 4)), 6) //6
    /**
     * Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
     * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
     * engaging multiple transactions at the same time. You must sell before buying again.
     */
    assertEquals(maxProfit(intArrayOf(1, 2, 3, 4, 5)), 4) // 4
    /**
     * In this case, no transaction is done, i.e. max profit = 0
     */
    assertEquals(maxProfit(intArrayOf(7, 6, 4, 3, 1)), 0) // 0
    assertEquals(maxProfit(intArrayOf(2, 4, 1)), 2) // 2
    assertEquals(maxProfit(intArrayOf(3, 3, 5, 0, 0, 3, 1, 4)), 6) // 6 3-5 = 2 0-4=4
    assertEquals(maxProfit(intArrayOf(4, 1, 2)), 1) // 1
    assertEquals(maxProfit(intArrayOf(6, 1, 3, 2, 4, 7)), 7) // 7 1-3 2-7
    assertEquals(maxProfit(intArrayOf(2, 1, 2, 1, 0, 1, 2)), 3) // 3 1 - 2 0 - 2
    assertEquals(maxProfit(intArrayOf(1, 2, 4, 2, 5, 7, 2, 4, 9, 0)), 13)
}

fun maxProfit(prices: IntArray): Int {
    return when (prices.size < 2) {
        true -> 0
        else -> {
            val left = IntArray(prices.size) { 0 }
            val right = IntArray(prices.size) { 0 }
            var min = prices[0]
            var maxProfit = 0

            prices.forEachIndexed { index, i ->
                if (index > 0) {
                    min = min.coerceAtMost(i)
                    left[index] = left[index - 1].coerceAtLeast(i - min)
                }
            }

            right[prices.size - 1] = 0
            var max = prices[prices.size - 1]
            for (i in prices.size - 2 downTo 0) {
                max = max.coerceAtLeast(prices[i])
                right[i] = right[i + 1].coerceAtLeast(max - prices[i])
            }

            prices.forEachIndexed { index, _ ->
                maxProfit = maxProfit.coerceAtLeast(left[index] + right[index])
            }
            maxProfit
        }
    }
}