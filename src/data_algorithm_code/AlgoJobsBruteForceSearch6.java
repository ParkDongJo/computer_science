package data_algorithm_code;

import java.util.Scanner;

public class AlgoJobsBruteForceSearch6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int height = scan.nextInt();
        int width = scan.nextInt();
        int[][] matrix = new int[height][width];

        for (int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                matrix[i][j] = scan.nextInt();
            }
        }

        int diff;
        int temp;
        int center;

        if (width % 2 == 0) {
            //짝수
            center = (width / 2) - 1;
        } else {
            //홀수
            center = width / 2;
        }

        for (int i=0; i<height; i++) {
            diff = width - 1;
            for (int j=0; j<width; j++) {

                if (j > center) {
                    break;
                }

                temp = matrix[i][diff];
                matrix[i][diff] = matrix[i][j];
                matrix[i][j] = temp;

                diff--;
            }
        }

        for (int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
