package data_algorithm_test.rank_algorithm

import java.util.*


fun main(args: Array<String>) {
    var array = intArrayOf(3,5,1,8,6,2,4,7)


    println(Arrays.toString(mergeSort(array)))
    println(Arrays.toString(array))
}

fun mergeSort(array: IntArray): IntArray {
    var answer = array.copyOf()
    mergeSortImpl(answer, 0, answer.size-1)
    return answer
}

fun mergeSortImpl(array: IntArray, start: Int, end: Int) {
    if (start >= end) return

    var mid = (start + end) / 2

    mergeSortImpl(array, start, mid)
    mergeSortImpl(array, mid+1, end)

    merge(array, start, mid, mid+1, end)
}

fun merge(arr: IntArray,
          start1: Int, end1: Int,
          start2: Int, end2: Int) {
    var tempArr = IntArray(arr.size)
    var idx = 0

    var cursor1 = start1
    var cursor2 = start2

    while (cursor1 <= end1 && cursor2 <= end2) {
        if (arr[cursor1] <= arr[cursor2]) {
            tempArr[idx++] = arr[cursor1]
            cursor1++
        } else {
            tempArr[idx++] = arr[cursor2]
            cursor2++
        }
    }

    if (cursor1 <= end1) {
        for (i in cursor1..end1) {
            tempArr[idx++] = arr[i]
        }
    }
    if (cursor2 <= end2) {
        for (i in cursor2..end2) {
            tempArr[idx++] = arr[i]
        }
    }
    for (i in start1..end2) {
        arr[i] = tempArr[i-start1]
    }
}