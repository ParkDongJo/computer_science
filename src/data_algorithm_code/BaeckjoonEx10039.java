package data_algorithm_code;

import java.util.Scanner;

/**
 * 맞았습니다.
 */
public class BaeckjoonEx10039 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sum = 0;

        for(int i=0; i<5; i++) {
            int score = scan.nextInt();
            if(score < 40) {
                score = 40;
            }
            sum += score;
        }
        System.out.println(sum/5);

    }
}
