fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    val combined = (nums1 + nums2).sorted()
    val size = combined.size
    return when (size % 2 == 0) {
        true -> ((combined[size / 2 - 1].toDouble() + combined[size / 2].toDouble()) / 2)//even
        false -> combined[size / 2].toDouble()// odd
    }
}

fun main() {
    println(findMedianSortedArrays(intArrayOf(1, 3), intArrayOf(2))) //2
    println(findMedianSortedArrays(intArrayOf(1, 2), intArrayOf(3, 4))) //2.5
    println(findMedianSortedArrays(intArrayOf(), intArrayOf(2))) //2
    println(findMedianSortedArrays(intArrayOf(0, 0), intArrayOf(0, 0))) //0
}