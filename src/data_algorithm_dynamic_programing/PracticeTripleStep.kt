package data_algorithm_dynamic_programing

// 코딩인터뷰 완전분석 책 문제

/*
    어떤 아이가 n개의 계단을 오른다. 한 번에 1계단 오르기도 하고, 2계단이나 3계단이나 오르기도 한다.
    계단을 오르는 방법이 몇가지가 있는지 계산하는 메서드를 구현하라
 */
fun main(args: Array<String>) {
    var n = 50
    println(climb(n, IntArray(n+1, {i->0})))
}

fun climb(n: Int, memo: IntArray): Int {
    if (n==0 || n==1) return 1
    if (n<0) return 0
    if (memo[n] != 0) {
        return memo[n]
    } else {
        memo[n] = climb(n-3, memo) + climb(n-2, memo) + climb(n-1, memo)
        return memo[n]
    }
}


// 책 정답 확인
/*
    일반적으로는 캐쉬를 HashMap을 사용한다고 한다.
    경우에 따라서 중복이 허용되지 않는 경우 HashSet을 활용하는 것도 좋은것 같다.

    다만, 여기에서는 키값이 정확하게 1~n까지 맞아 떨어져서
    공간적인 효율이 더 좋은 배열을 사용하는 것이 좋다.

    결론은 상황에 맞춰서
    배열 or HashMap or HashSet

 */
/*
    추가적인 팁!!!!!

    재귀를 동적계획법을 통해 성능개선을 하고 나면
    O(n)의 시간복잡도를 가지게 되면서
    10000의 단위는 밀리초단위로 연산수행하게 된다.
    즉, 더 큰 수도 거뜬히 계산할수 있다는 이야기이다.

    이때 n과 memo는 Int로 되어있다. 짧게 생각하면 그냥 long으로 바꿀수 있지만
    long도 금방 바닥나게 된다. 그때는 BigInteger로 대체하면 된다.
    이를 기억하고 있다가 인터뷰때 써먹자!
 */
fun solution(n: Int, memo: IntArray): Int {
    if (n<0) {
        return 0
    } else if (n==0) {
        return 1
    } else if (memo[n] > -1) {
        return memo[n]
    } else {
        memo[n] = solution(n-1, memo) + solution(n-2, memo) + solution(n-3, memo)
        return memo[n]
    }
}