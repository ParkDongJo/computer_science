package data_algorithm_code;

import java.util.Scanner;

public class AlgoJobsBruteForceSearch18 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        int target = scan.nextInt();


        int[][] matrix = new int[m][n];
        int[] result = makeSpinArr(n,m,target, matrix);

        System.out.println((result[0] + 1) + " " + (result[1] + 1));
    }

    public static int[] makeSpinArr(int n, int m, int target, int[][] arr) {
        int[] result = new int[2];
        int value = 1;          // 배열을 채워 나갈 값
        int row = 0, col = -1;  // 행(row), 열(col) 을 나타내는 index
        int inc = 1;            // index 의 증감량을 나타냄.
        int width = n, height = m;
        while (value < width * height) {
            for (int i = 0; i < n; i++) {
                col += inc; // 열 index 를 inc 만큼 증가시킴. inc가 -1이면 감소
                if (target == value) {
                    result[0] = row;
                    result[1] = col;
                }
                arr[row][col] = value;
                value++;
            }
            n--; // 전진하는 양 1 감소

            if (value == width * height) break;

            for (int i = 0; i < m-1; i++) {
                row += inc; // 행 index 를 inc 만큼 증가시킴. inc 가 -1이면 감소
                if (target == value) {
                    result[0] = row;
                    result[1] = col;
                }
                arr[row][col] = value;
                value++;
            }
            m--;
            inc *= -1; //inc 부호바꿈. 증가가 감소로 혹은 감소가 증가로 바뀌는 효과

        }

        return result;
    }


}
