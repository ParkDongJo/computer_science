package data_algorithm_code;

import java.util.Scanner;

public class AlgoJobsBruteForceSearch16 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] matrix = new int[5][5];

        for (int i=0; i<5; i++) {
            for (int j=0; j<5; j++) {
                matrix[i][j] = scan.nextInt();
            }
        }

        int num;
        int line;
        int idx = 0;
        for (int i=0; i<25; i++) {
            line = 0;
            num = scan.nextInt();

            // 입력
            for (int j=0; j<5; j++) {
                for (int k=0; k<5; k++) {
                    if (matrix[j][k] == num) {
                        matrix[j][k] = -1;
                    }
                }
            }

            // 행
            int rowCnt = 0;
            for (int j=0; j<5; j++) {
                for (int k=0; k<5; k++) {
                    if (matrix[j][k] == -1) {
                        rowCnt++;
                    }
                }
                if (rowCnt == 5) {
                    line++;
                }
                rowCnt = 0;
            }

            // 열
            int colCnt = 0;
            for (int j=0; j<5; j++) {
                for (int k=0; k<5; k++) {
                    if (matrix[k][j] == -1) {
                        colCnt++;
                    }
                }
                if (colCnt == 5) {
                    line++;
                }
                colCnt = 0;
            }

            // 왼쪽 대각선
            int leftCnt = 0;
            for (int j=0; j<5; j++) {
                if (matrix[j][j] == -1) {
                    leftCnt++;
                }
            }
            if (leftCnt == 5) {
                line++;
            }

            // 오른쪽 대각선
            int rightCnt = 0;
            for (int j=0; j<5; j++) {
                if (matrix[j][4-j] == -1) {
                    rightCnt++;
                }
            }
            if (rightCnt == 5) {
                line++;
            }


            if (line == 3) {
                idx = i+1;
                break;
            }
        }

        System.out.print(idx);

    }
}
