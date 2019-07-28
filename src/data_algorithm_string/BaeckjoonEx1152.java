package data_algorithm_code;

import java.util.Scanner;

/**
 * 맞혔습니다.
 */
public class BaeckjoonEx1152 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();

        String[] wordArr = str.split(" ");

        int cnt = 0;
        for(int i=0; i<wordArr.length; i++) {
            if(!wordArr[i].equals("")) {
                cnt++;
            }
        }
        System.out.println(cnt);

    }
}
