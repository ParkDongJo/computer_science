package data_algorithm_test.common

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
    private var head: Node? = null
    private var tail: Node? = null
    private var cursor: Node? = null
    private var size: Int = 0

    fun add(data: Int) {
        if (isEmpty()) {
            this.head = Node(data)
            this.tail = this.head
            this.cursor = this.head
        } else {
            var node = Node(data)
            node.prevNode = this.tail
            this.tail!!.nextNode = node
            this.tail = node
        }

        this.size++
    }

    fun delete(idx: Int): Boolean {
        var isSuccess = false

        if (isEmpty()) {
            isSuccess = false
        } else if (idx >= size) {
            isSuccess = false
        } else if (idx == 0) {
            this.head!!.nextNode!!.prevNode = null
            this.cursor = this.head!!.nextNode
            this.head!!.nextNode = null
            isSuccess = true
        } else {
            for (i in 0 until size) {
                if (i == idx) {
                    this.cursor!!.prevNode!!.nextNode = this.cursor?.nextNode
                    this.cursor!!.nextNode = null
                    this.cursor!!.prevNode = null
                    this.size--
                    break
                }
                this.cursor = this.cursor?.nextNode
            }
            this.cursor = this.head
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
                    result = this.cursor!!.value
                    break
                }
                this.cursor = this.cursor?.nextNode
            }
            this.cursor = this.head
        }

        return result
    }

    fun isEmpty(): Boolean {
        return this.head == null
    }

    fun print() {
        if (isEmpty()) {
            println("[]")
        } else {
            print("[")
            while (this.cursor!!.nextNode != null) {
                if(this.cursor != this.head) print(",")
                print("${this.cursor!!.value}")
                this.cursor = this.cursor?.nextNode
            }
            this.cursor = this.head
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