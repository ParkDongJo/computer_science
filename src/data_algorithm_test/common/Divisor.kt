package data_algorithm_test.common

import kotlin.math.sqrt


fun main(args: Array<String>) {

}

fun getDivsor(N: Int): IntArray {
    var divArr = ArrayList<Int>()
    var sqrtN = sqrt(N.toDouble()).toInt()

    for (i in 1..sqrtN) {
        if (N%i == 0) {
            divArr.add(i)
            divArr.add(N/i)
        }
    }

    divArr.sort()

    return divArr.toIntArray()
}