package data_algorithm_code;

import java.util.ArrayList;
import java.util.Scanner;

public class AlgoJobsBasicNumTheory7 {

    /**
    문제
    민건이는 수학 수업시간동안 재밌는 방법으로 수학을 연습하고 있다.
    먼저 민건이는 정수 수열 A를 작성했다.
    그리고 나서 그 아래에 A의 해당 항까지의 평균값을 그 항으로 하는 정수 수열 B를 쓴다.
    예를 들어 , 만약 수열 A가 1, 3, 2, 6, 8 이라면 수열 B는 1/1, (1+3)/2 , (1+3+2)/3, (1+3+2+6)/4, (1+3+2+6+8)/5 즉, 1, 2, 2, 3, 4 가 된다.
    수열 B가 주어졌을 때 수열 A를 구하는 프로그램을 작성하시오.


    입력
    첫째줄에 수열 B의 길이를 나타내는 N이 주어진다.(1 <= N <= 100)
    두번째 줄에 수열 B를 구성하는 N개의 요소가 주어진다. Bi (1 <= Bi <= 10^9)


    출력
    첫째 줄에 수열 A를 이루는 N개의 정수를 출력해라 (1 <= Ai <= 10^9)
    NOTE : 수열 A의 요소들은 정수이다.


    예제 입력
    1
    2
    예제 출력
    2


    예제 입력
    4
    3 2 3 5
    예제 출력
    3 1 5 11


    예제 입력
    5
    1 2 2 3 4
    예제 출력
    1 3 2 6 8
     */

//    public static ArrayList<Long> memo = new ArrayList<Long>();
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int n = scan.nextInt();
//        int m = scan.nextInt();
//
//        long a = factorial(n);
//        long b = factorial(n-m);
//        long c = factorial(m);
//
//        long result = a / (b * c);
//
//        System.out.println(result);
//        System.out.println(division(result));
//    }
//
//    public static long factorial(int n) {
//
//        if (n<=1) {
//            return 1;
//        } else if (memo.get(n) != 0) {
//            return memo[n];
//        }
//        return memo[n] = (n) * factorial(n-1);
//    }
//
//    public static int division(long num) {
//        int count = 0;
//        while (num % 10 == 0) {
//            num = num / 10;
//            count++;
//        }
//
//        return count;
//    }

}
