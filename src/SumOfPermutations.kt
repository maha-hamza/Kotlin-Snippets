import java.util.*
import kotlin.test.assertEquals


fun main() {
    val n = 6
    val arr = listOf(1, 2, 3, 4, 5, 6, 7, 10, 11, 12)
    val result: MutableList<List<Int>> = ArrayList()
    recursive(arr = arr.filter { it <= n }, index = 0, result = result, sum = n)

    assertEquals(result, listOf(listOf(1, 2, 3), listOf(1, 5), listOf(2, 4), listOf(6)))
}

fun recursive(
        arr: List<Int>,
        index: Int,
        current: MutableList<Int> = mutableListOf(),
        result: MutableList<List<Int>>,
        sum: Int
) {
    when (sum) {
        0 -> {
            val copy = mutableListOf<Int>()
            copy.addAll(current)
            result.add(copy)
            return
        }
        else -> {
            var j = index
            while (j < arr.size) {
                if (sum - arr[index] < 0) {
                    j++
                    continue
                }
                if (j > index && arr[j] == arr[j - 1]) {
                    j++
                    continue
                }
                current.add(arr[j])
                recursive(arr, j + 1, current, result, sum - arr[j])
                current.removeAt(current.size - 1)
                j++
            }
        }
    }
}