package data_algorithm_code;

import java.util.Scanner;

public class AlgoJobsAdvanceBruteForce2 {
    /**
     [문제]
     두 정수 n, k를 입력받아 k개의 1을 가진 n자리 이진 패턴을 출력하는 프로그램을 작성하세요.

     [입력]
     두 정수 n, k가 입력으로 주어진다. ( 0 < n <= 30, 0 <= k < 8 , n >= k )

     [출력]
     결과를 내림차순으로 출력한다.

     [예제]
     예제 입력
     2 1
     예제 출력
     10
     01

     예제 입력
     2 0
     예제 출력
     00

     예제 입력
     4 2
     예제 출력
     1100
     1010
     1001
     0110
     0101
     0011
     */
    public static int n, r;
    public static int[] result;
    public static int oneCnt = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        r = scan.nextInt();

        int[] bitArr = new int[n];
        printBinary(bitArr,0);
    }

    public static void printBinary(int[] bitArr, int idx) {
        if (idx >= n) {
            if (oneCnt == r) {
                printResult(bitArr);
            }
        } else {

            for (int i=1; i>=0; i--) {
                if (i == 1) {
                    oneCnt++;
                }
                bitArr[idx] = i;
                printBinary(bitArr, idx+1);

                if (i == 1) {
                    oneCnt--;
                }
            }
        }
    }

    public static void printResult(int[] bitArr) {
        for (int i=0; i<n; i++) {
            System.out.print(bitArr[i]);
        }
        System.out.println("");
    }
}
