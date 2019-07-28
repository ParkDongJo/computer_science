package data_algorithm_code;

import java.util.Scanner;
import java.util.Stack;

public class AlgoJobsBasicString6 {

    /**
     [문제]
     문자열이 주어질 때, 이것이 팰린드롬인지 조사하는 프로그램을 작성하시오.
     팰린드롬이란, 앞으로 읽을 때와 뒤로 읽을 때의 결과가 같은 문자열을 말한다.

     [입력]
     첫 번째 줄에 문자열이 주어진다. ( 1 ≤ 문자열의 길이 ≤ 1,000 )

     [출력]
     입력된 문자열이 팰린드롬이면 YES, 아니면 NO를 출력한다.

     [예제]
     예제 입력
     abcba
     예제 출력
     YES

     예제 입력
     abcbd
     예제 출력
     NO
     */

    // String text = String.copyValueOf(data);
    // String text = String.valueOf(data);
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();

        char[] charArr = str.toCharArray();
        Stack<Character> stack = new Stack<Character>();

        for (int i=0; i<charArr.length; i++) {
            stack.add(charArr[i]);
        }

        for (int i=0; i<charArr.length; i++) {
            charArr[i] = stack.pop();
        }

        String newStr = String.valueOf(charArr);

        if (str.equals(newStr)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

}
