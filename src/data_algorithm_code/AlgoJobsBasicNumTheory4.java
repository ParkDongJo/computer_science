package data_algorithm_code;

import java.util.Scanner;

public class AlgoJobsBasicNumTheory4 {

    /*
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

    public static int[] gSumArr;
    public static int[] gFirstArr;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
//        int[] secArr = new int[n];
//
//        for (int i=0; i<n; i++) {
//            secArr[i] = scan.nextInt();
//        }
//
//        int[] firstArr = getFirstArray(secArr);
//
//        for (int i=0; i<firstArr.length; i++) {
//            System.out.print(firstArr[i] + " ");
//        }


        // 재귀함수로 풀어보기
        gSumArr = new int[n];
        gFirstArr = new int[n];

        for (int i=0; i<n; i++) {
            gSumArr[i] = scan.nextInt() * (i+1);
        }

        calcDiffRecursive(0);

        for (int i=0; i<gFirstArr.length; i++) {
            System.out.print(gFirstArr[i] + " ");
        }

    }

    public static int[] getFirstArray(int[] secArr) {
        int[] firstArr = new int[secArr.length];

        firstArr[0] = secArr[0];
        for (int i=1; i<secArr.length; i++) {
           firstArr[i] = calcDiff(i, secArr);
        }

        return firstArr;
    }

    public static int calcDiff(int idx, int[] array) {
        if (idx == 0) {
            return 0;
        }

        return (array[idx] * (idx+1)) - (array[idx-1] * ((idx-1)+1));
    }

    public static void calcDiffRecursive(int idx) {

        if (idx == 0) {
            gFirstArr[0] = gSumArr[0];
        } else {
            gFirstArr[idx] = gSumArr[idx] - gSumArr[idx-1];

        }

        if (gFirstArr[gFirstArr.length-1] == 0) {
            idx++;
            calcDiffRecursive(idx);
        }
    }
}
