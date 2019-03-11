package data_algorithm_code;

import java.util.Scanner;

public class AlgoJobsBasicNumTheory4 {

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
