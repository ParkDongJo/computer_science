package data_algorithm_code;

import java.util.Scanner;

/**
 * 맞혔습니다.
 */
public class BaeckjoonEx1924 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int month = scan.nextInt();
        int day = scan.nextInt();
        int sMonth = 1;
        String[] yoilArr = {"MON","TUE","WED","THU","FRI","SAT","SUN"};
        //해당 월의 시작 요일 인덱스를 가져옴
        int sYoilIdx = getStartYoil(sMonth,month,1) % 7;

        int pass = 7-(sYoilIdx-1);
        int tYoilIdx = -1;
        if(pass <= day) {
            tYoilIdx = (day - pass) % 7;
        }else{
            tYoilIdx = (day + (sYoilIdx-1)) % 7;
        }

        if(tYoilIdx == 0) {
            System.out.println(yoilArr[6]);
        }else{
            System.out.println(yoilArr[tYoilIdx-1]);
        }
    }

    public static int getStartYoil(int cMonth, int tMonth, int ySum) {
        int month = cMonth;

        if(month == tMonth) {
            return ySum;
        }

        int days = 31;
        switch (month) {
            case 2: days = 28; break;
            case 4: days = 30; break;
            case 6: days = 30; break;
            case 9: days = 30; break;
            case 11: days = 30; break;
        }

        int rest = days % 7;
        ySum = rest + ySum;

        return getStartYoil(++month, tMonth, ySum);
    }
}
