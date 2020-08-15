/**
 * Given an array of integers, find the first missing positive integer in linear time and constant space. In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.
 * For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
You can modify the input array in-place.
 */

fun main() {
    println(missingInt(intArrayOf())) // 1
    println(missingInt(intArrayOf(3, 4, -1, 1))) // 2
    println(missingInt(intArrayOf(1, 2, 0))) // 3
    println(missingInt(intArrayOf(7, 8, 9, 11, 12))) // 1
    println(missingInt(intArrayOf(4, 3, 4, 1, 1, 4, 1, 4))) // 2
}

fun missingInt(array: IntArray): Int {
    val positive = array.filter { it > 0 }.sorted().distinct()
    return when (positive.size) {
        0 -> 1
        1 -> {
            if (positive[0] == 1) 2 else 1
        }
        else -> {
            var result = 0
            positive.forEachIndexed { index, i ->
                when (index < positive.size - 1) {
                    true -> {
                        if (index == 0 && i > 1) {
                            result = 1
                            return result
                        } else if (positive[i] > i + 1) {
                            result = i + 1
                            return result
                        }
                    }
                    false -> {
                        result = i + 1
                        return result
                    }
                }
            }
            result
        }
    }
}