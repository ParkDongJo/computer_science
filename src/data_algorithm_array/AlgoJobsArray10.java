package data_algorithm_code;

import java.util.Scanner;

public class AlgoJobsArray10 {
    /*
    N*M의 2차원 배열이 주어지고,
    주어진 2차원 배열의 [A][B]에는 어떠한 값이 있는지 출력하는 프로그램을 작성해보자. (단, 2차원 배열을 활용할 것)

    [입력]
    첫째 줄에 자연수 행의 개수 N,열의 개수 M이 주어진다.(1<=N,M<=100)
    둘째 줄 부터 N*M의 배열이 주어지고, 마지막 줄에는 A,B가 주어진다. ( 0<=A<N, 0<=B<M )

    [출력]
    첫째 줄에 N*M배열의 [A][B]의 값을 출력한다.


    [입력 예제]
    3 4
    1 2 3 4
    5 6 7 8
    9 10 11 12
    1 1

    [출력 예제]
    6

     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int height = scan.nextInt();
        int width = scan.nextInt();
        scan.nextLine();

        int[][] array = new int[height][width];

        for (int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                array[i][j] = scan.nextInt();
            }
        }

        int i = scan.nextInt();
        int j = scan.nextInt();
        System.out.print(array[i][j]);
    }
}
