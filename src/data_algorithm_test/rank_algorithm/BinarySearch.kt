package data_algorithm_test.rank_algorithm

import java.util.*

fun main(args: Array<String>) {
    var arr = intArrayOf(1,8,4,6,9,3,2,5,7)
    arr.sort()

    println(Arrays.toString(arr))
    println(binarySearch(arr, 0, arr.size-1, 4))
    println(binarySearch(arr, 0, arr.size-1, 10))
}

fun binarySearch(arr: IntArray,
                 start: Int, end: Int, value: Int): Int {
    if (start > end) {
        return -1
    } else if (start == end) {
        return when (arr[start] == value) {
            true -> value
            false -> -1
        }
    } else {
        val mid = (start+end) / 2

        if (arr[mid] == value) {
            return mid
        } else if (arr[mid] > value) {
            return binarySearch(arr, start, mid-1, value)
        } else {
            return binarySearch(arr, mid+1, end, value)
        }
    }
}