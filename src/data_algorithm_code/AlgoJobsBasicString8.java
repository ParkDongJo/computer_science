package data_algorithm_code;

import java.math.BigInteger;
import java.util.Scanner;

public class AlgoJobsBasicString8 {

    /**
     [문제]
     두 자연수가 주어질 때 그들의 덧셈을 계산하는 프로그램을 작성하시오.
     각 수는 1 이상 10^100 미만의 범위를 가진다.

     [입력]
     첫 번째 줄과 두 번째 줄에 각각 하나의 자연수가 주어진다.

     [출력]
     첫 번째 줄에 덧셈의 결과를 출력한다.

     [예제]
     예제 입력
     123112981293812938139
     1298928491101221811

     예제 출력
     124411909784914159950
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String aBigNumber = scan.nextLine();
        String bBigNumber = scan.nextLine();

        int max = Math.max(aBigNumber.length(), bBigNumber.length());
        char[] a = attachZero(aBigNumber, max);
        char[] b = attachZero(bBigNumber, max);

        char[] result = addBigNum(a,b);

        for (int i=0; i<result.length; i++) {
            if (!(i == 0 && result[i] == 0)) {
                System.out.print((int)result[i]);
            }
        }

        // BigInteger를 쓰는건 문제 의도가 아님
//        BigInteger a = new BigInteger(aBigNumber);
//        BigInteger b = new BigInteger(bBigNumber);
//
//        System.out.print(a.add(b));
    }

    public static char[] addBigNum(char[] a, char[] b) {
        char[] result = new char[a.length];
        int carry = 0;
        int temp;

        for (int i=a.length-1; i>=0; i--) {
            temp = (a[i]-48) + (b[i]-48) + carry;

            if (temp > 9) {
                result[i] = (char) (temp % 10);
                carry = 1;
            } else {
                result[i] = (char) temp;
                carry = 0;
            }
        }

        return result;
    }

    public static char[] attachZero(String numStr, int max) {

        while (numStr.length()<max+1) {
            numStr = "0" + numStr;
        }

        return numStr.toCharArray();
    }

}
