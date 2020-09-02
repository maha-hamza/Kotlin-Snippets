package src.leetcode_sept

import kotlin.math.abs
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * Given an array of integers,
 * find out whether there are two distinct indices i and j in the array
 * such that the absolute difference between nums[i] and nums[j] is at most t
 * and the absolute difference between i and j is at most k.
 */
fun containsNearbyAlmostDuplicate(nums: IntArray, k: Int, t: Int): Boolean {
    nums.forEachIndexed { i, num1 ->
        nums.forEachIndexed { j, num2 ->
            // special case for overflow
            if (abs(num1 - num2) == Int.MIN_VALUE || num1 == Int.MAX_VALUE)
                return false
            if (i != j && abs(num1 - num2) <= t && abs(i - j) <= k) {
                return true
            }
        }
    }

    return false
}

fun main() {
    assertTrue(containsNearbyAlmostDuplicate(intArrayOf(1, 2, 3, 1), 3, 0)) //true
    assertTrue(containsNearbyAlmostDuplicate(intArrayOf(1, 0, 1, 1), 1, 2)) //true
    assertFalse(containsNearbyAlmostDuplicate(intArrayOf(1, 5, 9, 1, 5, 9), 2, 3)) //false
    assertFalse(containsNearbyAlmostDuplicate(intArrayOf(0), 0, 0)) //false

    assertFalse(containsNearbyAlmostDuplicate(intArrayOf(-3, 3), 2, 4)) //false
    assertTrue(containsNearbyAlmostDuplicate(intArrayOf(2, 2), 3, 0)) //true
    assertFalse(containsNearbyAlmostDuplicate(intArrayOf(-1, 2147483647), 1, 2147483647)) //false
    assertFalse(containsNearbyAlmostDuplicate(intArrayOf(2147483647, -2147483647), 1, 2147483647)) //false
    assertTrue(containsNearbyAlmostDuplicate(intArrayOf(0, 2147483647), 1, 2147483647)) //true
}