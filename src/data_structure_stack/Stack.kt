package data_structure_stack

interface StackBase {
    fun isEmpty(): Boolean    // 스택이 빈 경우 true 리턴
    fun size(): Int         // 스택에 있는 요소들의 수를 리턴
    fun push(item: Any)      // item을 push, unit 리턴
    fun pop(): Any?         // 스택에서 item을 빼서 리턴, 스택이 빈 경우 null 리턴
    fun peek(): Any?        // 스택의 top에 있는 item을 pop 하지 않고 리턴,
}

class Stack: StackBase, Iterator<Any> {
    var stack: MutableList<Any> = mutableListOf()

    override fun isEmpty() = stack.isEmpty()

    override fun size() = stack.size

    override fun peek(): Any? = stack.lastOrNull()

    override fun pop(): Any? {
        val item = stack.lastOrNull()
        if(!isEmpty()){
            stack.removeAt(stack.size - 1)
        }
        return item
    }
    override fun push(item: Any){
        stack.add(item)
    }

    override operator fun hasNext() = stack.iterator().hasNext()

    override operator fun next() = stack.iterator().next()
}

fun main(args: Array<String>) {
    val list = List(20) { it + 1 }
    val s = Stack()

    for (e in list) {
        s.push(e)
    }

    println(s.size())
    for (item in s)
        print("${s.pop()} ")
}