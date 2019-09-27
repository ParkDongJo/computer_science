package data_algorithm_test.test6


fun main(args: Array<String>) {

}

fun quickSort(array: IntArray): IntArray {
    var answer = array.copyOf()
    quickSortImpl(answer, 0, answer.size-1)
    return answer
}

fun quickSortImpl(array: IntArray, start: Int, end: Int) {
    if (start >= end) return

    var left = IntArray(100)
    var right = IntArray(100)
    var pivot = start

    var leftCnt = getLeft(array, left, start+1, end, pivot)
    var righttCnt = getRight(array, right, start+1, end, pivot)

    for (i in 0 until leftCnt) {
        array[start+i] = left[i]
    }
    array[start+leftCnt] = pivot
    for (i in 0 until righttCnt) {
        array[start+i+leftCnt] = right[i]
    }

    quickSortImpl(array, start, start+leftCnt-1)
    quickSortImpl(array, start+leftCnt+1, end)
}


fun getLeft(array: IntArray, left: IntArray,
            start: Int, end: Int, pivot: Int): Int {
    var idx = 0
    for (i in start..end) {
        if (pivot >= array[i]) left[idx++] = array[i]
    }
    return idx
}

fun getRight(array: IntArray, right: IntArray,
             start: Int, end: Int, pivot: Int): Int {
    var idx = 0
    for (i in start..end) {
        if (pivot < array[i]) right[idx++] =array[i]
    }
    return idx
}