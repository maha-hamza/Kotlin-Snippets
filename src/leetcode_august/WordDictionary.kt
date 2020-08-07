package leetcode_august

class WordDictionary {

    /** Initialize your data structure here. */
    private var dictionary = arrayOf<String>()

    /** Adds a word into the data structure. */
    fun addWord(word: String) {
        dictionary = dictionary.plus(word)
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    fun search(word: String): Boolean {
        val regex = Regex.fromLiteral("^(.*?(\\b$word\\b)[^\$]*)\$\n")
        return dictionary.any {
            when {
                !word.contains(".") -> dictionary.contains(word)
                word.startsWith(".") -> {
                    dictionary.any { it.endsWith(word.replace(".", "")) }
                }
                word.endsWith(".") -> {
                    dictionary.any { it.startsWith(word.replace(".", "")) }
                }
                else -> false
            }
        }
    }

}

fun main() {

    val dict = WordDictionary()

    dict.addWord("bad")
    dict.addWord("dad")
    dict.addWord("mad")
    dict.addWord("search")
    println(dict.search("pad")) // false
    println(dict.search("bad")) // true
    println(dict.search(".ad")) // true
    println(dict.search("b..")) // true
    println(dict.search("a.")) // true
    println(dict.search(".a")) // true

}