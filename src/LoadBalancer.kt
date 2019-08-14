fun main() {

    val data1 = intArrayOf(3, 1, 1, 4, 1, 1, 1, 1, 1) //3 1    4    1 1 1 1
    println(loadBalancer(data1))

    val data2 = intArrayOf(1, 3, 4, 2, 2, 2, 1, 1, 2) //4 2
    println(loadBalancer(data2))

    val data3 = intArrayOf(1, 1, 1, 1, 1, 1)
    println(loadBalancer(data3))

    val data4 = intArrayOf(2, 2, 1, 1, 5, 1, 5)
    println(loadBalancer(data4))
}


fun loadBalancer(n: IntArray): Boolean {
    var part1Sum = 0
    var part2Sum = 0
    var part3Sum = 0

    for (i in 1 until n.size) {
        part1Sum = n.slice(IntRange(0, i - 1)).sum()

        for (j in n.size - 2 downTo i + 1) {
            part2Sum = n.slice(IntRange(j + 1, n.size - 1)).sum()
            part3Sum = n.slice(IntRange(i + 1, j - 1)).sum()

            if (part1Sum != 0 && (part1Sum == part2Sum && part2Sum == part3Sum)) {
                return true
            }
        }
    }
    return false
}