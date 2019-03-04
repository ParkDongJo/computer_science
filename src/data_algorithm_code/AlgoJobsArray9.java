package data_algorithm_code;

import java.util.Scanner;

public class AlgoJobsArray9 {
    /*
    행의 개수 N, 열의 개수 M이 주어질 때, 다음과 같이 출력하는 프로그램을 작성해보자. (단, 2차원 배열을 활용할 것)

    [입력]
    첫째 줄에 자연수 N,M이 주어진다.(1<=N,M<=100)

    [출력]
    출력 예시와 같은 형식으로 출력한다.

    [입력 예제]
    3 4

    [출력 예제]
    1 2 3 4
    5 6 7 8
    9 10 11 12

     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int height = scan.nextInt();
        int width = scan.nextInt();
        int count = 0;

        for (int i=0; i<height; i++) {

            for (int j=0; j<width; j++) {
                count++;
                System.out.print(count + " ");
            }
            System.out.println("");
        }
    }
}
