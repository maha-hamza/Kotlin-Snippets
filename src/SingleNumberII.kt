package src

/**
 * Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * Example 1:
 * Input: [2,2,3,2]
 * Output: 3
 *
 * Example 2:
 * Input: [0,1,0,1,0,1,99]
 * Output: 99
 */

fun singleNumber(nums: IntArray): Int {
    var count = 0
    var num = -1
    nums.sorted().forEach {
        if (it != num && count == 1)
            return num
        num = it
        count++
        if (count == 3)
            count = 0
    }
    return num
}

fun singleNumber2(nums: IntArray): Int {
    return nums.map {
        it to nums.count { c -> c == it }
    }.first { it.second == 1 }.first
}

fun main() {
    println(singleNumber(intArrayOf(2, 2, 3, 2)))
    println(singleNumber(intArrayOf(0, 1, 0, 1, 0, 1, 99)))
    println(singleNumber(intArrayOf(-2, -2, 1, 1, -3, 1, -3, -3, -4, -2)))
    println(singleNumber(intArrayOf(-19, -46, -19, -46, -9, -9, -19, 17, 17, 17, -13, -13, -9, -13, -46, -28)))

}