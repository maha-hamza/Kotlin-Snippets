fun isPalidrome(word: String?): Boolean {
    val result = when (word.isNullOrBlank()) {
        true -> throw IllegalArgumentException("Input can't be Empty or null")
        false -> {
            // word.reversed()
            //or
            IntRange(0, word.length - 1)
                    .map { word[word.length - it - 1] }
                    .joinToString("") { it.toString() }
        }
    }
    return result == word
}