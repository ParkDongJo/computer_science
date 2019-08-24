package data_algorithm_number_theory


/**
    [ 문제 설명 ]
    자연수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수, solution을 완성해주세요.

    [ 제한 사항 ]
    n은 0 이상 3000이하인 자연수입니다.

    [ 입출력 예 ]
    n	return
    12	28
    5	6
    입출력 예 설명
    입출력 예 #1
    12의 약수는 1, 2, 3, 4, 6, 12입니다. 이를 모두 더하면 28입니다.

    입출력 예 #2
    5의 약수는 1, 5입니다. 이를 모두 더하면 6입니다.
 */
fun main(args: Array<String>) {
    println(solution(5))
}

fun solution(n: Int): Int {
    return getSumOfDivisor(n)
}


fun getSumOfDivisor(n: Int): Int {
    var sum: Int = 0

    for (i in 1..n) {
        if (n%i == 0) sum += i
    }
    return sum
}


// 소수를 구하는 코드
// 소수의 합을 구하는 것으로 착각함
// 그래도 연습삼아 코드 구현했다고 생각하고 남겨놓음
fun getPrimList(n: Int) : Array<Int> {
    var result = ArrayList<Int>()
    var isPrime = BooleanArray(n+1, { true })
//    isPrime[0] = false
//    isPrime[1] = false

    var step: Int
    for (i in 2..n) {
        if (isPrime[i]) {
            step = 2
            while (i*step <= n) {
                isPrime[i*step] = false
                step++
            }
        }
    }

    for (i in 2..n) {
        if (isPrime[i]) result.add(i)
    }

    val array = arrayOfNulls<Int>(result.size)
    return result.toArray(array)
}

fun getPrimSum(n: Int) : Int {
    var result = 0
    var isPrime = BooleanArray(n+1, { true })
//    isPrime[0] = false
//    isPrime[1] = false

    var step: Int = 0
    for (i in 2..n) {
        if (isPrime[i]) {
            step = 2
            while (i*step <= n) {
                isPrime[i*step] = false
                step++
            }
        }
    }

    for (i in 2..n) {
        if (isPrime[i]) result += i
    }

    return result
}