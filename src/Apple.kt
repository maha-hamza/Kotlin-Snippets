// Time Complexity O(n) + O(n-K) + O(n)+ O(n-L) ~ O(3n-K-L)
//Space Complexity O(5) tends to O(2)
fun main() {
    var A = listOf(6, 1, 4, 6, 3, 2, 7, 4)
    var K = 3
    var L = 2
    var appleSum = -1



    for (i in 0 until A.size - K) {
        val subArrayBobSum = A.slice(IntRange(i, i + K - 1)).sum()
        for (j in i + K until A.size) {
            if (j + L - 1 < A.size) {
                val subArrayAliceSum = A.slice(IntRange(j, j + L - 1)).sum()

                if (subArrayBobSum + subArrayAliceSum > appleSum) {
                    appleSum = subArrayBobSum + subArrayAliceSum
                }
            }
        }
    }


    for (i in 0 until A.size - L) {
        val subArrayAliceSum = A.slice(IntRange(i, i + L - 1)).sum()
        for (j in i + L until A.size) {
            if (j + K - 1 < A.size) {
                val subArrayBobSum = A.slice(IntRange(j, j + K - 1)).sum()

                if (subArrayBobSum + subArrayAliceSum > appleSum) {
                    appleSum = subArrayBobSum + subArrayAliceSum
                }
            }
        }
    }

    println(appleSum)
}