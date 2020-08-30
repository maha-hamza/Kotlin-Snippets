fun multiply(num1: String, num2: String): String {
    if (num1.isBlank() || num2.isBlank())
        return ""
    return (num1.toBigInteger() * num2.toBigInteger()).toString()
}

fun main() {
    println(multiply("2", "3"))
    println(multiply("123", "456"))
    println(multiply("", "456"))
    println(multiply("123456789", "987654321"))
    println(multiply("498828660196", "840477629533"))
}