package data_algorithm_code;

import java.util.Scanner;

/**
 * 맞혔습니다.
 */
public class BaeckjoonEx10871 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int x = scan.nextInt();
        scan.nextLine();

        for(int i =0; i<n; i++) {
            int a = scan.nextInt();

            if(a<x) {
                System.out.print(a+" ");
            }
        }
    }
}