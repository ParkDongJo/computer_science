package data_algorithm_code;

import java.util.Scanner;

/**
 * Created by parkdongjo on 2017. 11. 16..
 */
public class BaeckjoonEx2440 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for(int i=0; i<n; i++) {
            int idx = n;
            for(int j=0; j<n; j++) {
                if(idx <= (i+1)) {
                    //System.out.print(" ");
                }else{
                    System.out.print("*");
                }
                idx--;
            }
            System.out.println();
        }

    }
}
