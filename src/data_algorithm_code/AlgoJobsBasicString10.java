package data_algorithm_code;

import java.util.Scanner;

public class AlgoJobsBasicString10 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String aBigNumber = scan.nextLine();
        String bBigNumber = scan.nextLine();

        int max = Math.max(aBigNumber.length(), bBigNumber.length());
        char[] a = attachZero(aBigNumber, max);
        char[] b = attachZero(bBigNumber, max);


    }

    public static char[] multiBigNum(char[] a, char[] b) {
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
