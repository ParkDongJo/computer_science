package data_algorithm_sort

/**
A non-empty array A consisting of N integers is given. The product of triplet (P, Q, R) equates to A[P] * A[Q] * A[R] (0 ≤ P < Q < R < N).

For example, array A such that:

A[0] = -3
A[1] = 1
A[2] = 2
A[3] = -2
A[4] = 5
A[5] = 6
contains the following example triplets:

(0, 1, 2), product is −3 * 1 * 2 = −6
(1, 2, 4), product is 1 * 2 * 5 = 10
(2, 4, 5), product is 2 * 5 * 6 = 60
Your goal is to find the maximal product of any triplet.

Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A, returns the value of the maximal product of any triplet.

For example, given array A such that:

A[0] = -3
A[1] = 1
A[2] = 2
A[3] = -2
A[4] = 5
A[5] = 6
the function should return 60, as the product of triplet (2, 4, 5) is maximal.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [3..100,000];
each element of array A is an integer within the range [−1,000..1,000].
 */


fun main(args: Array<String>) {
    solution1(intArrayOf(-3,1,2,-2,5,6))
}

//17
//점수 : 44
//Task : 44
//Correctness : 50
//Performance : 40
fun solution1(A: IntArray): Int {
    // write your code in Kotlin
    var tmpArr = A
    var max = tmpArr[0]
    var maxIdx = 0
    var maxTriple = IntArray(3)


    for ((i,n) in tmpArr.withIndex()) {
        maxIdx = if(max > n) maxIdx else i
        max = if(max > n) max else n
    }
    maxTriple[0] = max
    tmpArr[maxIdx] = -1000
    max = tmpArr[0]
    maxIdx = 0

    for ((i,n) in tmpArr.withIndex()) {
        max = if(max > n) max else n
        maxIdx = if(max > n) maxIdx else i
    }
    maxTriple[1] = max
    tmpArr[maxIdx] = -1000
    max = tmpArr[0]
    maxIdx = 0

    for ((i,n) in tmpArr.withIndex()) {
        max = if(max > n) max else n
        maxIdx = if(max > n) maxIdx else i
    }
    maxTriple[2] = max
    tmpArr[maxIdx] = -1000


    return maxTriple[0] * maxTriple[1] * maxTriple[2]
}

fun solution1Btype(A: IntArray): Int {

    return 0
}
