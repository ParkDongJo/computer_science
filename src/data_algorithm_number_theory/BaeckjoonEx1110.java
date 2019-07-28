package data_algorithm_code;


import java.util.Scanner;

/**
 * 맞았습니다.
 */
public class BaeckjoonEx1110 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        System.out.println(calcCircler(num, num, 0));

    }

    public static int calcCircler(int start, int num, int idx) {

        if(idx != 0 && start == num) {
            return idx;
        }


        String numStr = num + "";

        int left = 0;
        int right = 0;

        if(num < 10) {
            right = Integer.parseInt(numStr.charAt(0)+"");
        }else{
            left = Integer.parseInt(numStr.charAt(0)+"");
            right = Integer.parseInt(numStr.charAt(1)+"");
        }

        int sum = (left + right);
        String sumStr = sum + "";
        int nRight = 0;

        if(sum < 10) {
            nRight = Integer.parseInt(sumStr.charAt(0)+"");
        }else{
            nRight = Integer.parseInt(sumStr.charAt(1)+"");
        }

        int nNum = 0;
        if(right == 0) {
            nNum = Integer.parseInt("" + nRight);
        }else{
            nNum = Integer.parseInt(right + "" + nRight);
        }

        return calcCircler(start,nNum,++idx);
    }
}
