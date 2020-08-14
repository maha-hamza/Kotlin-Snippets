package leetcode_august

fun longestPalindrome(s: String): Int {
    val chars = IntArray(128)
    var result = 0
    s.toCharArray().forEach {
        chars[it.toInt()]++
    }
    chars.forEach {
        result += it / 2 * 2
        if (result % 2 == 0 && it % 2 == 1) result++
    }

    return result
}

fun main() {
    println(longestPalindrome("abccccdd")) // 7
    println(longestPalindrome("bananas")) // 5
    println(longestPalindrome("ccc")) // 3
    println(longestPalindrome("ababababa")) // 9 bbaaaabb
    println(longestPalindrome("abb")) // 3 bab
    println(longestPalindrome("abcba")) // 5 bacab
    println(longestPalindrome("aaabaaaa")) // 7
}