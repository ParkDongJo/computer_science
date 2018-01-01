package data_algorithm_code;

import java.util.Scanner;

/**
 * 맞았습니다.
 */
public class BaeckjoonEx8958 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();

        for(int i=0; i<n; i++) {
            String str = scan.nextLine();
            int tot = checkSuccess(str);
            System.out.println(tot);

        }
    }
    public static int checkSuccess(String str) {
        int tot = 0;
        int score = 0;
        for(int i=0; i<str.length(); i++) {
            String c = str.charAt(i) + "";
            if(c.equals("O")) {
                score++;
                tot += score;
            }

            if(c.equals("X")) {
                score = 0;
            }

        }

        return tot;
    }
}
