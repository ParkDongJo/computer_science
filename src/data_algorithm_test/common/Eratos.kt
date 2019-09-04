package data_algorithm_test.common

import java.util.*

fun main(args: Array<String>) {
//    println(useEratos(50))
    println(Arrays.toString(getPrimeArrByEratos(10)))
}

fun useEratos(n: Int): Int {
    var isPrime = BooleanArray(n+1, {it->true})
    var idx: Int

    for (i in 2..n) {

        for (j in i until n step i) {
            if (j!=i) {
                isPrime[j] = false
            }
        }
    }

    var count = 0
    for (i in 2..n) {
        if (isPrime[i]) {
            count++
        }
    }

    return count
}

fun getPrimeArrByEratos(n: Int): IntArray {
    var isPrime = BooleanArray(n+1, {true})
    var primeArr = ArrayList<Int>()

    for (i in 2..n) {

        for (j in i..n step i) {
            if (j!=i) {
                isPrime[j] = false
            }
        }
    }

    for (i in 2..n) {
        if (isPrime[i]) {
            primeArr.add(i)
        }
    }

    return primeArr.toIntArray()
}