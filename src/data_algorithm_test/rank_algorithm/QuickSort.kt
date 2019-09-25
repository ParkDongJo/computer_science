package data_algorithm_test.rank_algorithm

import java.util.*

fun main(args: Array<String>) {
    var array = intArrayOf(3,5,1,8,6,2,4,7)
    println(Arrays.toString(quickSort(array)))
    println(Arrays.toString(array))
}

fun quickSort(array: IntArray): IntArray {
    var answer = array.copyOf()
    quickSortImpl(answer, 0, answer.size-1)
    return answer
}

fun quickSortImpl(arr: IntArray, start:Int, end:Int) {
    if (start >= end) return

    var left = IntArray(arr.size)
    var right = IntArray(arr.size)
    val pivot = arr[start]

    var leftCnt = getLeft(arr, left, start+1, end, pivot)
    var rightCnt = getRight(arr, right, start+1, end, pivot)

    for (i in 0 until leftCnt) {
        arr[start + i] = left[i]
    }
    arr[start+leftCnt] = pivot
    for (i in 0 until rightCnt) {
        arr[start + leftCnt + 1 + i] = right[i]
    }

    quickSortImpl(arr, start, start+leftCnt-1)
    quickSortImpl(arr, start+leftCnt+1, end)
}

fun getLeft(arr: IntArray, left: IntArray,
            start: Int, end: Int, pivot: Int): Int {
    var idx = 0
    for (i in start..end) {
        if (pivot >= arr[i]) left[idx++] = arr[i]
    }
    return idx
}

fun getRight(arr: IntArray, right: IntArray,
             start: Int, end: Int, pivot: Int): Int {
    var idx = 0
    for (i in start..end) {
        if (pivot < arr[i]) right[idx++] = arr[i]
    }
    return idx
}