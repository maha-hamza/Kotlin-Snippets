package leetcode_august

fun main() {

    println(detectCaps("USA"))
    println(detectCaps("leetcode"))
    println(detectCaps("Leetcode"))
    println(detectCaps("Google"))
    println(detectCaps("FlaG"))
}

fun detectCaps(word: String): Boolean {
    val s = word.toList()
    return when {
        (s.filter { it.isUpperCase() }.size == word.length) -> true
        (s.filter { it.isLowerCase() }.size == word.length) -> true
        (s.first().isUpperCase() && s.subList(1, word.length).filter { it.isLowerCase() }.size == word.length - 1) -> true
        else -> false
    }
}