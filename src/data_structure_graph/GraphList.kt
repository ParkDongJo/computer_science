package data_structure_graph

fun main(args: Array<String>) {
    var graph = GraphList(6)
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

class GraphList {
    private var _graph = ArrayList<ArrayList<Int>>()

    private var _size: Int = 0
    var size: Int
        get() = this._size
        set(size: Int) { this._size = size}


    constructor(size: Int) {
        this._size = size

        var list: ArrayList<Int>
        for(i in 0..(size-1)) {
            list = ArrayList<Int>()
            list.add(i)

            this._graph.add(list)
        }
    }

    fun getVertex(i: Int): ArrayList<Int> {
        return this._graph[i]
    }

    fun insertVertex(x: Int): Unit {
        var list = ArrayList<Int>()

        list.add(x)
        this._graph.add(list)
        this._size++
    }

    fun insertEdge(x: Int, y: Int): Unit {
        var isSuccess: Boolean = false
        for(list in this._graph) {
            if (list[0] == x) {
                list.add(y)
                isSuccess = true
            }
        }

        if (!isSuccess) {
            var list = ArrayList<Int>()
            list.add(x)
            list.add(y)

            this._graph.add(list)
        }
    }

    fun print(): Unit {
        for ((idx, vList) in this._graph.withIndex()) {
            if (idx != 0 && vList.size > 0) {
                print("vertex ${vList[0]} 의 인접리스트")

                for (v in vList) {
                    print("-> $v")
                }
                println("")
            }
        }
    }
}