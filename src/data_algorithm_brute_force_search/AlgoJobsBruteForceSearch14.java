package data_algorithm_code;

import java.util.Scanner;

public class AlgoJobsBruteForceSearch14 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[][] classHistory = new int[n][5];
        int[][] matrix = new int[n][n];

        for (int i=0; i<n; i++) {
            for (int j=0; j<5; j++) {
                classHistory[i][j] = scan.nextInt();
            }
        }

        int classNum;
        for (int i=0; i<n; i++) {
            for (int j=0; j<5; j++) {
                classNum = classHistory[i][j];
                for (int k=0; k<n; k++) {
                    if (i != k && classNum == classHistory[k][j]) {
                        matrix[i][k] = 1;
                    }
                }
            }
        }

        int count;
        int max = 0;
        int idx = 0;
        for (int i=0; i<n; i++) {

            count = 0;
            for (int j=0; j<n; j++) {
                if (matrix[i][j] == 1) {
                    count++;
                }
            }

            if (count > max) {
                max = count;
                idx = i;
            }
        }

        System.out.println(idx +1);
    }
}
