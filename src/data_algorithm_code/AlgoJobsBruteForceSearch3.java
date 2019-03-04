package data_algorithm_code;

import java.util.Scanner;

public class AlgoJobsBruteForceSearch3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = 0;
        int sum = 0;

        for (int i=0; i<5; i++) {
            num = scan.nextInt();
            sum += num * num;
        }

        System.out.print(sum % 10);
    }
}
