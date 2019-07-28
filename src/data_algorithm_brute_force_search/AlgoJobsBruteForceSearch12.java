package data_algorithm_code;

import java.util.Scanner;

public class AlgoJobsBruteForceSearch12 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();

        int[][] matrix = new int[101][101];

        int[][] store = new int[n][4];
        for (int i=0; i<n; i++) {
            for (int j=0; j<4; j++) {
                store[i][j] = scan.nextInt();
            }
        }

        int x;
        int y;
        int height;
        int width;

        for (int idx=0; idx<n; idx++) {

            x = store[idx][0];
            y = store[idx][1];
            height = store[idx][2];
            width = store[idx][3];

            for (int i=x; i<x+(height); i++) {
                for (int j=y; j<y+(width); j++) {
                    matrix[i][j] = idx+1;
                }
            }
        }

        int[] result = new int[n];
        for (int idx=0; idx<n; idx++) {
            for (int i=0; i<101; i++) {
                for (int j=0; j<101; j++) {
                    if (idx+1 == matrix[i][j]) {
                        result[idx] = result[idx] +1;
                    }
                }
            }
        }

        for (int i=0; i<n; i++) {
            System.out.println(result[i]);
        }

    }
}
