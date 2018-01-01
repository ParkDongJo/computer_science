package data_algorithm_code;

import java.util.Scanner;

/**
 * Created by parkdongjo on 2017. 11. 28..
 */
public class BaeckjoonEx4344 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();


        for (int i = 0; i < n; i++) {
            String numStr = scan.nextLine();
            String[] numArr = numStr.split(" ");

            int sum = 0;
            for(int j=1; j< numArr.length; j++) {
                sum += Integer.parseInt(numArr[j]);
            }
            int all = Integer.parseInt(numArr[0]);
            float ev = (float) sum / all;

            int cnt = 0;
            for(int k=1; k< numArr.length; k++) {
                if(Float.parseFloat(numArr[k]) >  ev) {
                    cnt++;
                }
            }
            System.out.printf("%.3f",(float)cnt/all * 100);
            System.out.println("%");
        }
    }
}
