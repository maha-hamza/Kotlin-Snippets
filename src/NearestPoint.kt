import kotlin.math.pow
import kotlin.math.sqrt

/**
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 *(Here, the distance between two points on a plane is the Euclidean distance.)
 *You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
 */

class Solution {
    fun kClosest(points: Array<IntArray>, K: Int): Array<IntArray> {
        return points.map {
            it to sqrt(it.first().toDouble().pow(2).plus(it.last().toDouble().pow(2)))
        }.sortedBy { it.second }
                .map { it.first }
                .subList(0, K)
                .toTypedArray()
    }
}


fun main() {
   Solution().kClosest(arrayOf(intArrayOf(3, 2), intArrayOf(2, -2)), 1).forEach { println("${it.first()},${it.last()}") }
}