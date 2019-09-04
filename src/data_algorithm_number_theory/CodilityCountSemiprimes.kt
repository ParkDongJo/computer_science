package data_algorithm_number_theory

import java.util.*

// CountSemiprimes
/*
A prime is a positive integer X that has exactly two distinct divisors: 1 and X. The first few prime integers are 2, 3, 5, 7, 11 and 13.

A semiprime is a natural number that is the product of two (not necessarily distinct) prime numbers. The first few semiprimes are 4, 6, 9, 10, 14, 15, 21, 22, 25, 26.

You are given two non-empty arrays P and Q, each consisting of M integers. These arrays represent queries about the number of semiprimes within specified ranges.

Query K requires you to find the number of semiprimes within the range (P[K], Q[K]), where 1 ≤ P[K] ≤ Q[K] ≤ N.

For example, consider an integer N = 26 and arrays P, Q such that:

    P[0] = 1    Q[0] = 26
    P[1] = 4    Q[1] = 10
    P[2] = 16   Q[2] = 20
The number of semiprimes within each of these ranges is as follows:

(1, 26) is 10,
(4, 10) is 4,
(16, 20) is 0.
Write a function:

class Solution { public int[] solution(int N, int[] P, int[] Q); }

that, given an integer N and two non-empty arrays P and Q consisting of M integers,
returns an array consisting of M elements specifying the consecutive answers to all the queries.

For example, given an integer N = 26 and arrays P, Q such that:

    P[0] = 1    Q[0] = 26
    P[1] = 4    Q[1] = 10
    P[2] = 16   Q[2] = 20
the function should return the values [10, 4, 0], as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..50,000];
M is an integer within the range [1..30,000];
each element of arrays P, Q is an integer within the range [1..N];
P[i] ≤ Q[i].
 */

fun main(args: Array<String>) {
    println(Arrays.toString(solution(26, intArrayOf(1,4,16), intArrayOf(26,10,20))))
}


// 점수 : 66
// Task : 66
// Correctness : 100
// Performance : 40
fun solution(N: Int, P: IntArray, Q: IntArray): IntArray {
    var answers = IntArray(P.size)

    var primeArr = getPrimeArrByEratos(N)
    var semiPrimeArr = ArrayList<Int>()

    for (i in 0..(primeArr.size-1)) {
        for (j in i..(primeArr.size-1)) {
            var semiPrime = primeArr[i]*primeArr[j]

            if (semiPrime > N) {
                break
            }

            if (!primeArr.contains(semiPrime)) {
                semiPrimeArr.add(semiPrime)
            }
        }
    }


    for (i in 0..(P.size-1)) {
        for (num in P[i]..Q[i]) {
            if (semiPrimeArr.contains(num)) {
                answers[i] += 1
            }
        }
    }

    return answers
}

fun getPrimeArrByEratos(n: Int): IntArray {
    var isPrime = BooleanArray(n+1, {it->true})
    var primeArr = ArrayList<Int>()
    var idx: Int

    for (i in 2..n) {

        for (j in i..n step i) {
            if (j!=i) {
                isPrime[j] = false
            }
        }
    }

    for (i in 2..n) {
        if (isPrime[i]) {
            primeArr.add(i)
        }
    }

    return primeArr.toIntArray()
}