package data_algorithm_code;

import java.util.ArrayList;
import java.util.Scanner;

public class AlgoJobsBasicNumTheory7 {

    public static ArrayList<Long> memo = new ArrayList<Long>();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

        long a = factorial(n);
        long b = factorial(n-m);
        long c = factorial(m);

        long result = a / (b * c);

        System.out.println(result);
        System.out.println(division(result));
    }

    public static long factorial(int n) {

        if (n<=1) {
            return 1;
        } else if (memo.get(n) != 0) {
            return memo.get(n);
        }
        return memo[n] = (n) * factorial(n-1);
    }

    public static int division(long num) {
        int count = 0;
        while (num % 10 == 0) {
            num = num / 10;
            count++;
        }

        return count;
    }

}
