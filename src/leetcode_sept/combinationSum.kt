package src.leetcode_sept

import java.util.*


/**
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
Note:
All numbers will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:
Input: k = 3, n = 7
Output: [[1,2,4]]
Example 2:
Input: k = 3, n = 9
Output: [[1,2,6], [1,3,5], [2,3,4]]
 */

fun combinationSum3(k: Int, n: Int): List<List<Int>> {
    val result: MutableList<List<Int>> = ArrayList()
    val curr: MutableList<Int> = ArrayList()
    helper(result, curr, k, 1, n)
    return result
}

fun helper(result: MutableList<List<Int>>, curr: MutableList<Int>, k: Int, start: Int, sum: Int) {
    when {
        sum < 0 -> return
        sum == 0 && curr.size == k -> {
            result.add(ArrayList(curr))
            return
        }
        else -> {
            for (i in start..9) {
                curr.add(i)
                helper(result, curr, k, i + 1, sum - i)
                curr.removeAt(curr.size - 1)
            }
        }
    }
}

fun main() {
    println(combinationSum3(3, 7))
    println(combinationSum3(3, 9))
}