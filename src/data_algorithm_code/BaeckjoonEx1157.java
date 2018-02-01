package data_algorithm_code;

import java.util.Scanner;

/**
 * 맞았습니다.
 */
public class BaeckjoonEx1157 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] alphabet = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        int[] alpha = new int[26];


        for(int i=0; i<alpha.length; i++) {
            alpha[i] = 0;
        }

        for(int i=0; i<str.length(); i++) {
            Character c = str.charAt(i);
            int idx = 0;

            if(c > 90) {
                idx = c - 97;
            }else{
                idx = c - 65;
            }

            alpha[idx] = alpha[idx] + 1;
        }

        int maxIdx = 0;
        int max = -1;
        boolean dual = false;
        for(int i=0; i<alpha.length; i++) {

            if(max <= alpha[i]) {
                if(max != 0 && max == alpha[i]) {
                    dual = true;
                }
                if(max != 0 && max < alpha[i]) {
                    dual = false;
                }
                maxIdx = i;
                max = alpha[i];
            }
        }


        if(dual) {
            System.out.println("?");
        }else{
            System.out.println(alphabet[maxIdx]);
        }
    }
}
