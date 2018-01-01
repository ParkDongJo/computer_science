package data_algorithm_code;

import java.util.Scanner;

/**
 * 맞혔습니다.
 */
public class BaeckjoonEx2739 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for(int i=1; i<=9; i++) {
            int m = n*i;
            System.out.println(n + " * "+ i + " = " + m);
        }

    }
}
