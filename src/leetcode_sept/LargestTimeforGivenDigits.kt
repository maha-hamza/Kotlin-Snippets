/**
 * Given an array of 4 digits, return the largest 24 hour time that can be made.
 * The smallest 24 hour time is 00:00, and the largest is 23:59.  Starting from 00:00, a time is larger if more time has elapsed since midnight.
 * Return the answer as a string of length 5.  If no valid time can be made, return an empty string.
 */

fun main() {
    println(largestTimeFromDigits(intArrayOf(1, 2, 3, 4))) // 23:41
}

//0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23
fun largestTimeFromDigits(A: IntArray): String {
    var time = -1
    var i = 0
    do {
        for (j in 0..3)
            if (j != i)
                for (k in 0..3)
                    if (k != i && k != j) {
                        val l = 6 - i - j - k
                        val hours = 10 * A[i] + A[j]
                        val mins = 10 * A[k] + A[l]
                        if (hours < 24 && mins < 60)
                            time = time.coerceAtLeast(hours * 60 + mins)
                    }
        i++
    } while (i < 4)
    return when (time >= 0) {
        true -> String.format("%02d:%02d", time / 60, time % 60)
        false -> ""
    }
}