package data_algorithm_string

import java.util.*

/*
[문자열 내 마음대로 정렬하기]

문제 설명
문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때, 각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다.
예를 들어 strings가 [sun, bed, car]이고 n이 1이면 각 단어의 인덱스 1의 문자 u, e, a로 strings를 정렬합니다.

제한 조건
strings는 길이 1 이상, 50이하인 배열입니다.
strings의 원소는 소문자 알파벳으로 이루어져 있습니다.
strings의 원소는 길이 1 이상, 100이하인 문자열입니다.
모든 strings의 원소의 길이는 n보다 큽니다.
인덱스 1의 문자가 같은 문자열이 여럿 일 경우, 사전순으로 앞선 문자열이 앞쪽에 위치합니다.

입출력 예
strings	n	return
[sun, bed, car]	1	[car, bed, sun]
[abce, abcd, cdx]	2	[abcd, abce, cdx]

입출력 예 설명
입출력 예 1
sun, bed, car의 1번째 인덱스 값은 각각 u, e, a 입니다. 이를 기준으로 strings를 정렬하면 [car, bed, sun] 입니다.

입출력 예 2
abce와 abcd, cdx의 2번째 인덱스 값은 c, c, x입니다.
따라서 정렬 후에는 cdx가 가장 뒤에 위치합니다. abce와 abcd는 사전순으로 정렬하면 abcd가 우선하므로, 답은 [abcd, abce, cdx] 입니다.

 */

fun main(args: Array<String>) {
    println(Arrays.toString(solution(arrayOf("sun", "bed", "car"), 1)))
    println(Arrays.toString(solution(arrayOf("abce", "abcd", "cdx"), 2)))
}

fun solution(strings: Array<String>, n: Int): Array<String> {
    var answer = strings
    // 두가지 기준이 있음

    // n 번째 순으로 먼저 정렬을 한다.
    // 만약 n번째가 같다면
    //  그때는 사전순으로 우열을 가린다.

    // 우선 sort() 를 써야한다.
    // 근데 이 sort() 함수에 문자열 비교하기 위한 커슽머 함수가 가능한지 알아봐야한다.

    var list =  answer.sortedWith(compareBy({ it[n] }, { it }))
    return list.toTypedArray()
}


fun solutionBtype(strings: Array<String>, n: Int): Array<String> {
    return strings.also {
        it.sort()
        it.sortBy { it[n] }
    }
}

fun solutionCtype(strings: Array<String>, n: Int): Array<String> {

    strings.sortWith(Comparator<String> { a, b ->
        when {
            a[n] > b[n] -> 1
            a[n] == b[n] -> {
                when {
                    a > b -> 1
                    else -> -1
                }
            }
            else -> -1
        }
    })
    return strings
}