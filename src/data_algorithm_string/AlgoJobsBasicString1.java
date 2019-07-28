package data_algorithm_code;

import java.util.Scanner;

public class AlgoJobsBasicString1 {

    /**
     [문제]
     문자열이 주어질 때, 대문자는 소문자로, 소문자는 대문자로 바꾸는 프로그램을 작성하시오.
     알파벳이 아닌 문자는 그대로 유지한다.

     [입력]
     첫 번째 줄에 문자열이 주어진다. ( 1 ≤ 문자열의 길이 ≤ 1,000 )

     [출력]
     문자열 내의 대문자는 소문자로, 소문자는 대문자로 바꾼 결과를 출력한다.


     예제 입력
     hELLO wORLD!
     예제 출력
     Hello World!
     */

    // a ~ z  097 ~ 122
    // A ~ Z  065 ~ 090

    //String[] arr = str.split("(?<!^)");
    //char[] chs = str.toCharArray();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();

        char[] charArr = str.toCharArray();

        for (int i=0; i<charArr.length; i++) {

            if (charArr[i] >= 97 && charArr[i] <= 122) {
                // 대문자
                charArr[i] = (char)((int) charArr[i] - 32);
            } else if (charArr[i] >= 65 && charArr[i] <= 90) {
                // 소문자
                charArr[i] = (char)((int) charArr[i] + 32);
            }
        }

        for (int i=0; i<charArr.length; i++) {
            System.out.print(charArr[i]);
        }
    }

}
