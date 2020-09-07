package src.leetcode_sept

import kotlin.system.measureTimeMillis
import kotlin.test.assertEquals

fun wordPattern(pattern: String, str: String): Boolean {

    val words = str.split(" ")
    val map = mutableMapOf<Char, String>()
    val isInThePattern = mutableListOf<Boolean>()
    return when (str.isEmpty() || words.size != pattern.length) {
        true -> false
        false -> {
            words.forEachIndexed { index, s ->
                if (!map.containsKey(pattern[index]) && !map.containsValue(s)) {
                    map[pattern[index]] = s
                } else {
                    val value = map[pattern[index]]
                    isInThePattern.add(value == s)
                }
            }
            isInThePattern.none { !it }
        }
    }
}

fun main() {
    val executionTime = measureTimeMillis {
        assertEquals(wordPattern("abba", "dog cat cat dog"), true)
        assertEquals(wordPattern("aaaa", "dog cat cat dog"), false)
        assertEquals(wordPattern("abba", "dog dog dog dog"), false)
    }
    println(executionTime)
}