package data_algorithm_array

import java.math.BigInteger
import kotlin.math.*

/**
A non-empty array A consisting of N integers is given.
A pair of integers (P, Q), such that 0 ≤ P ≤ Q < N, is called a slice of array A.
The sum of a slice (P, Q) is the total of A[P] + A[P+1] + ... + A[Q].

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers, returns the maximum sum of any slice of A.

For example, given array A such that:

A[0] = 3  A[1] = 2  A[2] = -6  A[3] = 4  A[4] = 0
the function should return 5 because:

(3, 4) is a slice of A that has sum 4,
(2, 2) is a slice of A that has sum −6,
(0, 1) is a slice of A that has sum 5,
no other slice of A has sum greater than (0, 1).
Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..1,000,000];
each element of array A is an integer within the range [−1,000,000..1,000,000];
the result will be an integer within the range [−2,147,483,648..2,147,483,647].

 */

fun main(args: Array<String>) {
//    maxSlicesolution(intArrayOf(3,2,-6,4,0))
    println(maxSliceSolutionBtype(intArrayOf(3,2,-6,4,0)))
}

fun maxSlicesolution(A: IntArray): Int {
    // write your code in Kotlin
    var hash = hashMapOf<Int, BigInteger>()
    var sum: BigInteger = BigInteger("0")
    var max: BigInteger = BigInteger(A[0].toString())

    for ((idx,num) in A.withIndex()) {
        sum += num.toBigInteger()
        hash.set(idx, sum)
        if (max < sum) {
            max = sum
        }
    }

    return 0
}

fun maxSliceSolutionBtype(A: IntArray): Int {
    var maxNum = A[0]
    var accumulatedNum = 0

    for (num in A) {
        accumulatedNum = max(num, num+accumulatedNum)
        maxNum = max(maxNum, accumulatedNum)
    }

    return maxNum
}
