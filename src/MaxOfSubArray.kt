import kotlin.test.assertEquals
import kotlin.test.assertTrue

/**
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
 * Follow up:
 * Given an array of integers and a number k, where 1 <= k <= length of the array, compute the maximum values of each subarray of length k.
 * For example, given array = [10, 5, 2, 7, 8, 7] and k = 3, we should get: [10, 7, 8, 8], since:
 * 10 = max(10, 5, 2)
 * 7 = max(5, 2, 7)
 * 8 = max(2, 7, 8)
 * 8 = max(7, 8, 7)
 */

fun main() {
    assertEquals(maxOfSub(intArrayOf(10, 5, 2, 7, 8, 7), 3).toList(), listOf(10, 7, 8, 8))
}

fun maxOfSub(array: IntArray, k: Int): IntArray {

    return array.mapIndexed { index, _ ->
        when {
            index < array.size - k -> {
                array.toList().subList(index, index + k).max()!!
            }
            index == array.size - k -> {
                array.toList().subList(index, array.size).max()!!
            }
            else -> {
                0
            }
        }
    }.filter { it != 0 }.toIntArray()
}