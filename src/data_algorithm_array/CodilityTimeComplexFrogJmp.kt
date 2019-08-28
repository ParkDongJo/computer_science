package data_algorithm_array

/**
A small frog wants to get to the other side of the road. The frog is currently located at position X and wants to get to a position greater than or equal to Y. The small frog always jumps a fixed distance, D.

Count the minimal number of jumps that the small frog must perform to reach its target.

Write a function:

class Solution { public int solution(int X, int Y, int D); }

that, given three integers X, Y and D, returns the minimal number of jumps from position X to a position equal to or greater than Y.

For example, given:

X = 10
Y = 85
D = 30
the function should return 3, because the frog will be positioned as follows:

after the first jump, at position 10 + 30 = 40
after the second jump, at position 10 + 30 + 30 = 70
after the third jump, at position 10 + 30 + 30 + 30 = 100
Write an efficient algorithm for the following assumptions:

X, Y and D are integers within the range [1..1,000,000,000];
X ≤ Y.

 */

/*
    [ 알면 좋을 것 ]

 */
/*
    [ 문제 풀이 ]
    코딜리티에서 평가

    The following issues have been detected: timeout errors.
    For example, for the input (5, 1000000000, 2) the solution exceeded the time limit.

    타임 제한 때문이다.

    문제에는 전혀 제한이 없지만,
    코딜리티는 성능 체크까지 한다..
    일단 조건에 1000000000가 넘어가는 문제라면
    이런 시간 제한을 의심하고
    최대한 코드의 효율성을 체크하자!!
 */

fun main(args: Array<String>) {
    println(solution(10, 85, 30))
}

//fun solution(X: Int, Y: Int, D: Int): Int {
//    var x = X
//    var count = 0
//
//    while (x < Y) {
//        x += D
//        count++
//    }
//
//    return count
//}

fun solution(X: Int, Y: Int, D: Int): Int {
    var count = (Y - X) / D

    if ((Y - X) % D == 0) {
        return count
    } else {
        return count + 1
    }

    return count
}