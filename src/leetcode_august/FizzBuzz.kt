package leetcode_august

/**
 * Write a program that outputs the string representation of numbers from 1 to n.
 * But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples
 * of both three and five output “FizzBuzz”.
 * Example:
 * n = 15,
 * Return:
 * [
 * "1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
 */

fun fizzBuzz(n: Int): List<String> {
    return IntRange(1, n).map {
        if (it % 3 == 0 && it % 5 == 0) "FizzBuzz"
        else if (it % 3 == 0) "Fizz"
        else if (it % 5 == 0) "Buzz"
        else it.toString()
    }.toList()
}

fun main() {
    println(fizzBuzz(15))
}