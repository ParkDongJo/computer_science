package data_algorithm_recursion

/**
문제 설명
피보나치 수는 F(0) = 0, F(1) = 1일 때, 1 이상의 n에 대하여 F(n) = F(n-1) + F(n-2) 가 적용되는 수 입니다.

예를들어

F(2) = F(0) + F(1) = 0 + 1 = 1
F(3) = F(1) + F(2) = 1 + 1 = 2
F(4) = F(2) + F(3) = 1 + 2 = 3
F(5) = F(3) + F(4) = 2 + 3 = 5
와 같이 이어집니다.

2 이상의 n이 입력되었을 때, n번째 피보나치 수를 1234567으로 나눈 나머지를 리턴하는 함수, solution을 완성해 주세요.

제한 사항
 * n은 1이상, 100000이하인 자연수입니다.

입출력 예
n	return
3	2
5	5
입출력 예 설명
피보나치수는 0번째부터 0, 1, 1, 2, 3, 5, ... 와 같이 이어집니다.
 */

/*
    [ 알아두면 좋을 것들 ]
    * n은 1이상, 100000이하인 자연수입니다.

    tailrec fun fibo() {
    }
 */

/*
    [ 문제에 대한 해설 ]

 */

fun main(args: Array<String>) {
//    println(solution(3))
//    println(solution(5))
//    println(solution(100))
    println(solution(100000))

//    println(solutionLoop(3))
//    println(solutionLoop(5))
//    println(solutionLoop(100000))
//    println(solutionLoop(10))
}

fun solution(n: Int): Int {
    var memo = IntArray(n+1)
    return fibo(n, memo)
}

fun fibo(n: Int, memo: IntArray): Int {
    if (n==0) {
        return 0
    } else if (n<=2) {
        return 1
    } else if (memo[n] != 0) {
        return memo[n]
    }

    memo[n] = (fibo(n-1, memo) % 1234567) + (fibo(n-2, memo) % 1234567)
    return memo[n] % 1234567
}

fun solutionLoop(n: Int): Int {
    var nums = IntArray(n+1)
    nums[0] = 0
    nums[1] = 1
    nums[2] = 1

    for (i in 3..n) {
        nums[i] = (nums[i-1] % 1234567) + (nums[i-2] % 1234567)
    }

    return nums[n] % 1234567
}


// 다른사람 풀이
tailrec fun fibo(a: Int, b: Int, m: Int, n: Int): Int {
    if (m <=n) {
        return fibo(b, (a+b)%1234567, m+1, n)
    } else {
        return a
    }
}