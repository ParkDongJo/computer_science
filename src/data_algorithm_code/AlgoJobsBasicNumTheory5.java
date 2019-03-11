package data_algorithm_code;

import java.util.Scanner;

public class AlgoJobsBasicNumTheory5 {

    public static int[][] gMatrix;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        gMatrix = new int[n][n];

        for (int i=0; i<n; i++) {
            for (int j=0; j<4; j++) {
                gMatrix[i][j] = scan.nextInt();
            }
        }

        int[] result = new int[n];
        for (int i=0; i<n; i++) {
            if (i < n-1) {
                result[i] =(((sumRow(i) - sumRow(i+1)) / 2) + gMatrix[i][i+1]) / 2;
            } else {
                result[i] = gMatrix[i][0] - result[0];
            }
        }

        for (int i=0; i<n; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public static int sumRow(int idx) {
        int sum = 0;

        for (int i=0; i< gMatrix[idx].length; i++) {
            sum += gMatrix[idx][i];
        }

        return sum;
    }

}
