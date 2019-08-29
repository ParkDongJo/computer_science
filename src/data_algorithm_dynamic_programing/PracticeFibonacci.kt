package data_algorithm_dynamic_programing

var memo = Array<Int>(1000, {i->-1})

fun main(args: Array<String>) {
//    println(fiboRecur(10))
    println(fiboBottomUp(10))
}

fun fiboRecur(n: Int): Int {
    if (n==1 || n==2) {
        return 1
    } else if (memo[n] > -1) {
        return memo[n]
    } else {
        memo[n] = fiboRecur(n-1) + fiboRecur(n-2)
        return memo[n]
    }
}

fun fiboBottomUp(n: Int): Int {
    memo[1] = 1
    memo[2] = 1

    for (i in 3..n) {
        memo[i] = memo[i-1] + memo[i-2]
    }

    return memo[n]
}