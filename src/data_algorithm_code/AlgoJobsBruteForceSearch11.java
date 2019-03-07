package data_algorithm_code;

import java.util.Scanner;

public class AlgoJobsBruteForceSearch11 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        int x = scan.nextInt() - 1;
        int y = scan.nextInt() - 1;
        int r = scan.nextInt();

        int[][] matrix = new int[n][n];
        matrix[x][y] = -1;

        for (int count=1; count <= r; count++) {
            for (int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if (matrix[i][j] != count && matrix[i][j] != 0) {
                        try {
                            matrix[i-1][j] = matrix[i-1][j] != 0 ? matrix[i-1][j] : count;
                        } catch (Exception e) {
                        }
                        try {
                            matrix[i+1][j] = matrix[i+1][j] != 0 ? matrix[i+1][j] : count;
                        } catch (Exception e) {
                        }

                        try {
                            matrix[i][j-1] = matrix[i][j-1] != 0 ? matrix[i][j-1] : count;
                        } catch (Exception e) {
                        }

                        try {
                            matrix[i][j+1] = matrix[i][j+1] != 0 ? matrix[i][j+1] : count;
                        } catch (Exception e) {
                        }
                    }
                }
            }
        }


        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {

                if (matrix[i][j] == -1) {
                    System.out.print("x ");
                } else {
                    System.out.print(matrix[i][j] + " ");
                }
            }
            System.out.println("");
        }
    }
}
