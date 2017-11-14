package data_algorithm_code;

import java.util.Scanner;

/**
 * Created by parkdongjo on 2017. 10. 18..
 */
public class CodeForce_1B {

    private static String[] alpaArr = {"Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y"};


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();
        scan.nextLine();

        String[] strArr = new String[count];

        for (int i = 0; i < count; i++) {
            String in = scan.nextLine();
            String out = analysis(in);
            strArr[i] = out;
        }


        for(int i=0; i<count; i++) {
            System.out.println(strArr[i]);
        }
    }

    public static String analysis(String input) {
        String result = "";

        if (checkType(input)) {

            int idx = input.indexOf("C");
            long rowNum = Long.parseLong(input.substring(1, idx));
            long colNum = Long.parseLong(input.substring(idx + 1, input.length()));

            String colStr = colCalcByNum(colNum);
            result = colStr + rowNum + "";
        } else {
            int idx = 0;

            for(int i=0; i<input.length(); i++) {
                if(input.charAt(i)-48<10){
                    idx = i;
                    break;
                }
            }

            String col = input.substring(0, idx);
            String row = input.substring(idx, input.length());


            int colNum = colCalcByStr(col);
            result = "R"+row+"C"+colNum;

        }

        return result;
    }

    public static boolean checkType(String str) {

        int idx = str.indexOf("C");
        boolean result = true;
        if(idx != -1 && idx>1) {
            String secStr = str.substring(1, idx);

            try{
                Integer.parseInt(secStr);
            }catch (Exception e) {
                result = false;
            }
        }else{
            result = false;
        }

        return result;
    }

    public static String colCalcByNum(long num) {

        long quo = num;
        String[] remArr = new String[5];
        int idx = 0;
        while(quo / 26 != 0) {
            long rem = quo % 26;
            remArr[idx++] = alpaArr[(int)rem];
            quo = quo / 26;
        }

        String line = "";
        line += alpaArr[(int)quo];
        for(int i=idx-1; i>=0; i--) {
            line += remArr[i];

        }

        return line;
    }

    public static int colCalcByStr(String str) {
        int num = -1;

        for(int i=0; i<str.length(); i++) {

            String chat = str.charAt(i) + "";

            for(int j=0; j<alpaArr.length; j++) {
                if(chat.equals(alpaArr[j])) {
                    if(i==0) {
                        num = j;
                    }else{
                        num += j;
                    }

                    if(!(str.length() == 1) && !(i == str.length()-1)) {
                        num = num * 26;
                    }
                }
            }
        }

        return num;
    }

}
