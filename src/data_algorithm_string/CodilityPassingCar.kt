package data_algorithm_string

/**
A non-empty array A consisting of N integers is given.
The consecutive elements of array A represent consecutive cars on a road.

Array A contains only 0s and/or 1s:

0 represents a car traveling east,
1 represents a car traveling west.
The goal is to count passing cars. We say that a pair of cars (P, Q),
where 0 ≤ P < Q < N, is passing when P is traveling to the east and Q is traveling to the west.

For example, consider array A such that:

A[0] = 0
A[1] = 1
A[2] = 0
A[3] = 1
A[4] = 1
We have five pairs of passing cars: (0, 1), (0, 3), (0, 4), (2, 3), (2, 4).

Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A of N integers, returns the number of pairs of passing cars.

The function should return −1 if the number of pairs of passing cars exceeds 1,000,000,000.

For example, given:

A[0] = 0
A[1] = 1
A[2] = 0
A[3] = 1
A[4] = 1
the function should return 5, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer that can have one of the following values: 0, 1.
 */

fun main(args: Array<String>) {
//    println(solutionAtype(intArrayOf(0,1,0,1,1)))
//    println(solutionBtype(intArrayOf(0,1,0,1,1)))
    println(solutionCtype(intArrayOf(0,1,0,1,1)))
}

// 걸린 시간 31 min 정도
// 점수 : 50
// Task : 50
// Correctness : 100
// Performance : 0
fun solutionAtype(A: IntArray): Int {
    var pairs = HashSet<Pair>()

    for ((i, direction) in A.withIndex()) {
        if (direction == 0) {

            for (j in (i+1)..(A.size-1)) {
                if (A[j] == 1) {
                    pairs.add(Pair(i,j))
                }

                if (pairs.size > 1_000_000_000) {
                    return -1
                }
            }
        }
    }

    return pairs.size
}

class Pair {
    var east: Int
    var west: Int
    constructor(e: Int, w: Int) {
        this.east = e
        this.west = w
    }
}

// 점수 : 60
// Task : 60
// Correctness : 100
// Performance : 20
fun solutionBtype(A: IntArray): Int {
    var eastList = ArrayList<Int>()
    for (direction in A) {
        if (direction == 0) {
            eastList.add(0)
        } else {
            for (i in 0..(eastList.size-1)) {
                eastList[i] += 1
            }
        }
    }

    var sum = 0
    for (cnt in eastList) {
        sum += cnt
    }

    return if(sum > 1_000_000_000) -1 else sum
}


// 점수 : 90
// Task : 90
// Correctness : 100
// Performance : 80
/*
    방법은 맞는데 어디 한군데 예외처리나 대비하지 못한
    예외 케이스가 있는듯
 */
fun solutionCtype(A: IntArray): Int {
    var zeroCnt = 0
    var sum = 0

    for (direction in A) {
        if (direction == 0) {
            zeroCnt += 1
        } else {
            sum += zeroCnt
        }
    }

    return if(sum > 1_000_000_000) -1 else sum
}