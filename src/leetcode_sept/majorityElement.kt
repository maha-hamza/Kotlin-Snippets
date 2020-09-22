package src.leetcode_sept

fun majorityElement(nums: IntArray): List<Int> {
    return nums
            .groupBy { it }
            .filter { it.value.count() > nums.size / 3 }
            .map { it.key }
}

fun main() {
    println(majorityElement(intArrayOf(1, 1, 1, 3, 3, 2, 2, 2)))
}