package data_algorithm_dfs_bfs

import data_structure_queue.Queue

fun main(args: Array<String>) {
    // 배열로 그래프 표현
    /*
        1 - 2 - 3
        |   |
        4 - 5
        |
        6
        위와 같은 그래프 구조가 있다고 가졍
     */
    var graph: Array<Array<Int>> = arrayOf(
            arrayOf(0, 1, 0, 1, 0, 0),
            arrayOf(1, 0, 1, 0, 1, 0),
            arrayOf(0, 1, 0, 0, 0, 0),
            arrayOf(1, 0, 0, 0, 1, 1),
            arrayOf(0, 1, 0, 1, 0, 0),
            arrayOf(0, 0, 0, 1, 0, 0)
    )
    var visited: Array<Boolean> = Array(6, { i-> false})

    bfs(graph, visited, 0)
}

fun bfs(matrix: Array<Array<Int>>,
        visited: Array<Boolean>,
        start: Int) {

    var queue = Queue()
    queue.enqueue(start)
    visited[start] = true

    while (!queue.isEmpty()) {
        var vertex = queue.dequeue().toString().toInt()
        print("${vertex + 1} ")

        for ((i) in matrix.withIndex()) {
            if (matrix[vertex][i] == 1 && !visited[i]) {
                queue.enqueue(i)
                visited[i] = true
            }
        }
    }
}