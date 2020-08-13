/**
 * Given an array of integers,
 * return a new array such that
 * each element at index i of the new array is the product of all the numbers in the original array except
 * the one at i.
For example,
if our input was [1, 2, 3, 4, 5],
the expected output would be [120, 60, 40, 30, 24].
If our input was [3, 2, 1],
the expected output would be [2, 3, 6]
 */

fun main() {
    val s1 = listOf(1, 2, 3, 4, 5)
    println(getArrayOfProducts(s1))
    println(getArrayOfProducts(listOf(1)).toList())
    val s2 = listOf(3, 2, 1)
    println(getArrayOfProducts(s2))
}

fun getArrayOfProducts(array: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    array.forEach { i ->
        val product = when (array.size) {
            1 -> array[0] * array[0]
            else -> array.filter { it != i }.reduce { acc, i -> acc * i }
        }
        result.add(product)
    }
    return result
}