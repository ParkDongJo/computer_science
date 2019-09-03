package data_algorithm_array

/**
A non-empty array A consisting of N integers is given.

The leader of this array is the value that occurs in more than half of the elements of A.

An equi leader is an index S such that 0 ≤ S < N − 1 and
two sequences A[0], A[1], ..., A[S] and A[S + 1], A[S + 2], ..., A[N − 1] have leaders of the same value.

For example, given array A such that:

A[0] = 4
A[1] = 3
A[2] = 4
A[3] = 4
A[4] = 4
A[5] = 2
we can find two equi leaders:

0, because sequences: (4) and (3, 4, 4, 4, 2) have the same leader, whose value is 4.
2, because sequences: (4, 3, 4) and (4, 4, 2) have the same leader, whose value is 4.
The goal is to count the number of equi leaders.

Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A consisting of N integers, returns the number of equi leaders.

For example, given:

A[0] = 4
A[1] = 3
A[2] = 4
A[3] = 4
A[4] = 4
A[5] = 2
the function should return 2, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].
 */

fun main(args: Array<String>) {
//    println(asolution(intArrayOf(4,3,4,4,4,2)))
//    println(asolutionAtype(intArrayOf(4,3,4,4,4,2)))
    println(asolutionCtype(intArrayOf(4,3,4,4,4,2)))
}

// 점수 : 55
// Task : 55
// Correctness : 100
// Performance : 0
/*
    (2+1)/2 과 2+1/2는 당연히 다른 순서가 나
 */
fun asolution(A: IntArray): Int {
    // write your code in Kotlin
    var answer = 0

    var preArrHash: HashMap<Int,Int>
    var preArrHalf: Int
    var preDomi: Int
    var isExistPreDomi: Boolean


    var backArrHash: HashMap<Int,Int>
    var backArrHalf: Int
    var backDomi: Int
    var isExistBackDomi: Boolean

    for (i in 0..(A.size-1)) {

        preArrHash = hashMapOf<Int,Int>()
        preArrHalf = if (i+1 == 1) 0 else (i+1)/2
        preDomi = 0
        isExistPreDomi = false

        for (j in 0..i) {
            var count = 0
            if (preArrHash.contains(A[j])) {
                count = preArrHash.getValue(A[j])
                count += 1
                preArrHash.set(A[j], count)
            } else {
                count += 1
                preArrHash.set(A[j], count)
            }

            if (count > preArrHalf) {
                preDomi = A[j]
                isExistPreDomi = true
                break
            }
        }

        backArrHash = hashMapOf<Int,Int>()
        backArrHalf = if ((A.size-1-i) == 1) 0 else (A.size-1-i)/2
        backDomi = 0
        isExistBackDomi = false

        for (k in (i+1)..(A.size-1)) {
            var count = 0
            if (backArrHash.contains(A[k])) {
                count = backArrHash.getValue(A[k])
                count += 1
                backArrHash.set(A[k], count)
            } else {
                count += 1
                backArrHash.set(A[k], count)
            }

            if (count > backArrHalf) {
                backDomi = A[k]
                isExistBackDomi = true
                break
            }
        }

        if (isExistPreDomi && isExistBackDomi) {
            if (preDomi == backDomi) {
                answer++
            }
        }
    }

    return answer
}



// 점수 : 33
// Task : 33
// Correctness : 60
// Performance : 0
fun asolutionAtype(A: IntArray): Int {
    var answer = 0

    var leftHash = hashMapOf<Int, Int>()
    var rightHash = hashMapOf<Int, Int>()
    var count: Int

    for (num in A) {
        count = 0
        if (rightHash.contains(num)) {
            count = rightHash.getValue(num)
            count++
            rightHash.set(num, count)
        } else {
            count++
            rightHash.set(num, count)
        }
    }

    var max= rightHash.getValue(A[0])
    var leader = A[0]
    for ((k,v) in rightHash) {
        if (max < v) {
            leader = k
        }
    }

    var rCnt: Int
    var lCnt: Int

    for ((i,num) in A.withIndex()) {
        rCnt = rightHash.getValue(num)
        lCnt = if (leftHash.contains(num))  leftHash.getValue(num) else 0

        rCnt--
        lCnt++

        rightHash.set(num, rCnt)
        leftHash.set(num, lCnt)


        if (leftHash.getValue(leader) > (i+1)/2 && rightHash.getValue(leader) > (i+1)/2) {
            answer++
        }
    }

    return answer
}


// 점수 : 100
// Task : 100
// Correctness : 100
// Performance : 100
fun asolutionCtype(A: IntArray): Int {

    var hash = hashMapOf<Int, Int>()
    var leader = -1
    var countOfLeader = 0

    for (num in A) {
        var count = 0
        if (hash.contains(num)) {
            count = hash.getValue(num)
            count++
            hash.set(num, count)
            if(countOfLeader < count){
                countOfLeader=count
                leader= num
            }
        } else {
            count++
            hash.set(num, count)
        }
    }
    if (countOfLeader > A.size-1/2) {
        return 0
    }

    var countEquil = 0
    var counterOfrLeaderInRight = 0
    var counterOfrLeaderInLeft = countOfLeader

    for(i in (A.size-1) downTo 0){
        if(A[i]==leader){
            counterOfrLeaderInRight++
            counterOfrLeaderInLeft--
        }

        if(counterOfrLeaderInLeft > (i/2) && counterOfrLeaderInRight > ((A.size-i)/2)){
            countEquil++
        }
    }

    return countEquil
}
