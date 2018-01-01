package data_algorithm_code;

import java.util.Scanner;

/**
 * 맞았습니다.
 */
public class BaeckjoonEx2441 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(j<i) {
                    System.out.print(" ");
                }else{
                    System.out.print("*");
                }
            }
            System.out.println();
        }

    }
}
