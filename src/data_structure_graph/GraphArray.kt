package data_structure_graph

fun main(args: Array<String>) {
    var graph = GraphArray(6)

    graph.insertEdge(1,2)
    graph.insertEdge(1,3)
    graph.insertEdge(2,3)
    graph.insertEdge(2,4)
    graph.insertEdge(3,4)
    graph.insertEdge(3,5)
    graph.insertEdge(4,5)
    graph.insertEdge(4,6)

    graph.print()
}

class GraphArray {
    private var _matrix: Array<Array<Int>>
    private var _array: IntArray

    private var _cursor = 0
    var cursor: Int
        get() = this._cursor
        set(i: Int) { this._cursor = i}

    constructor(size: Int) {
        this._matrix = Array<Array<Int>>(size, {Array<Int>(size, {i->0})})
        this._array = IntArray(size)
    }

    fun getVertex(i: Int): Array<Int> {
        return this._matrix[i]
    }

    fun insertVertex(x: Int): Unit {
        this._array[this._cursor++] = x
    }

    fun insertEdge(x: Int, y: Int): Boolean {
        var success: Boolean = true

        if (this._array.filter{it==x}.isEmpty()) {
            this.insertVertex(x)
        }
        if (this._array.filter{it==y}.isEmpty()) {
            this.insertVertex(y)
        }

        this._matrix[x-1][y-1] = 1
        this._matrix[y-1][x-1] = 1
        return success

    }

    fun print(): Unit {
        for (arr in this._matrix) {
            println()
            for (e in arr) {
                print("$e ,")
            }
        }
    }

}