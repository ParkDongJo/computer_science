package data_algorithm_code;

import java.util.Scanner;

public class AlgoJobsBasicNumTheory2 {
    /*
     * 1 (1개) <1개> / 2 ~ 7 (6개) <2개> / 8 ~ 19 (12개) <3개> / 20 ~ 37 (18개) <4개>
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        int pathCount = 1;
        int sum = 1;
        for (int i=6; num >= sum + 1; i = i+6) {
            sum = sum + i;
            pathCount++;
        }

        System.out.println(pathCount);
    }
}
