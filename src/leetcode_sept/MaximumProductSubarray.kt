package src.leetcode_sept

/**
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */

fun maxProduct(nums: IntArray): Int {
    if (nums.isEmpty()) return 0
    var max = nums[0]
    var temp = 0
    for (i in nums.indices) {
        temp = nums[i]
        if (temp >= max) {
            max = temp
        }
        for (j in i + 1 until nums.size) {
            temp *= nums[j]
            if (temp >= max) {
                max = temp
            }
        }
    }
    return max
}

fun main() {
    println(maxProduct(intArrayOf(2, 3, -2, 4))) // 6
    println(maxProduct(intArrayOf(-2, 0, -1))) // 0
    println(maxProduct(intArrayOf(-2))) // -2
    println(maxProduct(intArrayOf(-4, -3))) // 12
    println(maxProduct(intArrayOf(0, 2))) // 2
    println(maxProduct(intArrayOf(-2, 3, -4))) // 24
    println(maxProduct(intArrayOf(2, -5, -2, -4, 3))) // 24
}