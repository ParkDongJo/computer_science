package data_algorithm_code;

import java.util.Scanner;

public class AlgoJobsMultiLoop3 {
      /*
    첫째 줄에 정수n이 주어진다. (0≤n≤100)

    다음 예제와 같이 삼각형 모양으로 ‘*’을 출력한다. (공백의 개수와 별의 개수를 정확하게 확인해주시바랍니다.)

          *
         ***
        *****
     */

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int half = n - 1;
        int front = half-1;
        int end = -1;

        for (int i=0; i<n; i++) {

            for (int j=0; j<half; j++) {
                if (front >= j) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }

            System.out.print("*");

            for (int k=0; k<half; k++) {
                if (k > end) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }

            front--;
            end++;
            System.out.println("");
        }
    }
}
