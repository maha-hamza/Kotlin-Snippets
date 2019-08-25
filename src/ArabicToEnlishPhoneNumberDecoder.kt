/**
 * for Arabic coders, this code snippet convert Arabic written digits to English
 * written it will convert digits only , characters and symbols will be ignored
 * PS Reimplementation in kotlin
 * @author Maha M. Hamza
 *
 */

fun main() {

    val n1 = "٠١٢٠٢١٣٥١٤"
    println(convert(n1))

    val n2 = "+٤٩١٧٤٦١٢٣٢٢٢"
    println(convert(n2))

    val n3 = "+٤٩ ١٧٤ ٦١٢٣٢٢٢"
    println(convert(n3))
}

fun convert(num: String): String {
    val number = StringBuilder()
    num.forEach {
        val c = comparingCharacter(it)
        number.append(c)
    }
    return number.toString()
}

private fun comparingCharacter(e: Char): Char {
    return when {
        (e >= 0x0660.toChar() && e <= 0x0669.toChar()) -> e.minus(0x0660.toChar() - '0')
        (e >= 0x06f0.toChar() && e <= 0x06F9.toChar()) -> e.minus(0x06f0.toChar() - '0')
        else -> e
    }
}
