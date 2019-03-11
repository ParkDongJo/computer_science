package data_algorithm_code;

import java.util.ArrayList;
import java.util.Scanner;

public class AlgoJobsBruteForceSearch19 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] matrix = new int[n][3];

        // 숫자, 점수 저장
        for (int i=0; i<n; i++) {
            matrix[i][0] = scan.nextInt();
            matrix[i][1] = scan.nextInt();
            matrix[i][2] = scan.nextInt();
        }


        int count;
        ArrayList<Integer> ableList = new ArrayList<Integer>();
        for (int target=123; target<=987; target++) {
            count = 0;
            for (int i=0; i<n; i++) {

                if (compareScore(target, matrix[i][0], matrix[i][1] ,matrix[i][2])) {
                    count++;
                }
            }

            if (count == n) {
                ableList.add(target);
            }
        }

        // 결과 프린트
        System.out.println(ableList.size());
    }

    public static boolean compareScore(int a, int b, int _strike, int _ball) {
        int[] aArr = makeNumArr(a);
        int[] bArr = makeNumArr(b);
        int strike = 0;
        int ball = 0;
        int num;

        if (!isValid(aArr)) {
            return false;
        }

        for (int i=0; i<3; i++) {
            num = aArr[i];
            for (int j=0; j<3; j++) {

                if (i == j && num == bArr[j]) {
                    // 스트라이크
                    strike += 1;
                    break;
                } else if (i != j && num == bArr[j]) {
                    // 볼
                    ball += 1;
                    break;
                }
            }
        }

        if (strike == _strike && ball == _ball) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isValid(int[] numArr) {
        boolean result = true;

        if(numArr[0] == numArr[1] && numArr[1] == numArr[2]) {
            result = false;
        }
        return result;
    }

    public static int[] makeNumArr(int num) {
        String numStr = num + "";
        int[] numArr = new int[3];
        for (int i=0; i<3; i++) {
            try {
                numArr[i] = Integer.parseInt(numStr.substring(i, i+1));
            } catch (Exception e) {}
        }

        return numArr;
    }
}
