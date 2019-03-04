package data_algorithm_code;

import java.util.Scanner;

public class AlgoJobsArray11 {

    //[체크체크]
    // 테스트 전에 다시 한번 참고!!

    /*
    N이 주어질 때, 다음과 같은 프로그램을 작성해보자.

    [입력]
    첫째 줄에 자연수 N이 주어진다.(1<=N<=100)

    [출력]
    예시를 참고하여 작성하자.

    [입력 예제]
    3

    [출력 예제]
    1 2 4
    3 5
    6

     */

    // 각 열의 순열의 규칙을 파악하고 적용
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] array = new int[n][n];
        int height = n;
        int width = n;
        int startStepNum = 1;
        int yDiff = 2;

        for (int i=0; i<height; i++) {
            int nextNum = startStepNum;
            int xDiff = i + 1;

            for (int j=0; j<width; j++) {
                array[i][j] = nextNum;
                nextNum = nextNum + xDiff;
                xDiff++;
            }
            width = width-1;
            startStepNum = startStepNum + yDiff;
            yDiff++;
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (array[i][j] != 0) {
                    System.out.print(array[i][j] + " ");
                }
            }
            System.out.println("");
        }
    }
}
