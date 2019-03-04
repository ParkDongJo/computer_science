package data_algorithm_recursion;

import java.util.Scanner;

public class Recursion {
    public static int[] memo = new int[46];

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        memo[0] = 0;
        memo[1] = 1;
        long start = System.currentTimeMillis();
        int result = fivonachi(n);
        long end = System.currentTimeMillis();

        System.out.println(result);

        System.out.println( "실행 시간 : " + ( end - start ));
        System.out.println( "실행 시간(초) : " + ( end - start )/1000.0 +"초");
    }

    public static int fivonachi(int n) {

        if (n == 0 || memo[n] != 0) {
            return memo[n];
        }

        memo[n-1] = fivonachi(n-1);
        memo[n-2] = fivonachi(n-2);

        return memo[n-1] + memo[n-2];
    }
}

