package data_algorithm_code;

import java.util.Scanner;

public class AlgoJobsBasicString9 {

    /**
     [문제]
     두 자연수가 주어질 때 그들의 뺄셈을 계산하는 프로그램을 작성하시오.
     각 수는 1 이상 10^100 미만의 범위를 가진다.

     [입력]
     첫 번째 줄과 두 번째 줄에 각각 하나의 자연수가 주어진다.

     [출력]
     첫 번째 줄에 뺄셈의 결과를 출력한다.

     [예제]
     예제 입력
     1962831868293922
     2528838232
     예제 출력
     1962829339455690

     예제 입력
     18592918185
     2195812983912895799129
     예제 출력
     -2195812983894302880944
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String aBigNumber = scan.nextLine();
        String bBigNumber = scan.nextLine();

        int flag = compare(aBigNumber, bBigNumber);
        char[] max;
        char[] min;


        int maxLen = Math.max(aBigNumber.length(), bBigNumber.length());
        if (flag >= 0) {
            // 양수 결과
            max = attachZero(aBigNumber, maxLen);
            min = attachZero(bBigNumber, maxLen);
        } else {
            // 음수 결과
            max = attachZero(bBigNumber, maxLen);
            min = attachZero(aBigNumber, maxLen);
            System.out.print("-");
        }

        char[] result = subBigNum(max, min);

        if (isZero(result)) {
            System.out.print(0);
        } else {

            for (int i=0; i<result.length; i++) {
                if (!(i == 0 && result[i] == 0)) {
                    System.out.print((int)result[i]);
                }
            }
        }


    }

    public static boolean isZero(char[] a) {
        int count =0;
        for (int i=0; i<a.length; i++) {
            if (a[i] == 0) {
               count++;
            }
        }
        return count == a.length? true : false;
    }

    public static char[] subBigNum(char[] a, char[] b) {

        char[] result = new char[a.length];
        int carry = 0;
        int temp;

        for (int i=a.length-1; i>=0; i--) {
            temp = (a[i]-48) - (b[i]-48) + carry;

            if (temp < 0) {
                result[i] = (char) (temp + 10);
                carry = -1;
            } else {
                result[i] = (char) temp;
                carry = 0;
            }
        }

        return result;
    }

    public static int compare(String a, String b) {
        if (a.length() == b.length()) {
            return a.compareTo(b);
        } else {
            return a.length() > b.length() ? 1 : -1;
        }

    }

    public static char[] attachZero(String numStr, int max) {
        while (numStr.length()<max) {
            numStr = "0" + numStr;
        }
        return numStr.toCharArray();
    }

}
