package data_algorithm_code;

import java.util.Scanner;

public class AlgoJobsBruteForceSearch1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        scan.nextLine();

        int count = 0;
        int carNum = 0;

        for (int i=0; i<5; i++) {
            carNum = scan.nextInt();
            if (num == carNum) {
                count++;
            }
        }

        System.out.print(count);
    }
}
