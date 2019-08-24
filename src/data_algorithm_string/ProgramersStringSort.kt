package data_algorithm_string

/*
    [ 문제 설명 ]
    문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.
    s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.

    [ 제한 사항 ]
    str은 길이 1 이상인 문자열입니다.

    [ 입출력 예 ]
    s	return
    Zbcdefg	gfedcbZ
 */
/*
    [ 알아두면 좋을 것들 ]


 */

/*
    [ 문제에 대한 해설 ]

 */

fun main(args: Array<String>) {
    println(solution("Zbcdefg"))
}

fun solution(s: String): String {

    var cArr = s.toCharArray()
    cArr.reverse()

    return String(cArr)
}