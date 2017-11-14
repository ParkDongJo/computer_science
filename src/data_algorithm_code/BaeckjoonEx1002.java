package data_algorithm_code;

import java.util.Scanner;

/**
 * Created by parkdongjo on 2017. 11. 8..
 */
public class BaeckjoonEx1002 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();
        scan.nextLine();

        for(int i=0; i<count; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            int r = scan.nextInt();
            int x2 = scan.nextInt();
            int y2 = scan.nextInt();
            int r2 = scan.nextInt();
            double d =getDistance(x,y,x2,y2);
            int num = calc(r,r2,d);
            System.out.println(num);
            scan.nextLine();
        }
    }

    public static int calc(int r, int r2, double d) {
        double dr = (double) r;
        double dr2 = (double) r2;
        int num = -1;

        if(dr2-dr < d && dr+dr2 > d) {
            num = 2;
        }else if(dr+dr2 == d || (0!=d && dr2-dr == d)){
            num = 1;
        }else if(dr+dr2 < d || dr2-dr > d || (d==0 && dr != dr2)){
            num = 0;
        }else if(dr == dr2 && d==0){
            num = -1;
        }
        return num;
    }

    public static double getDistance(int x, int y, int x2, int y2) {
        return Math.sqrt((x-x2)*(x-x2)+(y-y2)*(y-y2));
    }
}