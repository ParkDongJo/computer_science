package data_algorithm_code;

import java.util.*;

/**
 * 맞았습니다.
 */
public class BaeckjoonEx5622 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] alpha = {2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,8,8,8,9,9,9,9};
        String str = scan.nextLine();
        int sec = 0;


        for(int i=0; i<str.length(); i++) {
            Character c = str.charAt(i);
            int idx = c - 65;
            sec += 2 + alpha[idx] - 1;
        }

        System.out.println(sec);
    }
}
