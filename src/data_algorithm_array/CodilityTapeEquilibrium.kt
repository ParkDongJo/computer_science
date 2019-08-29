package data_algorithm_array

import kotlin.math.*

/**
A non-empty array A consisting of N integers is given. Array A represents numbers on a tape.

Any integer P, such that 0 < P < N, splits this tape into two non-empty
parts: A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].

The difference between the two parts is the value of: |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|

In other words, it is the absolute difference between the sum of the first part and the sum of the second part.

For example, consider array A such that:

A[0] = 3
A[1] = 1
A[2] = 2
A[3] = 4
A[4] = 3
We can split this tape in four places:

P = 1, difference = |3 − 10| = 7
P = 2, difference = |4 − 9| = 5
P = 3, difference = |6 − 7| = 1
P = 4, difference = |10 − 3| = 7
Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A of N integers, returns the minimal difference that can be achieved.

For example, given:

A[0] = 3
A[1] = 1
A[2] = 2
A[3] = 4
A[4] = 3
the function should return 1, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [2..100,000];
each element of array A is an integer within the range [−1,000..1,000].
 */
/*
    [ 알아두면 좋을 것]
    코틀린에서 절대값을 구할때
    kotlin.math.abs 를 쓰면된다.

    kotlin.math.min
    kotlin.math.max

 */
/*
    [ 문제 풀이 ]
    일단 배열 길이가 100,000 단위로 가게 되면 코딜리티에서는
    일단 100점을 맡기 위해서는 시간 복잡도를 생각해야함.

    시간복잡도를 억지로 줄이고자 할 필요는 없다!!

    다만 기본적으로 중복되는 연산을 줄이는 것이 관건!!

    지금 문제같은 경우

    P=1 -> (A[0]) - (A[1] + ... + A[A.size-1])
    P=2 -> (A[0]+A[1]) - (A[2] + ... + A[A.size-1])

    와 같이 다음 연산에 굳이 하지 않아도 될 중복적인 연산이 있다.
    이를 어떻게 하면 중복을 제거할 수 있을지를 고민해서
    문제를 풀면 된다.
 */

fun main(args: Array<String>) {
    println(getTapeEquilibrium(intArrayOf(3,1,2,4,3)))
}

// 푸는데 소요시간 26 min
// 100점
fun getTapeEquilibrium(A: IntArray): Int {
    var head = A[0]
    var back = 0

    for (j in 1..(A.size-1)) {
        back += A[j]
    }
    var min = abs(head-back)


    for (i in 2..(A.size -1)) {
        head += A[i-1]
        back -= A[i-1]

        min = min(min, abs(head-back))
    }

    return min
}