package data_algorithm_test.common

fun main(args: Array<String>) {

}

fun euclid(a: Int, b: Int): Int {
    if (b == 0) {
        return a
    }
    return euclid(b, a%b)
}
