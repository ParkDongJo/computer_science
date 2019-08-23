package data_structure_queue

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

fun main(args: Array<String>) {
    val list = List(20) { it + 1 }
    val q = Queue()

    for (e in list) {
        q.enqueue(e)
    }

    println(q.size())
    for (item in q)
        print("${q.dequeue()} ")
}