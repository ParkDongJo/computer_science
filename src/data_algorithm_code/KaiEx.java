package data_algorithm_code;

import java.util.Scanner;

/**
 * Created by parkdongjo on 2017. 9. 6..
 */
public class KaiEx {

    private static int[] feeArr;
    private static int[][] quotientArr;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int money = scan.nextInt();
        scan.nextLine();

        int cnt = scan.nextInt();
        feeArr = new int[cnt];
        quotientArr = new int[cnt][cnt];

        for(int i=0; i<cnt; i++) {
            feeArr[i] = scan.nextInt();
        }

        calc(money);
    }

    public static int calc(int money) {

//        for(int i=0; i<feeArr.length; i++) {
//            quotientArr[i][]
//        }
//
//        if(feeArr[]) {
//
//        }

        return 0;
    }


}
