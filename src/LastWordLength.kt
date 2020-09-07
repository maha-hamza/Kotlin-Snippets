package src

fun lengthOfLastWord(s: String): Int {
    return if (s.isBlank()) 0 else s.split(" ").last { it.isNotEmpty() }.length
}

fun main() {
    println(lengthOfLastWord("Hello World"))
    println(lengthOfLastWord(""))
    println(lengthOfLastWord("a "))
    println(lengthOfLastWord(" "))
}