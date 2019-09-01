package data_algorithm_sort

import java.util.*
import kotlin.math.max

/**
A non-empty array A consisting of N integers is given. The product of triplet (P, Q, R)
equates to A[P] * A[Q] * A[R] (0 ≤ P < Q < R < N).

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
//    solution1(intArrayOf(-3,1,2,-2,5,6))
//    println(solution1Btype(intArrayOf(-3,1,2,-2,5,6)))
//    println(solution1Btype(intArrayOf(-5, 5, -5, 4)))

//    println(solution1Ctype(intArrayOf(-3,1,2,-2,5,6)))
//    println(solution1Ctype(intArrayOf(-5, 5, -5, 4)))

//    println(solution1Dtype(intArrayOf(-3,1,2,-2,5,6)))
//    println(solution1Dtype(intArrayOf(-5, 5, -5, 4)))

    println(solution1Etype(intArrayOf(-3,1,2,-2,5,6)))
    println(solution1Etype(intArrayOf(-5, 5, -5, 4)))
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

//점수 : 44
//Task : 44
//Correctness : 50
//Performance : 40
/*
For example, for the input [-5, 5, -5, 4] the solution
returned a wrong answer (got -100 expected 125).
 */
fun solution1Btype(A: IntArray): Int {
    A.sort()
    A.reverse()

    println(Arrays.toString(A))

    return A[0] * A[1] * A[2]
}

fun solution1Ctype(A: IntArray): Int {
    A.sort()
    A.reverse()
    var maxSorted = A[0] * A[1] * A[2]

    A.reverse()
    var maxReversed = A[0] * A[1] * A[2]

    return max(maxSorted, maxReversed)
}

//점수 : 44
//Task : 44
//Correctness : 100
//Performance : 0
/*
For example, for the input [-5, 5, -5, 4] the solution
returned a wrong answer (got -100 expected 125).
 */
fun solution1Dtype(A: IntArray): Int {
    A.sort()

    var max = A[0] * A[1] * A[2]
    for (pIdx in 0..(A.size-3)) {

        for (qIdx in (pIdx+1)..(A.size-2)) {

            for (rIdx in (qIdx+1)..(A.size-1)) {
                max = max(max, A[pIdx] * A[qIdx] * A[rIdx])
            }
        }
    }

    return max
}

// 점수 : 100
// 문제의 본질을 꿰뚫는게.. 중요..
// 사실 이건 쉬운 단계라기 보단.. 생각이 정말 필요로 하는 문제인것 같다.
// 문제에 함정이 있다. 함정이라기 보단 중요한 조건인데

// each element of array A is an integer within the range [−1,000..1,000]
// 보면 (-)음수가 있다. 조합은 3개의 조합으로 Max를 만들어내야한다.
// 근데 (-)음수가 한개이면 3개의 수 곱에서 결과가 (-)음수가 나오지만
// (-)음수가 두개이면 3개의 수 곱에서 결과가 (+)양수가 나온다

// 자! 그러면 최대의 수를 뽑으려면 두가지 case가 있는데 (+)*(+)*(+)로 하던지 (-)*(-)*(+)로 가야한다.
// 설사 (-)*(-)*(-)가 된다한들 상관없다. 모든수가 음수인 상황이기 때문에 두 case중 가장 큰수가 뽑힐것이다.
// 전자는 큰수부터 정렬시켜서 앞 세 숫자를 뽑으면 되지만
// 후자는 작은수 부터 정렬 시켜서 앞 두 숫자만 뽑고, 나머지 하나는 맨 마지막에서 뽑아야 한다.
// 왜냐? 나머지 하나는 아마 가장 뒤에 있을 것이다.

// 이 문제가 만약 시험문제에 나온다?...
// 분명 바로 이렇게 못풀것이다..
//
fun solution1Etype(A: IntArray): Int {
    A.sort()
    A.reverse()
    var maxSorted = A[0] * A[1] * A[2]

    A.reverse()
    var maxReversed = A[0] * A[1] * A[A.lastIndex]

    return max(maxSorted, maxReversed)
}