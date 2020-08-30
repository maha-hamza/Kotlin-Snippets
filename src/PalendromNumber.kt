fun isPalidrome(num: Int): Boolean {
    val numS = num.toString()
    var newNum = ""
    for (i in numS.indices) {
        newNum += numS[numS.length - i - 1]
    }
    return newNum == numS
}

fun main() {
    println(isPalidrome(121))
    println(isPalidrome(-121))
    println(isPalidrome(10))
}
