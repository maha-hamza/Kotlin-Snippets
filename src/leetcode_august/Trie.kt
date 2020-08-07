package leetcode_august

class Trie() {

    /** Initialize your data structure here. */
    private var list = listOf<String>()

    /** Inserts a word into the trie. */
    fun insert(word: String) {
        list = list.plus(word)
    }

    /** Returns if the word is in the trie. */
    fun search(word: String): Boolean {
        return list.contains(word)
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    fun startsWith(prefix: String): Boolean {
        return list.filter { it.startsWith(prefix, true) }.isNotEmpty()
    }

}

fun main() {
    val trie = Trie()

    trie.insert("apple")
    println(trie.search("apple")) // returns true

    println(trie.search("app")) // returns false

    println(trie.startsWith("app")) // returns true

    trie.insert("app")
    println(trie.search("app")) // returns true

}