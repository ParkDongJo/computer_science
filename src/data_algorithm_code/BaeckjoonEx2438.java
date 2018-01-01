package data_algorithm_code;

import java.util.Scanner;

/**
 * 맞혔습니다.
 */
public class BaeckjoonEx2438 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for(int i=0; i<n; i++) {

            for(int j=0; j<=i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
