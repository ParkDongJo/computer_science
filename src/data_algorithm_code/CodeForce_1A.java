package data_algorithm_code;

import java.util.Scanner;

/**
 * 맞혔습니다.
 */
public class CodeForce_1A {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int a = scan.nextInt();

        long width = 0;
        if(n%a == 0) {
            width = n/a;
        }else{
            width = n/a + 1;
        }

        long height = 0;
        if(m%a == 0) {
            height = m/a;
        }else{
            height = m/a + 1;
        }

        System.out.println("width : " + width);
        System.out.println("height :" + height);
        System.out.println(width * height);

    }
}
