package data_algorithm_test.rank_algorithm

class LinkedQueue {
    private var pList = LinkedList()
    private var pSize = 0
//    private var pHead = null
//    private var pTail = null

    val size get() = this.pSize

    fun peek(): Int? {
        if (isEmpty()) {
            return null
        } else {
            return this.pList.head?.value
        }
    }

    fun enqueue(data: Int) {
        this.pList.add(data)
        this.pSize++
    }

    fun dequeue(): Int {
        if (isEmpty()) {
            throw ArrayIndexOutOfBoundsException()
        } else {
            val data = this.pList.head!!.value

            this.pList.delete(0)

            this.pSize--
            return data
        }
    }

    fun isEmpty(): Boolean {
        return this.size == 0
    }
}