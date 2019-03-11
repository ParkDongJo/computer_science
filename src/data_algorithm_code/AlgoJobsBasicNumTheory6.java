package data_algorithm_code;

import java.util.Scanner;

public class AlgoJobsBasicNumTheory6 {

    public static long[] memo = new long[31];
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

        long a = factorial(n);
        long b = factorial(n-m);
        long c = factorial(m);

        System.out.println(a / (b * c));
    }

    public static long factorial(int n) {

        if (n<=1) {
            return 1;
        } else if (memo[n] != 0) {
            return memo[n];
        }
        return memo[n] = (n) * factorial(n-1);
    }

}
