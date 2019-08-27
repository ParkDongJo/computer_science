package data_algorithm_array

/*
    A non-empty array A consisting of N integers is given. The array contains an odd number of elements, and each element of the array can be paired with another element that has the same value, except for one element that is left unpaired.

    For example, in array A such that:

      A[0] = 9  A[1] = 3  A[2] = 9
      A[3] = 3  A[4] = 9  A[5] = 7
      A[6] = 9
    the elements at indexes 0 and 2 have value 9,
    the elements at indexes 1 and 3 have value 3,
    the elements at indexes 4 and 6 have value 9,
    the element at index 5 has value 7 and is unpaired.
    Write a function:

    fun solution(A: IntArray): Int

    that, given an array A consisting of N integers fulfilling the above conditions, returns the value of the unpaired element.

    For example, given array A such that:

      A[0] = 9  A[1] = 3  A[2] = 9
      A[3] = 3  A[4] = 9  A[5] = 7
      A[6] = 9
    the function should return 7, as explained in the example above.

    Write an efficient algorithm for the following assumptions:

    N is an odd integer within the range [1..1,000,000];
    each element of array A is an integer within the range [1..1,000,000,000];
    all but one of the values in A occur an even number of times.
    Copyright 2009–2019 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */

fun main(args: Array<String>) {
//    println(solution(intArrayOf(9,3,9,3,9,7,9)))
//    println(solution2(intArrayOf(9,3,9,3,9,7,9)))
    println(solution3(intArrayOf(9,3,9,3,9,7,9,3,9,9,3)))

}

fun solution(A: IntArray): Int {
    var tmpArr = A

    for (i in 0..(tmpArr.size-1)) {
        for (j in (i+1)..(tmpArr.size-1)) {
            if (tmpArr[i] == tmpArr[j]) {
                tmpArr[i] = 0
                tmpArr[j] = 0
                break
            }
        }
    }

    var answer: Int = 0
    for (e in tmpArr) {
        if (e != 0) answer = e
    }

    return answer
}

fun solution2(A: IntArray): Int {
    var memo = BooleanArray(1_000_000_001)
    var tmpArr = A

    for (n in tmpArr) {
        memo[n] = !memo[n]
    }

    var answer: Int = 0
    for ((i,e) in memo.withIndex()) {
       if (e) {
           answer = i
           break
       }
    }

    return answer
}

fun solution3(A: IntArray): Int {
    var answer = 0

    for (e in A) {
        answer = answer.xor(e)
    }

    return answer
}