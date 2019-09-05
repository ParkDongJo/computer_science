package data_algorithm_test.common

import data_structure_queue.Queue
import data_structure_stack.Stack

fun main(args: Array<String>) {

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

fun dfs(matrix: Array<Array<Int>>,
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