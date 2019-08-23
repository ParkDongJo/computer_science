package data_algorithm_string


/*
    [ 문제 설명 ]
    단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요. 단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.

    [ 재한사항 ]
    s는 길이가 1 이상, 100이하인 스트링입니다.

    [ 입출력 예 ]
    s	return
    abcde	c
    qwer	we
 */

fun main(args: Array<String>) {
    println(solutionOfMidChar("abcde"))
    println(solutionOfMidChar("qwer"))

//    val allColours = arrayOf('a', 'c', 'b', 'd', 'z')
//    println(Arrays.toString(allColours.sliceArray(0..2)))
}

fun solutionOfMidChar(s: String): String {
    var answer = ""
    var cArr = s.toCharArray()
    var mid: Int = s.length/2

    when (s.length%2) {
        0 -> {
            answer = String(cArr.sliceArray(mid-1..mid))
        }
        1 -> {
            answer = cArr[mid].toString()
        }
    }
    return answer
}