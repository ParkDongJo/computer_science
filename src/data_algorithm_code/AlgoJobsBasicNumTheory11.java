package data_algorithm_code;

import java.util.Scanner;

public class AlgoJobsBasicNumTheory11 {
    /**
    문제
    주어진 숫자들 중 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.

    입력
    첫 줄에 수의 개수 N이 주어진다. N은 100이하이다.
     다음으로 N개의 줄에 걸쳐 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.

    출력
    주어진 수들 중 소수의 개수를 출력한다.

    예제 입력
    4
    1
    3
    5
    7
    예제 출력
    3
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int num;
        int primeCnt = 0;

        for (int i=0; i<n; i++) {
            num = scan.nextInt();
            if (isPrime(num)) {
                primeCnt++;
            }
        }

        System.out.println(primeCnt);
    }

    public static boolean isPrime(int num) {
        boolean result = true;
        if (num != 1) {
            for (int i = 2; i<=100; i++) {
                if (num != i && num % i == 0) {
                    result = false;
                    break;
                }
            }

        } else {
            result = false;
        }

        return result;
    }
}
