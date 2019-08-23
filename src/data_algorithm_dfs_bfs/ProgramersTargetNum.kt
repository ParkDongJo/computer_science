package data_algorithm_dfs_bfs

/*

    [ 문제 설명 ]
    n개의 음이 아닌 정수가 있습니다. 이 수를 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다. 예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.

    -1+1+1+1+1 = 3
    +1-1+1+1+1 = 3
    +1+1-1+1+1 = 3
    +1+1+1-1+1 = 3
    +1+1+1+1-1 = 3
    사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.

    [ 제한사항 ]
    주어지는 숫자의 개수는 2개 이상 20개 이하입니다.
    각 숫자는 1 이상 50 이하인 자연수입니다.
    타겟 넘버는 1 이상 1000 이하인 자연수입니다.
    입출력 예
    numbers	target	return
    [1, 1, 1, 1, 1]	3	5
    입출력 예 설명
    문제에 나온 예와 같습니다.

 */

fun main(args: Array<String>) {
    println(solution(intArrayOf(1, 1, 1, 1, 1), 3))
    println(solution(intArrayOf(2, 2, 3, 1, 1), 5))
}

fun solution(numbers: IntArray, target: Int): Int {
    return search(numbers, target, 0)
}

fun search(numbers: IntArray, target: Int, depth: Int): Int {

    if (depth == numbers.size) {
        var sum: Int = 0
        for (n in numbers) {
            sum += n
        }

        when (sum == target) {
            true -> { return 1}
            false -> { return 0 }
        }

    } else {
        var left = search(numbers, target, depth+1)

        numbers[depth] = -numbers[depth]
        var right = search(numbers, target, depth+1)

        return left + right
    }
}

// 다른 사람 풀이

// java 풀이
/*
public int solution(int[] numbers, int target) {
    int answer = 0;
    answer = dfs(numbers, 0, 0, target);
    return answer;
}
int dfs(int[] numbers, int n, int sum, int target) {
    if(n == numbers.length) {
        if(sum == target) {
            return 1;
        }
        return 0;
    }
    return dfs(numbers, n + 1, sum + numbers[n], target) + dfs(numbers, n + 1, sum - numbers[n], target);
}
*/

// kotlin 풀이
class Solution {
    private var answer = 0

    fun solution(numbers: IntArray, target: Int): Int {
        dfs(numbers, target, 0, 0)
        return answer
    }

    fun dfs(numbers: IntArray, target: Int, value: Int, idx: Int) {
        val len = numbers.size
        if (len == idx) {
            if (value == target) {
                answer++
            }
            return
        }
        dfs(numbers, target, value + numbers[idx], idx+1)
        dfs(numbers, target, value - numbers[idx], idx+1)
    }
}