package data_algorithm_test.common

fun main(args: Array<String>) {
}

fun checkPrime(num: Int): Boolean {
    var result = true

    for (i in 1..num) {
        if (num % i == 0 && (i != 1 && i == num)) {
            result = false
        }
    }

    return result
}