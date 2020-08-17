package leetcode_august

import kotlin.test.assertEquals

/**
 * We distribute some number of candies, to a row of n = num_people people in the following way:
 * We then give 1 candy to the first person, 2 candies to the second person, and so on until we give n candies to the last person.
 * Then, we go back to the start of the row, giving n + 1 candies to the first person, n + 2 candies to the second person, and so on until we give 2 * n candies to the last person.
 * This process repeats (with us giving one more candy each time, and moving to the start of the row after we reach the end) until we run out of candies.  The last person will receive all of our remaining candies (not necessarily one more than the previous gift).
 * Return an array (of length num_people and sum candies) that represents the final distribution of candies.
 */
fun distributeCandies(candies: Int, num_people: Int): IntArray {
    return when (candies == 0) {
        true -> intArrayOf(0)
        false -> {
            var candiesRemainingCount = candies
            val array = IntArray(num_people)
            var n = 0
            do {
                array[n % num_people] += candiesRemainingCount.coerceAtMost(++n)
                candiesRemainingCount -= n
            } while (candiesRemainingCount > 0)
            array
        }
    }
}

fun main() {
    assertEquals(distributeCandies(7, 4).toList(), listOf(1, 2, 3, 1))
    assertEquals(distributeCandies(10, 3).toList(), listOf(5, 2, 3))
    assertEquals(distributeCandies(60, 4).toList(), listOf(15, 18, 15, 12))
}