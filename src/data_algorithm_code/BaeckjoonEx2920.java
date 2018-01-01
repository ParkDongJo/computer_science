package data_algorithm_code;

import java.util.Scanner;
import java.util.Stack;

/**
 * 맞았습니다.
 */
public class BaeckjoonEx2920 {

    private static int[] ascArr = {1,2,3,4,5,6,7,8};
    private static int[] desArr = {8,7,6,5,4,3,2,1};


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String toneStr = scan.nextLine();
        int ascCnt = 0;
        int desCnt = 0;

        String[] toneArr = toneStr.split(" ");

        for(int i=0; i<toneArr.length; i++) {
            int tone = Integer.parseInt(toneArr[i]);
            if(tone == ascArr[i]) {
                ascCnt++;
            }

            if(tone == desArr[i]) {
                desCnt++;
            }
        }

        if(ascCnt == 8) {
            System.out.println("ascending");
        }else if(desCnt == 8) {
            System.out.println("descending");
        }else{
            System.out.println("mixed");
        }

    }
}
