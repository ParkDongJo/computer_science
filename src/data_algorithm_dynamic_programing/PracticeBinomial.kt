package data_algorithm_dynamic_programing

fun main(args: Array<String>) {
    binomial(10, 5)
}

fun binomial(n: Int, k: Int): Int {
    if (n == k || k == 0) {
        return 1
    } else {
        return binomial(n-1, k) + binomial(n-1, k-1)
    }
}
