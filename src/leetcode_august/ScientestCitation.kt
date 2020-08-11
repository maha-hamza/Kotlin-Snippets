package leetcode_august

fun hIndex(citations: IntArray): Int {
    return when (citations.size) {
        0 -> 0
        1 -> if (citations[0] > 0) 1 else 0
        else -> {
            var result = 0
            citations
                    .sortedDescending()
                    .forEachIndexed { index, i ->
                        if (i >= index + 1) {
                            result = index + 1
                        }
                    }
            result
        }
    }
}

fun main() {
    println(hIndex(intArrayOf(3, 0, 6, 1, 5))) //3
    println(hIndex(intArrayOf(1))) //1
    println(hIndex(intArrayOf(1, 1))) //1
    println(hIndex(intArrayOf(0))) // 0
    println(hIndex(intArrayOf(1, 2))) //1
    println(hIndex(intArrayOf(100))) //1
}