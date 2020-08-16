import kotlin.test.assertEquals

class Con(a: Int, b: Int) {
    private var pair: Pair<Int, Int> = Pair(a, b)

    fun getPair() = pair

}

fun car(obj: Con): Int {
    return obj.getPair().first
}

fun cdr(obj: Con): Int {
    return obj.getPair().second
}

fun main() {
    assertEquals(car(Con(3, 4)), 3)
    assertEquals(cdr(Con(3, 4)), 4)
}