package data_algorithm_code;

import java.util.Scanner;

public class AlgoJobsBasicNumTheory3 {
    /*
    문제
피보나치 수열은 수학에서 아주 유명한 수열이다. 피보나치 수열을 이루는 수들을 피보나치 수라고 한다.

피보나치 수는 0과 1로 시작한다. 0번째 피보나치 수는 0이고, 1번째 피보나치 수는 1이다. 그 다음 2번째 부터는 바로 앞 두 피보나치 수의 합이 된다.

이를 식으로 써보면 F(n)= F(n-1) + F(n-2), (n>=2)가 된다.

n이 0 ~ 15일때 까지 피보나치 수를 써보면 다음과 같다.

0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610

n이 주어졌을 때, n번째 피보나치 수를 구하는 프로그램을 작성하시오.



입력
첫째 줄에 n이 주어진다. (0 ≤ n ≤ 45)



출력
첫째 줄에 n번째 피보나치 수를 출력한다.

예제 입력
10
예제 출력
55
     */

    public static int[] memo = new int[46];
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        System.out.println(fibonacci(n));
    }

    public static int fibonacci(int n) {

        if (n <= 1) {
            return n;
        } else if (memo[n] != 0) {
            return memo[n];
        }

        return memo[n] = fibonacci(n-1) + fibonacci(n-2);
    }
}
