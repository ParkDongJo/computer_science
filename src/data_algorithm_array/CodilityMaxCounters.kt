package data_algorithm_array

import java.util.*

/**
You are given N counters, initially set to 0, and you have two possible operations on them:

increase(X) − counter X is increased by 1,
max counter − all counters are set to the maximum value of any counter.
A non-empty array A of M integers is given. This array represents consecutive operations:

if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
if A[K] = N + 1 then operation K is max counter.
For example, given integer N = 5 and array A such that:

    A[0] = 3
    A[1] = 4
    A[2] = 4
    A[3] = 6
    A[4] = 1
    A[5] = 4
    A[6] = 4
the values of the counters after each consecutive operation will be:

    (0, 0, 1, 0, 0)
    (0, 0, 1, 1, 0)
    (0, 0, 1, 2, 0)
    (2, 2, 2, 2, 2)
    (3, 2, 2, 2, 2)
    (3, 2, 2, 3, 2)
    (3, 2, 2, 4, 2)
The goal is to calculate the value of every counter after all operations.

Write a function:

class Solution { public int[] solution(int N, int[] A); }

that, given an integer N and a non-empty array A consisting of M integers, returns a sequence of integers representing the values of the counters.

Result array should be returned as an array of integers.

For example, given:

    A[0] = 3
    A[1] = 4
    A[2] = 4
    A[3] = 6
    A[4] = 1
    A[5] = 4
    A[6] = 4
the function should return [3, 2, 2, 4, 2], as explained above.

Write an efficient algorithm for the following assumptions:

N and M are integers within the range [1..100,000];
each element of array A is an integer within the range [1..N + 1].
 */

/*
    [ 문제 풀이 ]
    오히려 성능 개선을 위한 코드가 예외처리 미흡으로 인해 더 낮은 점수를 뱉아냈음
    시험에서는 이런 위험감수를 하진 말자!!

    오히려 시간이 남았을 시
    쉬운문제에서 성능적인 개선을 찾자!!
    성능적인 개선점 몇가지를 정리해두자

    오히려 시험에서는 성능적인 이슈보다
    문제풀이의 정확도에 초점을 맞추자
 */

import kotlin.math.*

fun main(args: Array<String>) {
//    var arr = intArrayOf(0,0,0,0)
//    arr = arr.forEach { return it }
//    println(Arrays.toString(arr))

//    var arr  = IntArray(10) { (1..10).shuffled().first() }
//    println(Arrays.toString(arr))
//    println(Arrays.toString(solutionBtype(9, arr)))

//    println(Arrays.toString(solutionAtype(5, intArrayOf(3,4,4,6,1,4,4))))
//    println(Arrays.toString(solutionAtype(5, intArrayOf(1,1,1,1,1,1,6))))

//    println(Arrays.toString(solutionBtype(5, intArrayOf(3,4,4,6,1,4,4))))
//    println(Arrays.toString(solutionBtype(5, intArrayOf(1,1,1,1,1,1,6))))
//    println(Arrays.toString(solutionBtype(7, intArrayOf(1,2,1,8,1,3,4,8,5))))
//    println(Arrays.toString(solutionBtype(5, intArrayOf(6,6,6,6,6,6,6))))

    println(Arrays.toString(solutionCtype(5, intArrayOf(3,4,4,6,1,4,4))))
    println(Arrays.toString(solutionCtype(5, intArrayOf(1,1,1,1,1,1,6))))
    println(Arrays.toString(solutionCtype(7, intArrayOf(1,2,1,8,1,3,4,8,5))))
    println(Arrays.toString(solutionCtype(5, intArrayOf(6,6,6,6,6,6,6))))

}

// 최종 점수 : 88
// 걸린 시간 : 20 min 정도
// task : 88
// Correctness : 100
// Performance : 80
fun solutionAtype(N: Int, A: IntArray): IntArray {
    var counter = IntArray(N, {i->0})

    for (x in A) {
        if (x < (N+1)) {
            counter[x-1] += 1
        } else {
            var max = 0
            for (n in counter) {
                max = max(max, n)
            }

            for ((i) in counter.withIndex()) {
                counter[i] = max
            }
        }
    }

    return counter
}


// 최종 점수 : 33
// 걸린 시간 : 60 min 정도 ( 처음에 a 방식을 풀고 b 방식으로 바꾸다 보니 시간이 더 걸림)
// task : 33
// Correctness : 50
// Performance : 20
fun solutionBtype(N: Int, A: IntArray): IntArray {
    var counter = IntArray(N, {i->0})

    var lastIdxOfMax = A.lastIndexOf(N+1)

    // 이 부분이 문제!
    // max 처리하는 값을 빼다보니,
    // 정작 전체적으로 max값이 채워지지 않은 상태에서
    // counter를 하고 있음
    for (i in 0..lastIdxOfMax) {
        if (A[i] < N+1) {
            counter[A[i]-1] += 1
        }
    }

    var max = 0
    for (n in counter) {
        max = max(max, n)
    }

    for ((i) in counter.withIndex()) {
        counter[i] = max
    }

    var currIdx = lastIdxOfMax + 1
    while (currIdx < A.size) {
        counter[A[currIdx]-1] += 1
        currIdx++
    }

    return counter
}



fun solutionCtype(N: Int, A: IntArray): IntArray {
    var counter = IntArray(N, {i->0})

    var lastIdxOfMax = A.lastIndexOf(N+1)

    var max = 0
    var floor = 0
    for ((idx,x) in A.withIndex()) {
        if (x < (N+1)) {
            counter[x-1] = if(counter[x-1] >= floor) counter[x-1] + 1 else floor + 1
            max = max(max, counter[x-1])
        } else if (idx == lastIdxOfMax) {
            for ((i) in counter.withIndex()) {
                counter[i] = max
            }
        } else {
            floor = max
        }
    }

    return counter
}
