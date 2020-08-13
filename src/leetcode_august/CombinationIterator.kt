package leetcode_august

/**
 * Design an Iterator class, which has:
 * A constructor that takes a string characters of sorted distinct lowercase English letters and a number combinationLength as arguments.
 * A function next() that returns the next combination of length combinationLength in lexicographical order.
 * A function hasNext() that returns True if and only if there exists a next combination.
 */
class CombinationIterator(val characters: String, val combinationLength: Int) {
    private val combinations: MutableList<String> = mutableListOf()
    private var count = 0

    init {
        generateCombinations(java.lang.StringBuilder(), 0)
    }

    fun next(): String {
        val result = when {
            count == 0 -> combinations[0]
            count < combinations.size -> combinations[count]
            else -> ""
        }
        count++
        return result

    }

    fun hasNext(): Boolean {

        return count < combinations.size
    }

    private fun generateCombinations(sb: StringBuilder, index: Int) {
        when (sb.length) {
            combinationLength -> {
                combinations.add(sb.toString())
                return
            }
            else -> {
                for (i in index until characters.length) {
                    sb.append(characters[i])
                    generateCombinations(sb, i + 1)
                    sb.deleteCharAt(sb.length - 1)
                }
            }
        }
    }
}

fun main() {
    val characters = "abc"
    val combinationLength = 2
    var obj = CombinationIterator(characters, combinationLength)
    var param_1 = obj.next()
    println(param_1)
    println(obj.next())
    println(obj.hasNext())
    println(obj.next())
    println(obj.next())
    var param_2 = obj.hasNext()
    println(param_2)
}
/**
 * Your CombinationIterator object will be instantiated and called as such:
 * var obj = CombinationIterator(characters, combinationLength)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */