package data_algorithm_test.common

fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(' ').map(String::toInt)
}

fun binarySearch(arr: IntArray, start: Int, end: Int, value: Int): Int {
    if (start > end) {
        return -1
    } else if (start == end) {
        when (arr[start] == value) {
            true -> return start
            false -> return -1
        }
    } else {

        val mid = (start+end)/2

        if (arr[mid] == value) {
            return mid
        } else if (arr[mid] > value) {
            return binarySearch(arr, start, mid-1, value)
        } else {
            return binarySearch(arr, mid+1, end, value)
        }
    }
}
