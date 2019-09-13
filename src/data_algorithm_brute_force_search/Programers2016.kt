package data_algorithm_brute_force_search

/**

[ 2016년 ]

문제 설명
2016년 1월 1일은 금요일입니다. 2016년 a월 b일은 무슨 요일일까요? 두 수 a ,b를 입력받아
2016년 a월 b일이 무슨 요일인지 리턴하는 함수, solution을 완성하세요.
요일의 이름은 일요일부터 토요일까지 각각 SUN,MON,TUE,WED,THU,FRI,SAT

입니다. 예를 들어 a=5, b=24라면 5월 24일은 화요일이므로 문자열 TUE를 반환하세요.

제한 조건
2016년은 윤년입니다.
2016년 a월 b일은 실제로 있는 날입니다. (13월 26일이나 2월 45일같은 날짜는 주어지지 않습니다)
입출력 예
a	b	result
5	24	TUE

 */


fun main(arg: Array<String>) {
    println(calcYoil(2016, 1, 1))
    println(calcYoil(2016, 5, 1))
    println(calcYoil(2016, 5, 24))
    println(calcYoil(2016, 5, 31))
    println(calcYoil(2016, 6, 1))
    println(calcYoil(2016, 7, 6))
    println(calcYoil(2016, 6, 30))
    println(calcYoil(2017, 1, 1))
}
//
//fun solution(a: Int, b: Int): String {
//    return calcYoil(2016, a, b)
//}

fun calcYoil(y: Int, m: Int, d: Int): String {
    var yoils = arrayOf("FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU")

    var days = calcDays(y, m, d)
    if (days == -1) return "NONE"

    return yoils[(days % 7)]
}

fun calcDays(y: Int, m: Int, d: Int): Int {
    var months = arrayOf(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
    val start = 2016
    var days = 0

    if (start > y) return -1

    // year -> days
    if (y - start > 0) {
        for (i in 1..(y-start)) {
            days += 365
            if (isLeap(y+i)) days += 1
        }
    }

    // month -> days
    if (isLeap(y)) months[1] += 1
    for (i in 0 until (m-1)) {
        days += months[i]
    }

    return days + d -1
}

fun isLeap(y: Int): Boolean {
    return when {
        y%400 == 0 -> true
        y%100 == 0 -> false
        y%4 == 0 -> true
        else -> false
    }
}