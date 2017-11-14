package data_algorithm_code;

import java.util.Scanner;

/**
 * 맞혔습니다.
 */
public class BaeckjoonEx1003 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();

//        for(int i=0; i<count; i++) {
//            String str = fibonacci(scan.nextInt());
//
//            String[] arr = str.split("/");
//            int zeroCnt = 0;
//            int oneCnt = 0;
//
//            for(int j=0; j<arr.length; j++) {
//                if(arr[j].equals("0")) {
//                    zeroCnt++;
//                }
//
//                if(arr[j].equals("1")) {
//                    oneCnt++;
//                }
//            }
//
//            System.out.println(zeroCnt + " " + oneCnt);
//        }

        for(int j=0; j<count; j++) {
            int n = scan.nextInt();

            if(n == 0) {
                System.out.println(1 + " " + 0);
            }

            if(n == 1) {
                System.out.println(0 + " " + 1);
            }

            if(n > 1) {
                int zero = 1;
                int one = 1;

                for(int i=2; i<n; i++) {
                    one = one + zero;
                    zero = one - zero;
                }
                System.out.println(zero + " " + one);
            }

        }
    }


    public static String fibonacci(int n) {
        if (n==0) {
            return "0/";
        } else if (n==1) {
            return "1/";
        } else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }

}
