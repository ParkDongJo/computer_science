package data_algorithm_code;

import java.util.Scanner;

public class AlgoJobsBasicNumTheory7 {

    /**
     [문제]
     n명의 사람중 m명을 순서에 상관없이 뽑는 경우의 수를 조합이라고 하며 nCm으로 나타낸다.
     nCm은 수식으로 n!/m!(n-m)! 으로 구할 수 있다. (5! = 12345)
     n과 m이 주어졌을때 nCm의 끝자리 0의 개수를 출력하는 프로그램을 작성하시오.

     [입력]
     첫째 줄에 정수 n, m(0≤m≤n≤1,000,000)이 들어온다.

     [출력]
     첫째 줄에 0의 개수를 출력한다.

     [예제]
     예제 입력
     25 12
     예제 출력
     2
     */

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

        int nFiveCnt = 0;
        int nTwoCnt = 0;
        int mFiveCnt = 0;
        int mTwoCnt = 0;
        int num;
        for (int i=n; i>=m+1; i--) {
            num = i;
            while(num % 5 == 0) {
                num /= 5;
                nFiveCnt++;
            }
            num = i;
            while(num % 2 == 0) {
                num /= 2;
                nTwoCnt++;
            }
        }

        for (int i=n-m; i>0; i--) {
            num = i;
            while(num % 5 == 0) {
                num /= 5;
                mFiveCnt++;
            }
            num = i;
            while(num % 2 == 0) {
                num /= 2;
                mTwoCnt++;
            }
        }

        int zeroCnt = Math.min(nFiveCnt - mFiveCnt, nTwoCnt - mTwoCnt);
        System.out.println(zeroCnt < 0 ? 0:zeroCnt);
    }
}
