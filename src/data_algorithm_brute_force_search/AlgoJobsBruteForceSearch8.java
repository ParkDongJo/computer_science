package data_algorithm_code;

import java.util.Scanner;

public class AlgoJobsBruteForceSearch8 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        int[][] matrix = new int[10][10];

        for (int i=0; i<10; i++) {
            for (int j=0; j<10; j++) {
                matrix[i][j] = scan.nextInt();
            }
        }
        scan.nextLine();
        for (int count=0; count<n; count++) {
            for (int i=0; i<10; i++) {
                matrix[i][count] = matrix[i][count] == 0 ? 1 : 0;
            }

            for (int j=0; j<10; j++) {
                matrix[count][j] = matrix[count][j] == 0 ? 1 : 0;
            }

            matrix[count][count] = matrix[count][count] == 0 ? 1 : 0;
        }

        for (int i=0; i<10; i++) {
            for (int j=0; j<10; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
