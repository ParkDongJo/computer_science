package data_algorithm_code;

import java.util.Scanner;

public class AlgoJobsRecursiveFunc1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int result = factorial(n);

        System.out.print(result);
    }

    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return factorial(n-1) * n;
        }
    }
}
