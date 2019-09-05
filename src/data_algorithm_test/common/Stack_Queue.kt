package data_algorithm_test.common

import java.util.*
import java.util.Stack

fun main(args: Array<String>) {

    // 하지만 알고리즘 테스트에서는
    // java의 Stack을 쓸것을 추천한다.
    var stack = Stack<Int>()

    // 하지만 알고리즘 테스트에서는
    // 아래와 같이 사용할 것을 추천한다.
    var queue = mutableListOf<Int>()

    var pQueue = PriorityQueue<Int>()

    pQueue.add(1)
    pQueue.add(2)
    pQueue.add(3)

    pQueue.poll()

    val itr = pQueue.iterator()
    while (itr.hasNext())
        println(itr.next())

}

/**
 * Stack
 */
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


/**
 * Queue
 */
interface QueueBase {
    fun isEmpty(): Boolean    // 스택이 빈 경우 true 리턴
    fun size(): Int         // 스택에 있는 요소들의 수를 리턴
    fun enqueue(item: Any)      // item을 push, unit 리턴
    fun dequeue(): Any?         // 스택에서 item을 빼서 리턴, 스택이 빈 경우 null 리턴
    fun peek(): Any?        // 스택의 top에 있는 item을 pop 하지 않고 리턴,
}

class Queue: QueueBase, Iterator<Any> {

    var queue: MutableList<Any> = mutableListOf()

    override fun isEmpty(): Boolean = queue.isEmpty()

    override fun size():Int = queue.count()

    override  fun toString() = queue.toString()

    override fun enqueue(element: Any){
        queue.add(element)
    }

    override fun dequeue(): Any? {
        val item = queue[0]
        if(!isEmpty()){
            queue.removeAt(0)
        }
        return item
    }

    override fun peek():Any?{
        return queue[0]
    }

    override operator fun hasNext() = queue.iterator().hasNext()

    override operator fun next() = queue.iterator().next()
}