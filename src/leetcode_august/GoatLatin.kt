package leetcode_august

/**
 * A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.

We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)

The rules of Goat Latin are as follows:

If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
For example, the word 'apple' becomes 'applema'.

If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
For example, the word "goat" becomes "oatgma".

Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
Return the final sentence representing the conversion from S to Goat Latin.
 */
//S contains only uppercase, lowercase and spaces. Exactly one space between each word.
//1 <= S.length <= 150
fun toGoatLatin(S: String): String {
    return when (S.length !in IntRange(1, 150)) {
        true -> ""
        else -> {
            val vowels = listOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
            val postfix = "ma"

            S.splitToSequence(" ")
                    .mapIndexed { index, word ->
                        val generatedAByIndex = (1 .. index + 1).joinToString("") { "a" }

                        val newWord = when (word[0] in vowels) {
                            true -> word.plus(postfix)
                            false -> word.substring(1, word.length) + word[0] + postfix
                        }
                        newWord.plus(generatedAByIndex)
                    }.joinToString(" ") { it }
        }
    }
}

fun main() {
    println(toGoatLatin("I speak Goat Latin")) // Imaa peaksmaaa oatGmaaaa atinLmaaaaa
    println(toGoatLatin("The quick brown fox jumped over the lazy dog")) // heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa
}