fun lengthOfLongestSubstring(s: String): Int {
    var count = 0
    val chars = mutableListOf<Char>()
    var max = 0
    for (i in s.indices) {
        chars.add(s[i])
        count++
        for (j in i + 1 until s.length) {
            if (!chars.contains(s[j])) {
                chars.add(s[j])
                count++
            } else {
                break
            }
        }

        max = count.coerceAtLeast(max)
        count = 0
        chars.removeAll(chars)
    }
    return max
}

fun main() {
    println(lengthOfLongestSubstring("abcabcbb"))//3 abc
    println(lengthOfLongestSubstring("bbbbb"))//1 b
    println(lengthOfLongestSubstring("pwwkew"))//3 wke
}