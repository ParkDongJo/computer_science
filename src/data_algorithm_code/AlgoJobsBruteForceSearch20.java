package data_algorithm_code;

import java.util.Scanner;

public class AlgoJobsBruteForceSearch20 {

    // 함정 = 좌표의 개념이 아닌, 좌표와 넓이 1의 관계를 잘 짜야함

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] quadArr = new int[4][4];

        int widthMax = 0;
        int heightMax = 0;
        int position;

        for (int i=0; i<4; i++) {
            for (int j=0; j<4; j++) {
                position = scan.nextInt();

                if (j == 1 || j == 3) {
                    widthMax = Math.max(widthMax, position);
                }
                if (j == 0 || j == 2) {
                    heightMax = Math.max(heightMax, position);
                }
                quadArr[i][j] = position;
            }
        }

        int x;
        int y;
        int _x;
        int _y;
        int[][] matrix = new int[heightMax+1][widthMax+1];

        int idx =1;
        for (int k=0; k<4; k++) {
            x = quadArr[k][0];
            y = quadArr[k][1];
            _x = quadArr[k][2];
            _y = quadArr[k][3];

            for (int i=0; i<= heightMax; i++) {
                for (int j = 0; j <= widthMax; j++) {

                    if ((y <= j && _y >= (j + 1) )  &&
                            x <= i && _x >= (i + 1)) {
                        matrix[i][j] = idx;
                    }

                }
            }
            idx++;
        }

        int count = 0;
        for (int i=0; i<heightMax; i++) {
            for (int j=0; j<widthMax; j++) {

                if (matrix[i][j] > 0) {
                    count++;
                }
            }

        }

        System.out.println(count);
    }
}
