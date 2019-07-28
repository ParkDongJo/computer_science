package data_algorithm_code;

import java.util.Scanner;

public class AlgoJobsBruteForceSearch13 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int width = scan.nextInt();
        int height = scan.nextInt();
        scan.nextLine();
        int x = scan.nextInt() -1;
        int y = scan.nextInt() -1;
        scan.nextLine();
        int[][] matrix = new int[width][height];

        for (int i=0; i<width; i++) {
            for (int j=0; j<height; j++) {
                matrix[i][j] = scan.nextInt();
            }
        }

        if (matrix[x][y] == 1) {
            System.out.print("game over");
        } else {
            int xIdx = x-1;
            int yIdx = y-1;
            int count = 0;
            for (int i=0; i<3; i++) {
                for (int j=0; j<3; j++) {
                    try {
                        if (matrix[xIdx][yIdx] == 1) {
                           count++;
                        }
                    }catch (Exception e) {
                    }

                    yIdx++;
                }
                xIdx++;
                yIdx=y-1;
            }
            System.out.println(count);
        }
    }
}
