package data_algorithm_sort

/**
Write a function

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers, returns the number of distinct values in array A.

For example, given array A consisting of six elements such that:

A[0] = 2    A[1] = 1    A[2] = 1
A[3] = 2    A[4] = 3    A[5] = 1
the function should return 3, because there are 3 distinct values appearing in array A, namely 1, 2 and 3.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].
 */

fun main(args: Array<String>) {
    println(solution2(intArrayOf(2,1,1,2,3,1)))
    println(solution2(intArrayOf(2,1,1,2,3,1,3,4)))
}

// 시간 : 12 min
// 점수 : 0
fun solution2(A: IntArray): Int {
    // write your code in Kotlin
    A.sort()
    var cursor = A[0]
    var count = 0
    var answer = 0

    for (n in A) {
        if (cursor == n) {
            count++
        } else {
            if (count == 1) {
                answer = n
                break
            } else {
                cursor = n
                count = 1
            }
        }
    }

    if (count == 1) {
        return cursor
    }

    return answer
}

// 100점
fun solution2Btype(A: IntArray): Int {
    if (A.isEmpty()) {
        return 0
    }

    A.sort()
    var cursor = A[0]
    var distinctCnt = 1

    for (n in A) {
        if (cursor != n) {
            distinctCnt++
            cursor = n
        }
    }

    return distinctCnt
}