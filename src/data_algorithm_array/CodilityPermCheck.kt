package data_algorithm_array

import kotlin.math.*

/**
A non-empty array A consisting of N integers is given.

A permutation is a sequence containing each element from 1 to N once, and only once.

For example, array A such that:

A[0] = 4
A[1] = 1
A[2] = 3
A[3] = 2
is a permutation, but array A such that:

A[0] = 4
A[1] = 1
A[2] = 3
is not a permutation, because value 2 is missing.

The goal is to check whether array A is a permutation.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A, returns 1 if array A is a permutation and 0 if it is not.

For example, given array A such that:

A[0] = 4
A[1] = 1
A[2] = 3
A[3] = 2
the function should return 1.

Given array A such that:

A[0] = 4
A[1] = 1
A[2] = 3
the function should return 0.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [1..1,000,000,000].
 */

/*
    [문제 풀이]
 */

/*
    예외에 대한 코멘트
    The following issues have been detected: wrong answers.
    For example, for the input [1] the solution returned a wrong answer (got 0 expected 1).

    1. 문제를 잘못 오해했다.
    containing each element from 1 to N once, and only once.
    이 대목의 해석을 느슨하게 했다.
    이 대목에 의하면, 무조건 1~N 까지의 숫자가 있어야 하며, 절대 중복을 허용하지 않는다.

    2. 중복을 생각하지 못했다.

    3. 1개의 수열이라도 1부터 시작하면 성립한다.

    4. 어째든 A 배열 사이즈보다 큰 수가 내부에 있으면 안된다!!!
 */

fun main(args: Array<String>) {
//    println(solutionAtype(intArrayOf(4,1,3,2)))
//    println(solutionAtype(intArrayOf(4,1,3)))
//    println(solutionAtype(intArrayOf(1)))
//    println(solutionAtype(intArrayOf(2)))
//    println(solutionAtype(intArrayOf(2,2,2,2)))

    println(solutionBtype(intArrayOf(4,1,3,2)))
    println(solutionBtype(intArrayOf(4,1,3)))
    println(solutionBtype(intArrayOf(1)))
    println(solutionBtype(intArrayOf(2)))
    println(solutionBtype(intArrayOf(2,2,2,2)))
}

//최초 풀이 점수
// Task : 66
// Correctness : 33
// Performance : 100

// 걸린 시간 : 28 min
/*
    퍼포먼스가 100인데 정확서잉 떨어진건, 접근법은 맞으나
    뭔가 예외적인 처리를 놓치고 처리를 하지 않았다는 이야기
 */
fun solutionAtype(A: IntArray): Int {
    var answer = 1
    var max = A[0]

    for(i in 1..(A.size-1)) {
        max = max(max, A[i])
    }

    if (max != (A.size)) {
        return 0
    }

    A.sort()
    for(n in max downTo 1) {
        var idx = binarySearch(A, 0, A.size-1, n)
        if (idx == -1) {
            answer = 0
            break
        }
    }
    return answer
}

fun binarySearch(arr: IntArray, start: Int, end: Int, value: Int): Int {
    if (start > end) {
        return -1
    } else if (start == end) {
        if (arr[start] == value) {
            return start
        } else {
            return -1
        }
    } else {
        var mid = (start + end) / 2

        if (arr[mid] == value) {
            return mid
        } else if (arr[mid] > value) {
            return binarySearch(arr, start, mid-1, value);
        } else {
            return binarySearch(arr, mid+1, end, value);
        }
    }
}

// 다른 사람 풀이
// 아주 심플하다!!
// 더 심플하다.
// 중복의 개념을 SET 이라는 컬렉션을 통해 구현했다.

fun solutionBtype(A: IntArray): Int {
    var marks = hashSetOf<Int>()

    for (i in 0..(A.size-1)) {
        if (A[i] > A.size) {
            return 0
        }

        if (marks.contains(A[i])) {
            return 0
        }

        marks.add(A[i])
    }

    return 1
}


