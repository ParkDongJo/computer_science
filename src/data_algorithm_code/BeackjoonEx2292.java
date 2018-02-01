package data_algorithm_code;

import java.util.Scanner;

/**
 * 맞았습니다.
 */
public class BeackjoonEx2292 {
    /**
     *
     * 1 / 2,3,4,5,6,7 / 8,9,10,11,12,13,14,15,16,17,18,19
     * 1 / 6 / 12 / 18 / 24 ...
     *
     * n != 1
     * n >= 2
     * sum((n-1) * 6)) + 1
     *
     * 7 = 2-1 * 6 + 1
     * 19 = 3-1 * 6 + 2-1 * 6 + 1
     *
     * 5 / 6 / 6 / 6
     *
     * */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        boolean flag = true;
        int last = 1;
        int n = 2;

        if(num>1) {
            while (flag) {
                int opt = ((n-1) * 6);
                last += opt;

                if(num<=last) {
                    flag = false;
                }else{
                    n++;
                }
            }
        }else{
            n = 1;
        }

        System.out.println(n);
    }
}