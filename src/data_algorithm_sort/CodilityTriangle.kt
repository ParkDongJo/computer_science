package data_algorithm_sort


/**
An array A consisting of N integers is given. A triplet (P, Q, R) is triangular if 0 ≤ P < Q < R < N and:

A[P] + A[Q] > A[R],
A[Q] + A[R] > A[P],
A[R] + A[P] > A[Q].
For example, consider array A such that:

A[0] = 10    A[1] = 2    A[2] = 5
A[3] = 1     A[4] = 8    A[5] = 20
Triplet (0, 2, 4) is triangular.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers, returns 1 if there exists a triangular triplet for this array and returns 0 otherwise.

For example, given array A such that:

A[0] = 10    A[1] = 2    A[2] = 5
A[3] = 1     A[4] = 8    A[5] = 20
the function should return 1, as explained above. Given array A such that:

A[0] = 10    A[1] = 50    A[2] = 5
A[3] = 1
the function should return 0.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..100,000];
each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
 */

fun main(args: Array<String>) {
//    println(solution3(intArrayOf(10,2,5,1,8,20)))
//    println(solution3(intArrayOf(10,50,5,1)))

    println(solution3Atype(intArrayOf(10,2,5,1,8,20)))
    println(solution3Atype(intArrayOf(10,50,5,1)))
}

//17
//점수 : 62
//Task : 62
//Correctness : 90
//Performance : 16
fun solution3(A: IntArray): Int {

    A.sort()

    for (p in 0..(A.size-3)) {

        for (q in (p+1)..(A.size-2)) {

            for (r in (q+1)..(A.size-1)) {
                if (A[p]+A[q] > A[r] &&
                        A[q]+A[r] > A[p] &&
                        A[r]+A[p] > A[q]) {
                    return 1
                }
            }
        }

    }
    return 0
}

// 점수 : 100
// 시간복잡도 : O(N*log(N))

/*
    이것도 문제를 잘 들여다봐야 답이 있다. 여기도 함정이 있다.
    사실 저 3개의 조건중 2개는 너무 당연한 조건이고, 나머지 하나가 꼭 체크를 해야하는 조건이다.

    즉 정렬을 시켰다면 하나의 조건만 만족시켜도 된다.
    두번째는 정렬을 시켰다면 어차피
    0 ≤ P < Q < R < N
    이러한 조건이 걸린 상황이라면

 */
fun solution3Atype(A: IntArray): Int {
    A.sort()

    for (i in 0..(A.size-3)) {
        if (A[i].toBigInteger() + A[i+1].toBigInteger() > A[i+2].toBigInteger()) {
            return 1
        }
    }
    return 0
}