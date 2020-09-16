package src.leetcode_sept

/**
 *Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.
 * Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.
 * Could you do this in O(n) runtime?
 * Example:
 * Input: [3, 10, 5, 25, 2, 8]
 * Output: 28
 * Explanation: The maximum result is 5 ^ 25 = 28.
 */

fun findMaximumXOR(nums: IntArray): Int {
    var i = 0
    var j = i + 1
    var max = 0
    var temp = 0
    while (i < nums.size) {
        if (j == nums.size) {
            i++
            j = 0
        }
        if (i == nums.size)
            break
        if (j < nums.size) {
            temp = nums[i].xor(nums[j])
        }
        max = temp.coerceAtLeast(max)
        j++
    }
    return max
}

fun main() {
    println(findMaximumXOR(intArrayOf(3, 10, 5, 25, 2, 8)))
}