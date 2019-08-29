package data_algorithm_array

/**
     An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.

    Your goal is to find that missing element.

    Write a function:

    class Solution { public int solution(int[] A); }

    that, given an array A, returns the value of the missing element.

    For example, given array A such that:

      A[0] = 2
      A[1] = 3
      A[2] = 1
      A[3] = 5
    the function should return 4, as it is the missing element.

    Write an efficient algorithm for the following assumptions:

    N is an integer within the range [0..100,000];
    the elements of A are all distinct;
    each element of array A is an integer within the range [1..(N + 1)].

 */
/*
    [ 알아두면 좋은 것 ]

 */
/*
    [ 문제풀이 ]

    The following issues have been detected: runtime errors.


    점수 :
    Task Score : 80
    Correctness 100
    Performance : 60

    시간 복잡도 -> O(N) or O(N * log(N)) or O(N ** 2)

    에러
    java.lang.ArrayIndexOutOfBoundsException

    문제는
    each element of array A is an integer within the range [1..(N + 1)].
    조건을 잘못 해석함 N의 요소가 N+1까지 간다면
    존재여부를 따지는
    var isExist = Array<Boolean>(100002, {i->false}) 처럼 크기를 +1을 했어야 했음

 */
var isExist = Array<Boolean>(100002, {i->false})

fun main(args: Array<String>) {
    println(findMissingElem(intArrayOf(2,3,1,5)))
}

fun findMissingElem(A: IntArray): Int {
    var answer = 0
    for (n in A) {
        isExist[n] = true
    }

    for (i in 1..(A.size+1)) {
        if (!isExist[i]) {
            answer = i
            break
        }
    }

    return answer
}