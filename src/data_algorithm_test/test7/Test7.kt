package data_algorithm_test.test7


fun main(args: Array<String>) {

}

fun mergeSort(array: IntArray): IntArray {
    var answer = array.copyOf()
    mergeSortImpl(answer, 0, answer.size-1)
    return answer
}

fun mergeSortImpl(array: IntArray, start: Int, end: Int) {
    if (start <= end) return

    var mid = (start + end) /2

    mergeSortImpl(array, start, mid)
    mergeSortImpl(array, mid+1, end)

    merge(array, start, mid, mid+1, end)
}

fun merge(array: IntArray,
          start1: Int, end1: Int,
          start2: Int, end2: Int) {
    var tempArr = IntArray(array.size)
    var idx = 0

    var cursor1 = start1
    var cursor2 = start2

    while(cursor1 <= end1 && start2 <= end2) {
        if (array[cursor1] <= array[cursor2]) {
            tempArr[idx++] = array[cursor1]
            cursor1++
        } else {
            tempArr[idx++] = array[cursor2]
            cursor2++
        }
    }

    if (cursor1 <= end1) {
        for (i in cursor1..end1) {
            tempArr[idx++] = array[i]
        }
    }
    if (cursor2 <= end2) {
        for (i in cursor2..end2) {
            tempArr[idx++] = array[i]
        }
    }
    for (i in start1..end2) {
        array[i] = tempArr[i-start1]
    }
}