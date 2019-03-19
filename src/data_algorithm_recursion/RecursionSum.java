package data_algorithm_recursion;

import java.util.Scanner;

public class RecursionSum {
    // N 부터 M 까지의 함
    public static int[] numArr;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        numArr = new int[n];

        for (int i=0; i<n; i++) {
            numArr[i] = scan.nextInt();
        }

        int result = sum(0, n-1);

        System.out.println(result);
    }

    public static int sum(int start, int end) {
        if (start == end) {
            return numArr[start];
        } else {
            return numArr[end] + sum(start, end - 1);
        }
    }
}
