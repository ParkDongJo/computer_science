package data_algorithm_recursion;

import java.util.Scanner;

public class RecursionPower {
    //거듭제곱
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

        int result = power(n, m);

        System.out.println(result);
    }

    public static int power(int n, int m) {
        if (m == 1) {
            return n;
        } else {
            return n * power(n, m-1);
        }
    }
}
