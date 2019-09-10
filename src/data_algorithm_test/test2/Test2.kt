package data_algorithm_test.test2

import java.util.*

/*

2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다.
    단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며,
    v는 빈 문자열이 될 수 있습니다.
3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
  3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
  4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
  4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
  4-3. ')'를 다시 붙입니다.
  4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
  4-5. 생성된 문자열을 반환합니다.
 */

fun main(args: Array<String>) {
//    println(solution("(()())()"))
//    println(solution("()))((()"))
//    println(solution(")("))
//    println(solution(")()()("))
//    println(solution("))))(((("))
//    println(solution("))))()(((("))
//    println(solution("))))()(((("))
//    println(solution("()()()"))
//    println(solution("((()))()(())"))
    println(solution(")))))(()(()((("))
}

fun solution(p: String): String {
    var answer = ""
    if (p.isEmpty()) return answer

    var stack = Stack<Char>()
    stack.push(p[0])
    var u = p[0].toString()
    var v = ""
    var idx = 1

    while (!stack.isEmpty()) {
        var top = stack.peek()


        if (top == ')' && p[idx] == '(' ||
                top == '(' && p[idx] == ')') {
            stack.pop()
        } else {
            stack.push(p[idx])

        }
        u += p[idx]
        idx++
    }
    v = p.substring(idx..(p.length-1))


    if (isRight(u)) {
        // 올바르면
        answer = solution(v)
        if(isRight(answer)) {

        }
        return u+answer
    } else {
        // 올바르지 않다면
        answer = "$answer($v)"
        answer += u.substring(1..(u.length-2))
                .replace("(", "_")
                .replace(")", "(")
                .replace("_", ")")
        return answer
    }

}

fun isRight(u: String): Boolean {
    if (u[0] != '(') return false

    var stack = Stack<Char>()

    for (c in u) {
        if (c == '(') stack.push(c) else stack.pop()
    }

    return stack.isEmpty()
}