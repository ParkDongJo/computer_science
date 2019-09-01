package data_algorithm_array


/*
An array A consisting of N integers is given.
The dominator of array A is the value that occurs in more than half of the elements of A.

For example, consider array A such that

 A[0] = 3    A[1] = 4    A[2] =  3
 A[3] = 2    A[4] = 3    A[5] = -1
 A[6] = 3    A[7] = 3
The dominator of A is 3 because it occurs in 5 out of 8 elements of A
(namely in those with indices 0, 2, 4, 6 and 7) and 5 is more than a half of 8.

Write a function

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers,
returns index of any element of array A in which the dominator of A occurs.
The function should return −1 if array A does not have a dominator.

For example, given array A such that

 A[0] = 3    A[1] = 4    A[2] =  3
 A[3] = 2    A[4] = 3    A[5] = -1
 A[6] = 3    A[7] = 3
the function may return 0, 2, 4, 6 or 7, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..100,000];
each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
 */


fun main(args: Array<String>) {
//    println(solutionDomi(intArrayOf(3,4,3,2,3,-1,3,3)))
//    println(solutionDomi(intArrayOf(0,0,1,1,1)))
//    println(solutionDomi(intArrayOf(0,0,0,1,1,2,2,2,2)))

//    println(solutionDomiBtype(intArrayOf(3,4,3,2,3,-1,3,3)))
//    println(solutionDomiBtype(intArrayOf(0,0,1,1,1)))
//    println(solutionDomiBtype(intArrayOf(0,0,0,1,1,2,2,2,2)))

//    println(solutionDomiCtype(intArrayOf(3,4,3,2,3,-1,3,3)))
//    println(solutionDomiCtype(intArrayOf(0,0,1,1,1)))
//    println(solutionDomiCtype(intArrayOf(0,0,0,1,1,2,2,2,2)))

    println(solutionDomiDtype(intArrayOf(3,4,3,2,3,-1,3,3)))
    println(solutionDomiDtype(intArrayOf(0,0,1,1,1)))
    println(solutionDomiDtype(intArrayOf(0,0,0,1,1,2,2,2,2)))


}

// 걸린 시간 : 40 min
// 점수 : 66
// Task : 66
// Correctness : 50
// Performance : 100

// 일단 문제를 확실하게 짚고 가지 않았다.
// return 값이 여러개중 어떤것이든 리턴해도 괜찮다는 문구 (the function may return 0, 2, 4, 6 or 7,)
//   -> 아니.. 솔직히 이건.. 낼거면 lastIdx로 하던가.. 왤케 불명확하게 문제를 내는지..
//
// hashMap과 hashSet의 사용법을 명확하게 할 필요가 있을것 같다.
// 이게 될까 안될까 하는 생각이 오히려 문제를 푸는것을 방해를 한다.
// cached 전략을 할거라면 이 두개 컬렉션을 주로 쓸것이고, 그렇다면
// hashMap과 hashSet은 학습을 해두자
fun solutionDomi(A: IntArray): Int {
    var candidateDomi = hashMapOf<Int,Counter>()

    for ((i,n) in A.withIndex()) {
        if (candidateDomi.contains(n)) {
            var counter = candidateDomi.getValue(n)
            counter.count++
            counter.lastIdx = i
            candidateDomi.set(n,counter)
        } else {
            candidateDomi.set(n,Counter(n,1,i))
        }
    }

    for ((k,v) in candidateDomi) {
        if (v.count >= (A.size/2)) {
            return v.lastIdx
        }
    }

    return -1
}


// 점수 : 83
// Task : 83
// Correctness : 75
// Performance : 100
fun solutionDomiBtype(A: IntArray): Int {
    var rankList = hashMapOf<Int,Counter>()

    for ((i,n) in A.withIndex()) {
        if (rankList.contains(n)) {
            var counter = rankList.getValue(n)
            counter.count++
            counter.lastIdx = i

            rankList.set(n,counter)
        } else {
            rankList.set(n,Counter(n,1,i))
        }
    }

    when(A.size%2) {
        0->{
            return checkDominator(rankList,
                                (A.size/2),
                                { c: Int, s: Int -> if(c>=s) true else false })
        }
        else->{
            return checkDominator(rankList,
                        (A.size/2)+1,
                                { c: Int, s: Int -> if(c>=s) true else false })
        }
    }
}

fun checkDominator(map: HashMap<Int,Counter>,
                   halfSize: Int,
                   filter: (Int, Int) -> Boolean): Int {
    for (c in map.values) {
        if (filter(c.count, halfSize)) {
            return c.lastIdx
        }
    }

    return -1
}

class Counter {
    var num: Int
    var count: Int
    var lastIdx: Int

    constructor(_num: Int, _count: Int, _lastIdx: Int) {
        this.num = _num
        this.count = _count
        this.lastIdx = _lastIdx
    }
}


// 점수 : 66
// Task : 66
// Correctness : 62
// Performance : 75
fun solutionDomiCtype(A: IntArray): Int {
    var lastIdxListOfNum = hashMapOf<Int,Int>()

    for ((i,n) in A.withIndex()) {
        if (lastIdxListOfNum.contains(n)) {
            lastIdxListOfNum.replace(n, i)
        } else {
            lastIdxListOfNum.put(n, i)
        }
    }

    A.sort()
    var dominator = A[0]
    var domiCnt = 0

    var currentNum = A[0]
    var preNumCnt = 0
    var currNumCnt = 0

    for (n in A) {
        if (currentNum == n) {
            currNumCnt++
        } else {
             if (currNumCnt > preNumCnt) {
                 dominator = currentNum
                 domiCnt = currNumCnt
             }
            currentNum = n
            preNumCnt = currNumCnt
            currNumCnt = 1
        }
    }

    if (currNumCnt > preNumCnt) {
        dominator = currentNum
        domiCnt = currNumCnt
    }

    when(A.size%2) {
        0->{
            if (domiCnt >= A.size/2) {
                return lastIdxListOfNum.getValue(dominator)
            }
        }
        else->{
            if (domiCnt >= A.size/2+1) {
                return lastIdxListOfNum.getValue(dominator)
            }
        }
    }
    return -1
}


// 점수 : 83
// Task : 83
// Correctness : 75
// Performance : 100
// 지금 어떤 특정 조건이 빠진듯!!!
// 이 코드가 제일 깔끔!!! 이 접근법이 맞다!!
// 지금 이것도 문제의 본질을 꿰뚫지 못해서 이렇게 깔끔하게 풀지 못했음..
// 굳이 끝까지 다 돌 필요가 없는데..
// 문제 해석능력에 문제가 있긴한거 같다!!!!
fun solutionDomiDtype(A: IntArray): Int {
    var hash = hashMapOf<Int,Int>()
    var half = if (A.size%2 == 0) A.size/2 else (A.size/2)+1

    for ((i,n) in A.withIndex()) {
        if (hash.contains(n)) {
            val cnt = hash.getValue(n)
            hash.replace(n, cnt+1)
        } else {
            hash.put(n, 1)
        }

        if (hash.getValue(n) >= half) {
            return i
        }
    }

    return -1
}