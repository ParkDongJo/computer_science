package data_algorithm_test.common

fun main(args: Array<String>) {
    // 코딩 테스트에서는 아래와 같이
    // sort() 메서드를 사용하자
    // 내부적으로 O(n*logN) 시간복잡도를 가지는 알고리즘이
    // 구현되어 있다.
    var A = intArrayOf(4,2,5,1)
    A.sort()
    A.reverse()
}

/**
 * quick sort
 */
fun quickSort(arr: IntArray, start: Int, end: Int) {
    if (start >= end) {
        return
    }

    var left = IntArray(100)
    var right = IntArray(100)
    val pivot = arr[start]

    var leftCnt = getLeft(arr, start+1, end, pivot, left)
    var rightCnt = getRight(arr, start+1, end, pivot, right)

    for (i in 0 until leftCnt) {
        arr[start + i] = left[i]
    }
    arr[start + leftCnt] = pivot
    for (i in 0 until rightCnt) {
        arr[start + leftCnt + 1 +i] = right[i]
    }

    quickSort(arr, start, start+leftCnt-1)
    quickSort(arr, start+leftCnt+1, end)
}

fun getLeft(arr: IntArray, start: Int, end: Int, pivot: Int, left: IntArray): Int {
    var idx = 0
    for (i in start..end) {
        if (pivot >= arr[i]) {
            left[idx++] = arr[i]
        }
    }
    return idx
}

fun getRight(arr: IntArray, start: Int, end: Int, pivot: Int, right: IntArray): Int {
    var idx = 0
    for (i in start..end) {
        if (pivot < arr[i]) {
            right[idx++] = arr[i]
        }
    }
    return idx
}


/**
 * merge sort
 */
fun mergeSort(arr: IntArray, start: Int, end: Int) {
    if (start >= end) {
        return
    }
    var mid = (start + end) / 2

    mergeSort(arr, start, mid)
    mergeSort(arr, mid+1, end)

    merge(arr, start, mid, mid+1, end)
}

fun merge(arr: IntArray, start1: Int, end1: Int, start2: Int, end2: Int) {
    var temp = IntArray(100)
    var idx = 0

    var cursor1 = start1
    var cursor2 = start2

    while (cursor1 <= end1 && cursor2 <= end2) {
        if (arr[cursor1] <= arr[cursor2]) {
            temp[idx++] = arr[cursor1]
            cursor1++
        } else {
            temp[idx++] = arr[cursor2]
            cursor2++
        }
    }

    if (cursor1 <= end1) {
        for (i in cursor1..end1) {
            temp[idx++] = arr[i]
        }
    }

    if (cursor2 <= end2) {
        for (i in cursor2..end2) {
            temp[idx++] = arr[i]
        }
    }

    for (i in start1..end2) {
        arr[i] = temp[i-start1]
    }

}

/*
    선택 정렬
 */

/*
    버블 정렬
 */

/*
    삽입 정렬
 */