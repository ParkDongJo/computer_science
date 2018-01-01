package data_algorithm_code;

import java.util.Scanner;

/**
 * 맞혔습니다.
 */
public class BaeckjoonEx1065 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        if(checkDigit(num) > 2) {
            int cnt = 0;

            for(int i=100; i<=num; i++) {
                int[] arr = makeArr(i);
                if(checkSequenceArr(arr)){
                    cnt++;
                }
            }
            System.out.println(cnt + 99);
        }else{
            System.out.println(num);
        }

    }
    public static int checkDigit(int num) {
        String numStr = num + "";
        return numStr.length();
    }

    public static int[] makeArr(int num) {
        String numStr = num + "";
        int[] arr = new int[numStr.length()];
        for(int i=0; i<numStr.length(); i++) {
            int dot = Integer.parseInt(numStr.charAt(i)+"");
            arr[i] = dot;
        }
        return arr;
    }
    public static boolean checkSequenceArr(int[] arr) {
        int[] sqArr = new int[arr.length-1];
        boolean result = true;

        for(int i=0; i<arr.length; i++) {
            if(i<arr.length-1) {
                sqArr[i] = arr[i] - arr[i+1];
            }
        }

        for(int i=0; i<sqArr.length; i++) {
            if(sqArr[0] != sqArr[i]){
                result = false;
                break;
            }
        }

        return result;
    }
}
