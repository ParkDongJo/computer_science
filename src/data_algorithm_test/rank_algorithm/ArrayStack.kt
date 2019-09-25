package data_algorithm_test.rank_algorithm

class ArrayStack {
    private val MAX_SIZE = 100
    private var pArray: IntArray = IntArray(MAX_SIZE, {i -> -1})
    private var pSize: Int = 0

    var size: Int
        set(size) {
            this.pSize = size
        }
        get() = this.pSize

    fun top(): Int {
        if (isEmpty()) {
            return -1
        } else {
            return pArray[this.size-1]
        }
    }

    fun pop(): Int {
        if (isEmpty()) {
            return -1
        } else {
            return pArray[this.size-1].also { this.size-- }
        }
    }

    fun push(data: Int) {
        if (this.size == MAX_SIZE) {
            throw ArrayIndexOutOfBoundsException()
        } else {
            this.pArray[this.size++] = data
        }
    }

    fun isEmpty(): Boolean {
        return this.size == 0
    }

}