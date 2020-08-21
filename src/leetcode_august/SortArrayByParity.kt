package leetcode_august

/**
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
 * You may return any answer array that satisfies this condition.
 */
fun sortArrayByParity(A: IntArray): IntArray {
    return (A.filter { it % 2 == 0 } + A.filter { it % 2 != 0 }).toIntArray()
}

fun sortArrayByParity2ndImpl(A: IntArray): IntArray {
    val evens = mutableListOf<Int>()
    val odds = mutableListOf<Int>()
    for (i in A.indices) {
        if (A[i] % 2 == 0)
            evens.add(A[i])
        else
            odds.add(A[i])
    }
    return (evens + odds).toIntArray()
}

fun main() {
    println(sortArrayByParity(intArrayOf(3, 1, 2, 4)).toList())
    println(sortArrayByParity2ndImpl(intArrayOf(3, 1, 2, 4)).toList())
}
