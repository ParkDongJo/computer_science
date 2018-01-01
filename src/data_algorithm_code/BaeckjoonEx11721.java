package data_algorithm_code;

import java.util.Scanner;

/**
 * 맞혔습니다.
 */
public class BaeckjoonEx11721 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();

        int n = str.length() / 10;
        int s = str.length() % 10;

        for(int i=0; i<n*10; i=i+10) {
            int end = i + 10;
            System.out.println(str.substring(i,end));
        }
        System.out.println(str.substring(str.length() - s,str.length()));
    }
}
