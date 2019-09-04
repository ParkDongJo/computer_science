package data_algorithm_test.test1

import kotlin.math.sqrt

fun main(args: Array<String>) {
    println(solution(30))
}

fun solution(N: Int): Int {
    // write your code in Kotlin
    var sqrtN = sqrt(N.toDouble()).toInt()
    var a = N
    var b = 1

    for (i in sqrtN downTo 1) {
        if (N%i == 0) {
            a = i
            b = N/i
            break
        }
    }

    return a*2 + b*2
}