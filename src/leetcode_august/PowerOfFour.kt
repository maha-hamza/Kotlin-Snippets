package leetcode_august

class PowerOfFour {
    fun isPowerOfFour(num: Int): Boolean {
        return num !== 0 && num and num - 1 === 0 && num and -0x55555556 === 0
    }
}

fun main() {
    println(PowerOfFour().isPowerOfFour(16))
    println(PowerOfFour().isPowerOfFour(64))
    println(PowerOfFour().isPowerOfFour(32))
    println(PowerOfFour().isPowerOfFour(25))
    println(PowerOfFour().isPowerOfFour(5))
    println(PowerOfFour().isPowerOfFour(-2147483648))
}