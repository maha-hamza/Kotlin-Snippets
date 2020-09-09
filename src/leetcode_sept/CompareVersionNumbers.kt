package src.leetcode_sept

import kotlin.math.abs
import kotlin.math.max

/**
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1;
 * if version1 < version2 return -1;
 * otherwise return 0.
You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
You may assume the default revision number for each level of a version number to be 0. For example, version number 3.4 has a revision number of 3 and 4 for its first and second level revision number. Its third and fourth level revision number are both 0.
 */
fun compareVersion(version1: String, version2: String): Int {
    val ver1 = version1.split(".").map { it.toInt() }.toMutableList()
    val ver2 = version2.split(".").map { it.toInt() }.toMutableList()
    val neededSize = abs(ver1.size - ver2.size) - 1
    val append = IntRange(0, neededSize).map { 0 }
    when {
        ver1.size > ver2.size -> ver2 += append
        ver1.size < ver2.size -> ver1 += append
    }

    if (ver1.isNotEmpty() && ver2.isNotEmpty()) {
        return when {
            ver1[0] < ver2[0] -> -1
            ver1[0] > ver2[0] -> 1
            else -> {
                for (i in 1 until max(ver1.size, ver2.size)) {
                    if (ver1[i] > ver2[i]) {
                        return 1
                    } else if (ver1[i] < ver2[i]) {
                        return -1
                    }
                }
                0
            }
        }
    }
    return 0
}


fun main() {
    println(compareVersion("0.1", "1.1")) // -1
    println(compareVersion("1.0.1", "1")) // 1
    println(compareVersion("7.5.2.4", "7.5.3")) // -1
    println(compareVersion("1.01", "1.001")) // 0
    println(compareVersion("1.0", "1.0.0")) // 0
    println(compareVersion("1.2", "1.10")) // -1
    println(compareVersion("00010.0", "0010")) // 0
}