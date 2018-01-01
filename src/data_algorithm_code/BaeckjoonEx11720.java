package data_algorithm_code;

import java.util.Scanner;

/**
 * 맞혔습니다.
 */
public class BaeckjoonEx11720 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        String numStr = scan.nextLine();

        int sum = 0;
        for(int i=0; i<numStr.length(); i++) {
            sum += Integer.parseInt(numStr.charAt(i)+"");
        }
        System.out.println(sum);
    }
}