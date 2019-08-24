package data_algorithm_dfs_bfs

import data_structure_stack.Stack

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

    dfsByStack(graph, visited, 0)

    println()

    visited = Array(6, { i-> false})
    dfsByStack(graph, visited, 0)
}

fun dfsRecur(matrix: Array<Array<Int>>,
        visited: Array<Boolean>,
        cursor: Int) {

    visited[cursor] = true
    print("${cursor + 1} ")

    for ((i) in matrix.withIndex()) {
        if (matrix[cursor][i] == 1 && !visited[i]){
            dfsRecur(matrix, visited, i)
        }
    }
}

fun dfsByStack(matrix: Array<Array<Int>>,
               visited: Array<Boolean>,
               start: Int) {

    var stack = Stack()
    stack.push(start)
    visited[start] = true

    while (!stack.isEmpty()) {
        var vertex = stack.peek().toString().toInt()
        print("${vertex + 1} ")
        stack.pop()

        for ((i) in matrix.withIndex()) {
            if (matrix[vertex][i] == 1 && !visited[i]) {
                stack.push(i)
                visited[i] = true
            }
        }

    }

}