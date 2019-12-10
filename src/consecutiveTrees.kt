fun main() {

    println(findMaxApples(6, 1, 4, 6, 3, 2, 7, 4, k = 3, l = 2))
    println(findMaxApples(10, 15, 19, k = 2, l = 2))
}

fun findMaxApples(vararg a: Int, k: Int, l: Int): Int {
    return when (k + l > a.size) {
        true -> -1
        false -> {
            var temp = 0
            var start = 0
            var end = 0
            for (i in 0 .. a.size) {
                if (i < a.size - k) {
                    val res = a.sliceArray(IntRange(i, i + k - 1)).sum()
                    if (res > temp) {
                        temp = res
                        start = i
                        end = i + k
                    }
                }
            }
            val availablePart1 = a.asList().slice(IntRange(0, start - 1))
            val availablePart2 = a.asList().slice(IntRange(end, a.size - 1))

            var temp2 = 0
            for (i in 0 .. availablePart1.size) {
                if ((i + l - 1) < availablePart1.size) {
                    val res = availablePart1.slice(IntRange(i, i + l - 1)).sum()
                    if (res > temp2) {
                        temp2 = res
                    }
                }
            }
            var temp3 = 0
            for (i in 0 .. availablePart2.size) {
                if ((i + l - 1) < availablePart2.size) {
                    val res = availablePart2.slice(IntRange(i, i + l - 1)).sum()
                    if (res > temp3) {
                        temp3 = res
                    }
                }
            }

            temp + temp2.coerceAtLeast(temp3)
        }
    }

}