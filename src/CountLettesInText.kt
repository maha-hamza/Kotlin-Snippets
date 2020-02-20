fun published(word: String): Map<String, Int> {

    val result = mutableMapOf<String, Int>()
    var count = 1
    val sortedArray = word.toList().sorted()
    sortedArray.forEachIndexed { index, c ->
        when ((index + 1 < word.length) && (c == sortedArray[index + 1])) {
            true -> count++
            false -> {
                result.putIfAbsent(c.toString(), count)
                count = 1
            }
        }
    }
    return result
}

fun main() {
    println(published("apple"))
    println(published("maha"))
}