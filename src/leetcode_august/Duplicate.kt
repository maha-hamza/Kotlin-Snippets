package leetcode_august

fun findDuplicates(nums: IntArray): List<Int> {
    val list: MutableList<Int> = mutableListOf()
    nums.sort()
    nums.forEachIndexed { index, num ->
        if (index < nums.size - 1 && num == nums[index + 1]) {
            list.add(num)
        }
    }
    return list
}

fun findDuplicatess(nums: IntArray): List<Int> {

    return nums.toList()
            .groupingBy { it }
            .eachCount()
            .filter { it.value > 1 }
            .keys
            .toList()
            .sorted()
}

fun main() {
    println(findDuplicates(intArrayOf(4, 3, 2, 7, 8, 2, 3, 1))) //[2,3]
    println(findDuplicatess(intArrayOf(4, 3, 2, 7, 8, 2, 3, 1))) //[2,3]
}