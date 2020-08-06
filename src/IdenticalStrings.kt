class IdenticalStrings {
    fun solution(t: String, s: String): Boolean {
        val firstString = t.map { it }.distinct()
        val secondString = s.map { it }.distinct()
        return firstString == secondString
    }
}

fun main() {
    val identicalStrings = IdenticalStrings()
    println(identicalStrings.solution("Geeks", "Geks"))
    println(identicalStrings.solution("Arnab", "Andrew"))
}