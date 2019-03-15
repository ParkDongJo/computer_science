package data_algorithm_code;

import java.util.Scanner;

public class AlgoJobsBasicNumTheory5 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] list = new int[n];
        int num = 0;

        for (int i=0; i<n; i++) {
            list[i] = scan.nextInt();
        }

        for (int i=0; i<3; i++) {
            num = scan.nextInt();
        }

        int diff = list[1] - num;
        int a = ((diff/2) + list[2]) / 2;

        System.out.print(a + " ");
        for (int i=1; i<n; i++) {
            System.out.print((list[i] - a) + " ");
        }
    }

}
