/**
 * This problem was recently asked by Google.
 * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 * Bonus: Can you do this in one pass?
 */
fun main() {
    println(findSum(intArrayOf(10, 15, 3, 7), 17).toList())
    println(findSum(intArrayOf(3, 2, 4), 6).toList())

    println(hasSum(intArrayOf(10, 15, 3, 7), 25))
    println(hasSum(intArrayOf(3, 2, 4), 6))

    println(twoSum(intArrayOf(3, 2, 4), 6).toList())
}

// return the nums
fun findSum(list: IntArray, k: Int): IntArray {
    return list.mapIndexed { outerIndex, i ->
        list.mapIndexed { innerIndex, j ->
            if (innerIndex > outerIndex && (i + j == k)) {
                return intArrayOf(i, j)
            } else {
                intArrayOf()
            }
        }
    }.flatten().first()
}

// return boolean
fun hasSum(list: IntArray, k: Int): Boolean {
    return list.mapIndexed { outerIndex, i ->
        list.mapIndexed { innerIndex, j ->
            if (innerIndex > outerIndex && (i + j == k)) {
                return true
            } else {
                false
            }
        }
    }.flatten().first()
}

fun hasSum2(list: IntArray, k: Int): Boolean {
    for (outer in list.indices) {
        for (inner in outer + 1 until list.size) {
            if (list[outer] + list[inner] == k) {
                return true
            }
        }
    }
    return false
}

// return indicies
fun twoSum(list: IntArray, k: Int): IntArray {
    for (outer in list.indices) {
        for (inner in outer + 1 until list.size) {
            if (list[outer] + list[inner] == k) {
                return intArrayOf(outer, inner)
            }
        }
    }
    return intArrayOf()
}