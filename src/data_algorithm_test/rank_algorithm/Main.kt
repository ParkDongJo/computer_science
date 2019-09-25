package data_algorithm_test.rank_algorithm

fun main(args: Array<String>) {
    var queue = LinkedQueue()
    var stack = ArrayStack()

    queue.enqueue(1)
    queue.enqueue(2)
    queue.enqueue(3)

    println(queue.dequeue())
    println(queue.dequeue())
    println(queue.size)

    stack.push(1)
    stack.push(2)
    stack.push(3)

    println(stack.pop())
    println(stack.pop())
    println(stack.size)

}