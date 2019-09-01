package data_structure_stack

/**
A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:

S is empty;
S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
S has the form "VW" where V and W are properly nested strings.
For example, the string "{[()()]}" is properly nested but "([)()]" is not.

Write a function:

class Solution { public int solution(String S); }

that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.

For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]",
the function should return 0, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..200,000];
string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".
 */

fun main(args: Array<String>) {
    println(solution("{[()()]}"))
    println(solution("([)()]"))
}

// 걸린 시간 : 33 min
// Stack을 직접 구현하고 문제풀이를 하는데는 확실히 시간이 걸리긴 한다.
// 하지만 스텍에 이미 기본적인 예외처리나
// 스펙이 머릿속에 그려지면서 문제풀이가 가능하기 때문에
// 더 좋을수는 있다.
fun solution(S: String): Int {

    val stack = Stack()

    for (c in S) {
        if (c=='[' || c=='{' || c=='(') {
            stack.push(c)
        } else {
            val top = stack.peek()

            when(c) {
                ')'->{ if (top=='(') stack.pop() else return 0 }
                '}'->{ if (top=='{') stack.pop() else return 0 }
                ']'->{ if (top=='[') stack.pop() else return 0 }
            }
        }
    }

    if (stack.isEmpty()) {
        return 1
    } else {
        return 0
    }
}


//interface StackImpl {
//    fun isEmpty(): Boolean
//    fun size(): Int
//    fun push(item: Any)
//    fun pop(): Any?
//    fun peek(): Any?
//}
//
//class Stack: StackImpl, Iterator<Any> {
//    var list: MutableList<Any> = mutableListOf()
//    override fun isEmpty(): Boolean =list.isEmpty()
//    override fun size() = list.size
//    override fun peek(): Any? = list.lastOrNull()
//    override fun pop(): Any? {
//        val item = list.lastOrNull()
//        if(!isEmpty()) {
//            list.removeAt(list.size-1)
//        }
//        return item
//    }
//    override fun push(item: Any) { list.add(item) }
//    override operator fun hasNext() = list.iterator().hasNext()
//    override operator fun next() = list.iterator().next()
//}