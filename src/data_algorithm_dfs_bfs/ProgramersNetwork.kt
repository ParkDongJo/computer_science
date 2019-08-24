package data_algorithm_dfs_bfs

/**
    [ 문제 설명 ]
    네트워크란 컴퓨터 상호 간에 정보를 교환할 수 있도록 연결된 형태를 의미합니다.
    예를 들어, 컴퓨터 A와 컴퓨터 B가 직접적으로 연결되어있고,
    컴퓨터 B와 컴퓨터 C가 직접적으로 연결되어 있을 때 컴퓨터 A와 컴퓨터 C도 간접적으로 연결되어 정보를 교환할 수 있습니다.
    따라서 컴퓨터 A, B, C는 모두 같은 네트워크 상에 있다고 할 수 있습니다.

    컴퓨터의 개수 n, 연결에 대한 정보가 담긴 2차원 배열 computers가 매개변수로 주어질 때,
    네트워크의 개수를 return 하도록 solution 함수를 작성하시오.

    [ 제한사항 ]
    컴퓨터의 개수 n은 1 이상 200 이하인 자연수입니다.
    각 컴퓨터는 0부터 n-1인 정수로 표현합니다.
    i번 컴퓨터와 j번 컴퓨터가 연결되어 있으면 computers[i][j]를 1로 표현합니다.
    computer[i][i]는 항상 1입니다.

    [ 입출력 예 ]
    n	computers	return
    3	[[1, 1, 0], [1, 1, 0], [0, 0, 1]]	2
    3	[[1, 1, 0], [1, 1, 1], [0, 1, 1]]   1
    4   [[1,0,0,1],[0,1,1,1],[0,1,1,0],[1,1,0,1]]  1
 */

    /*
        [ 알아두면 좋을 것들 ]


     */

    /*
        [ 문제에 대한 해설 ]

     */

fun main(args: Array<String>) {
    println(solution(3, arrayOf(intArrayOf(1,1,0),intArrayOf(1,1,0),intArrayOf(0,0,1))))
    println(solution(3, arrayOf(intArrayOf(1,1,0),intArrayOf(1,1,1),intArrayOf(0,1,1))))
    println(solution(4, arrayOf(intArrayOf(1,0,0,1),intArrayOf(0,1,1,1),intArrayOf(0,1,1,0),intArrayOf(1,1,0,1))))
}

fun solution(n: Int, computers: Array<IntArray>): Int {
    var answer = 0
    var visited: Array<Boolean> = Array(n, { i-> false})

    for ((i, e) in visited.withIndex()) {

        if (!e) {
            dfs(computers, visited, i)
            answer++
        }
    }

    return answer
}

fun dfs(matrix: Array<IntArray>,
        visited: Array<Boolean>,
        cursor: Int) {

    visited[cursor] = true

    for ((i) in matrix.withIndex()) {
        if (matrix[cursor][i] == 1 && !visited[i]){
            dfs(matrix, visited, i)
        }
    }
}
