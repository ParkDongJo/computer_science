package data_algorithm_test.rank_algorithm

import java.lang.IndexOutOfBoundsException

fun main(args: Array<String>) {
    var list = LinkedList()
    list.add(1)
    list.add(2)
    list.add(3)
    list.add(4)
    list.print()
    println()

    list.delete(2)
    list.delete(3)
    list.print()
    println()

    println(list.get(1))
}


class LinkedList {
    private var pHead: Node? = null
    private var pTail: Node? = null
    private var pCursor: Node? = null
    private var pSize: Int = 0

    val head: Node? get() = this.pHead
    val tail: Node? get() = this.pTail
    val size: Int get() = this.pSize

    fun add(data: Int) {
        if (isEmpty()) {
            this.pHead = Node(data)
            this.pTail = this.pHead
            this.pCursor = this.pHead
        } else {
            var node = Node(data)
            node.prevNode = this.pTail
            this.pTail!!.nextNode = node
            this.pTail = node
        }

        this.pSize++
    }

    fun delete(idx: Int): Boolean {
        var isSuccess = false

        if (isEmpty()) {
            isSuccess = false
        } else if (idx >= size) {
            isSuccess = false
        } else if (idx == 0) {
            this.pHead!!.nextNode!!.prevNode = null
            this.pCursor = this.pHead!!.nextNode
            this.pHead!!.nextNode = null
            this.pHead = this.pCursor
            isSuccess = true
        } else {
            for (i in 0 until size) {
                if (i == idx) {
                    this.pCursor!!.prevNode!!.nextNode = this.pCursor?.nextNode
                    this.pCursor!!.nextNode = null
                    this.pCursor!!.prevNode = null
                    this.pSize--
                    break
                }
                this.pCursor = this.pCursor?.nextNode
            }
            this.pCursor = this.pHead
            isSuccess = true
        }

        return isSuccess
    }

    fun get(idx: Int): Int {
        var result = -1

        if (isEmpty()) {
            throw IndexOutOfBoundsException()
        } else if (idx >= size) {
            throw IndexOutOfBoundsException()
        } else {
            for (i in 0 until size) {
                if (i == idx) {
                    result = this.pCursor!!.value
                    break
                }
                this.pCursor = this.pCursor?.nextNode
            }
            this.pCursor = this.pHead
        }

        return result
    }

    fun isEmpty(): Boolean {
        return this.pHead == null
    }

    fun print() {
        if (isEmpty()) {
            println("[]")
        } else {
            print("[")
            while (this.pCursor!!.nextNode != null) {
                if(this.pCursor != this.pHead) print(",")
                print("${this.pCursor!!.value}")
                this.pCursor = this.pCursor?.nextNode
            }
            this.pCursor = this.pHead
            print("]")
        }
    }
}


class Node {
    private var data: Int = 0
    private var prev: Node? = null
    private var next: Node? = null

    constructor(data: Int) {
        this.data = data
    }

    var value: Int
        set(data) {
            this.data = data
        }
        get() = this.data

    var prevNode: Node?
        set(node) {
            this.prev = node
        }
        get() = this.prev

    var nextNode: Node?
        set(node) {
            this.next = node
        }
        get() = this.next
}