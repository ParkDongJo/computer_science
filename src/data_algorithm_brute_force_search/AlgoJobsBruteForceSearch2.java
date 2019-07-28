package data_algorithm_code;

import java.util.Scanner;

public class AlgoJobsBruteForceSearch2 {
    //[체크체크]
    // 테스트 전에 다시 한번 참고!!

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] array = new int[5][5];

        for (int i=0; i<5; i++) {
            for (int j=0; j<5; j++) {
                array[i][j] = scan.nextInt();
            }
        }

        boolean up = false;
        boolean left = false;
        boolean down = false;
        boolean right = false;

        for (int i=0; i<5; i++) {
            for (int j=0; j<5; j++) {
                //상
                try {
                    if (array[i][j] < array[i - 1][j]) {
                        up = true;
                    }
                } catch (Exception e) {
                    up = true;
                }

                //우
                try {
                    if (array[i][j] < array[i][j + 1]) {
                        right = true;
                    }
                } catch (Exception e) {
                    right = true;
                }

                //하
                try {
                    if (array[i][j] < array[i + 1][j]) {
                        down = true;
                    }
                } catch (Exception e) {
                    down = true;
                }

                //좌
                try {
                    if (array[i][j] < array[i][j - 1]) {
                        left = true;
                    }
                } catch (Exception e) {
                    left = true;
                }

                if (up && right && down && left) {
                    array[i][j] = -1;
                }

                up = false;
                left = false;
                down = false;
                right = false;
            }
        }

        for (int i=0; i<5; i++) {
            for (int j=0; j<5; j++) {
                if (array[i][j] == -1) {
                    System.out.print("* ");
                } else {
                    System.out.print(array[i][j] + " ");
                }
            }
            System.out.println("");
        }
    }
}
