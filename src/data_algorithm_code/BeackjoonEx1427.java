package data_algorithm_code;

import java.util.Scanner;

public class BeackjoonEx1427 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String numStr = scan.nextLine();


        int[] countArr = new int[10];
        int[] numArr = new int[numStr.length()];
        int[] resultArr = new int[numStr.length()];

        for(int i=0; i<numStr.length(); i++) {
            int num = Integer.parseInt(numStr.charAt(i)+"");
            numArr[i] = num;

            int cnt = countArr[num];
            countArr[num] = cnt + 1;
        }

        int accumulateNum = 0;
        for(int i=0; i<countArr.length; i++) {
            accumulateNum += countArr[i];

            if(countArr[i] != 0) {
                countArr[i] = accumulateNum;
            }
        }

        for(int i=0; i<numArr.length; i++) {
            resultArr[countArr[numArr[i]]-1] = numArr[i];
        }

        int standNum = 0;
        for(int i=resultArr.length-1; i>=0; i--) {
            if(resultArr[i] == 0) {
                resultArr[i] = standNum;
            }else{
                standNum = resultArr[i];
            }
        }

        for(int i=0; i<resultArr.length; i++) {
            System.out.print(resultArr[i]);
        }

    }
}
