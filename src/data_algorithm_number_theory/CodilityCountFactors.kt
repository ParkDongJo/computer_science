package data_algorithm_number_theory

import kotlin.math.sqrt

/**
A positive integer D is a factor of a positive integer N if there exists an integer M such that N = D * M.

For example, 6 is a factor of 24, because M = 4 satisfies the above condition (24 = 6 * 4).

Write a function:

class Solution { public int solution(int N); }

that, given a positive integer N, returns the number of its factors.

For example, given N = 24, the function should return 8, because 24 has 8 factors,
namely 1, 2, 3, 4, 6, 8, 12, 24. There are no other factors of 24.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..2,147,483,647].
 */

fun main(args: Array<String>) {
//    println(solution(2_147_483_647))
    println(factorsSolutionBtype(24))
}

// 점수 : 71
// Task : 71
// Correctness : 100
// Performance : 33
fun factorsSolution(N: Int): Int {
    // write your code in Kotlin
    var count = 0

    for (i in 1..N) {
        if (N%i == 0) {
            count++
        }
    }

    return count
}

// 점수 : 33
// Task : 33
// Correctness : 50
// Performance : 16
fun factorsSolutionBtype(N: Int): Int {
    var cache = hashSetOf<Int>()
    var count = 0

    for (i in 1..N) {
        if (N%i == 0) {
            if (cache.contains(i)) {
                break
            }
            cache.add(i)
            cache.add(N/i)
            count += 2
        }
    }

    return count
}

// 점수 : 85
// Task : 85
// Correctness : 100
// Performance : 66
fun factorsSolutionCtype(N: Int): Int {
    var cache = hashSetOf<Int>()
    var count = 0

    if (N==1) return 1

    for (i in 1..N) {
        if (N%i == 0) {
            if (cache.contains(i)) {
                break
            }
            cache.add(i)
            count++

            if (i != N/i) {
                cache.add(N/i)
                count++
            }
        }
    }

    return count
}

fun factorsSolutionAnother(N: Int): Int {
    var sqrtN = sqrt(N.toDouble()).toInt()
    var count = 0

    for (i in 1..sqrtN) {
        if (N%i == 0) {
            count++
        }
    }

    count *= 2

    if (sqrtN * sqrtN == N) {
        count -= 1
    }
    return count
}