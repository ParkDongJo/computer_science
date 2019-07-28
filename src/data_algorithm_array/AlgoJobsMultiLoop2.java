package data_algorithm_code;

import java.util.Scanner;

public class AlgoJobsMultiLoop2 {
    /*
    첫째 줄에 정수n이 주어진다. (0≤n≤100)

    다음 예제와 같이 삼각형 모양으로 ‘*’을 출력한다. (공백의 개수와 별의 개수를 정확하게 확인해주시바랍니다.)

      *
     **
    ***
     */

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int point = n-1;

        for (int i=0; i<n; i++) {

            for (int j=0; j<n; j++) {
                if (point <= j) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }

            point--;
            System.out.println("");
        }
    }
}
