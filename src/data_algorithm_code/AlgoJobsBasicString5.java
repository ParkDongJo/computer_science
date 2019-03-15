package data_algorithm_code;

import java.util.Scanner;

public class AlgoJobsBasicString5 {

    /**
     [문제]
     문자열 A와 B가 주어질 때, 문자열 B가 문자열 A에 포함되어 있는지를 조사하는 프로그램을 작성하시오.
     단, 문자열 A와 B에는 알파벳으로만 이루어져 있으며, 공백은 포함되지 않는다고 가정한다.

     [입력]
     첫 번째 줄에 문자열 A, 두 번째줄에 문자열 B가 주어진다. 각각의 길이는 1,000을 넘지 않는다.

     [출력]
     문자열 B가 문자열 A에 포함되면 YES, 아니면 NO를 출력한다.

     [예제]
     예제 입력
     Watermelon
     melon

     예제 출력
     YES
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String longStr = scan.nextLine();
        String shortStr = scan.nextLine();

        char[] lCharArr = longStr.toCharArray();
        char[] sCharArr = shortStr.toCharArray();

        int equalCnt = 0;
        String result = "NO";

        for (int i=0; i<lCharArr.length; i++) {
            if (lCharArr[i] == sCharArr[0]) {

                for (int j=0; j<sCharArr.length; j++) {
                    if (lCharArr[j+i] == sCharArr[j]) {
                        equalCnt++;
                    }
                }

                if (equalCnt == sCharArr.length) {
                    result = "YES";
                    break;
                } else {
                    equalCnt = 0;
                }
            }
        }

        System.out.println(result);
    }

}
