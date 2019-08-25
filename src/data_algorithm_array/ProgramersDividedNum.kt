package data_algorithm_array

import java.util.*

/**
    [ 문제 설명 ]
    array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성해주세요.
    divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.

    [ 제한사항 ]
    arr은 자연수를 담은 배열입니다.
    정수 i, j에 대해 i ≠ j 이면 arr[i] ≠ arr[j] 입니다.
    divisor는 자연수입니다.
    array는 길이 1 이상인 배열입니다.

    [ 입출력 예 ]
    arr	divisor	return
    [5, 9, 7, 10]	5	[5, 10]
    [2, 36, 1, 3]	1	[1, 2, 3, 36]
    [3,2,6]	10	[-1]

    [ 입출력 예 설명 ]
    입출력 예#1
    arr의 원소 중 5로 나누어 떨어지는 원소는 5와 10입니다. 따라서 [5, 10]을 리턴합니다.

    입출력 예#2
    arr의 모든 원소는 1으로 나누어 떨어집니다. 원소를 오름차순으로 정렬해 [1, 2, 3, 36]을 리턴합니다.

    입출력 예#3
    3, 2, 6은 10으로 나누어 떨어지지 않습니다. 나누어 떨어지는 원소가 없으므로 [-1]을 리턴합니다.
 */

/*
    [ 알아두면 좋은 스킬 ]

    answer.toIntArray()
 */

fun main(args: Array<String>) {
    println(Arrays.toString(solution(intArrayOf(5, 9, 7, 10), 5)))
    println(Arrays.toString(solution(intArrayOf(2, 36, 1, 3), 1)))
    println(Arrays.toString(solution(intArrayOf(3,2,6), 10)))
}

fun solution(arr: IntArray, divisor: Int): IntArray {
    var answer = ArrayList<Int>()
    var idx: Int = 0

    for (e in arr) {
        if (e%divisor == 0) {
            answer.add(e)
        }
    }
    if (answer.isEmpty()) answer.add(-1)

    return answer.toIntArray().sortedArray()
}


// 다른 사람 풀이
fun anotherSolution(arr: IntArray, divisor: Int): IntArray {
    var answer = arrayListOf<Int>()

    for (ar in arr){
        if (ar % divisor == 0){
            answer.add(ar)
        }
    }

    if (answer.size == 0){
        answer.add(-1)
    }

    return answer.sorted().toIntArray()
}