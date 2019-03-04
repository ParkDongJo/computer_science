package data_algorithm_code;

import java.util.Scanner;

public class AlgoJobsMultiLoop1 {
    /*
    첫째 줄에 정수n이 주어진다. (0≤n≤100)

    다음 예제와 같이 삼각형 모양으로 ‘*’을 출력한다.

    *
    **
    ***
     */

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i=0; i<n; i++) {

            for (int j=0; j<i+1; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
