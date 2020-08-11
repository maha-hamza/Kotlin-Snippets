package leetcode_august

import kotlin.math.pow

fun titleToNumber(s: String): Int {

    val letters = 'A'.rangeTo('Z').toList()
    return when (s.length) {
        0 -> 0
        1 -> letters.indexOf(s.elementAt(0)) + 1
        else -> {
            var length = s.length
            s.toCharArray()
                    .map { c ->
                        val eq = letters.indexOf(s.find { it == c }) + 1
                        --length
                        eq * 26.toDouble().pow((length.toDouble()))
                    }.sumBy { it.toInt() }
        }
    }
}


fun main() {

    println(titleToNumber("A")) //1
    println(titleToNumber("B")) //2
    println(titleToNumber("C")) //3
    println(titleToNumber("AA")) //27
    println(titleToNumber("AB")) //28
    println(titleToNumber("ZY")) //701

}