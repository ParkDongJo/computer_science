package data_algorithm_code;

import java.util.Scanner;

public class AlgoJobsBasicNumTheory3 {

    public static int[] memo = new int[46];
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        System.out.println(fibonacci(n));
    }

    public static int fibonacci(int n) {

        if (n <= 1) {
            return n;
        } else if (memo[n] != 0) {
            return memo[n];
        }

        return memo[n] = fibonacci(n-1) + fibonacci(n-2);
    }
}
