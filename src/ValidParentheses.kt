import java.util.*

fun main() {

    println(isValid("()")) //true
    println(isValid("()[]{}")) //true
    println(isValid("(]")) // false
    println(isValid("([)]")) // false
    println(isValid("{ { } [ ] [ [ [ ] ] ] }")) // true
    println(isValid("")) // true
}

//(', ')', '{', '}', '[' and ']'
fun isValid(s: String): Boolean {
    val pairs = mapOf(
            ')' to '(',
            '}' to '{',
            ']' to '['
    )
    if (s.length == 1) {
        return false
    } else if (s.isEmpty()) {
        return true
    }

    val stack = Stack<Char>()

    s.replace(" ", "").forEachIndexed { index, it ->
        stack.push(it)
        if (stack.size >= 2 && stack.contains(pairs[it])) {
            stack.pop()
            stack.pop()
        }
    }
    return stack.isEmpty()
}