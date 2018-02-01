package data_algorithm_code;

import java.util.Scanner;

/**
 * 맞았습니다.
 */
public class BaeckjoonEx10809 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        int[] alpha = new int[26];

        for(int i=0; i<alpha.length; i++) {
            alpha[i] = -1;
        }

        for(int i=0; i<str.length(); i++) {
            Character c = str.charAt(i);

            int idx = c - 97;
            if(alpha[idx] == -1) {
                alpha[idx] = i;
            }
        }

        for(int i=0; i<alpha.length; i++) {
            System.out.print(alpha[i] + " ");
        }
    }
}
