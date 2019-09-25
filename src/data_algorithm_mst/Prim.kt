package data_algorithm_mst

import java.util.*
import kotlin.Comparator

val NODE_MAX = 1001

fun main(args: Array<String>) {
    var graph = arrayOf(
            intArrayOf(NODE_MAX, 1, 6, 7, 5),
            intArrayOf(1, NODE_MAX, 2, 9, 8),
            intArrayOf(6, 2, NODE_MAX, 3, 10),
            intArrayOf(7, 9, 3, NODE_MAX, 4),
            intArrayOf(5, 8, 10, 4, NODE_MAX)
            )
    var start = 0
    var cp = Comp()
    var pQueue = PriorityQueue<Edge>(cp)
    var MST = mutableListOf<Edge>()

    prim(graph, start, pQueue, MST)

    for (e in MST) {
        println(e.weight)
    }
}

fun prim(graph: Array<IntArray>,
         start: Int,
         pQueue: PriorityQueue<Edge>,
         MST: MutableList<Edge>): MutableList<Edge> {

    if(MST.size == graph[0].size) return MST

    for ((i, w) in graph[start].withIndex()) {
        if (w != NODE_MAX) {
            pQueue.add(Edge(start, i, w))
        }
    }
    var edge = pQueue.poll()
    var next = edge.end
    graph[start][next] = NODE_MAX
    graph[next][start] = NODE_MAX
    MST.add(edge)

    return prim(graph, next, pQueue, MST)
}

class Comp: Comparator<Edge> {
    override fun compare(o1: Edge?, o2: Edge?): Int {
        return if (o1!!.weight > o2!!.weight) 1 else -1
    }
}