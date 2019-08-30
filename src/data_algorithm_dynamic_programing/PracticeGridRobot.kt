package data_algorithm_dynamic_programing

import java.lang.Exception
import java.util.*

// 코딩인터뷰 완전분석 책 문제

/*
    행의 개수는 r, 열의 개수는 c인 격자판의 왼쪽상단 꼭짓점에 로봇이 놓여있다고 상상해 보자
    이 로봇은 오른쪽 아니면 아래쪽으로만 이동할 수 있다.

    하지만 어떤 셀(cell)은 '금지구역'으로 지정되어 있어서 로봇이 접근할 수 없다. 왼쪽 상단
    꼭짓점에서 오른쪽 하단 꼭짓점으로의 경로를 찾는 알고리즘을 설계하라


 */
/*
    중복 지점을 찾는다.

 */

fun main(args: Array<String>) {
    var matrix = arrayOf(
            booleanArrayOf(true, false, true, false, false, true),
            booleanArrayOf(true, true, true, true, true, true),
            booleanArrayOf(false, true, false, false, true, true),
            booleanArrayOf(true, true, true, false, true, false),
            booleanArrayOf(false, true, false, false, true, false),
            booleanArrayOf(false, true, true, true, true, true))

    var paths = solution(matrix)

    for (p in paths) {
        print("(${p.row} , ${p.col}) -> ")
    }
}

fun solution(matrix: Array<BooleanArray>): ArrayList<Point> {
    var paths = ArrayList<Point>()
    var failedPoints = HashSet<Point>()

    findPath(matrix, matrix.size-1, matrix.size-1, paths, failedPoints)

    return paths
}

fun findPath(matrix: Array<BooleanArray>,
             row: Int,
             col: Int,
             path: ArrayList<Point>,
             failedPoints: HashSet<Point>): Boolean {

    if (row<0 || col<0 || !matrix[row][col]) {
        return false
    }

    val p = Point(row, col)

    // 이미 지났고 통과하지 못했다면,
    // 추가 탐색 필요없이 바로 false를 보낸다.
    if (failedPoints.contains(p)) {
        return false
    }

    var isOrigin = (row == 0) && (col == 0)

    if (isOrigin ||
            findPath(matrix, row, col-1, path, failedPoints) ||
            findPath(matrix, row-1, col, path, failedPoints)) {
        var point = Point(row,col)
        path.add(point)
        return true
    }

    // 여기까지 왔다는건 해당 포지션은
    // 통과하지 못했다는 의미이다.
    failedPoints.add(p)
    return false
}

class Point {
    var row: Int
    var col: Int

    constructor() {
        this.row = 0
        this.col = 0
    }

    constructor(_row: Int, _col: Int) {
        this.row = _row
        this.col = _col
    }
}
