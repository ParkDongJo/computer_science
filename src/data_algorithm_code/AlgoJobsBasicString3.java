package data_algorithm_code;

import java.util.Scanner;
import java.util.Stack;

public class AlgoJobsBasicString3 {

    /**
     [문제]
     문자열이 주어질 때, 이를 뒤집어서 출력하는 프로그램을 작성하시오.

     [입력]
     첫 번째 줄에 문자열이 주어진다. ( 1 ≤ 문자열의 길이 ≤ 1,000 )

     [출력]
     문자열을 뒤집은 결과를 출력한다.

     [예제]
     예제 입력
     Hello World!
     예제 출력
     !dlroW olleH
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        char[] charArr = str.toCharArray();
        Stack<Character> stack = new Stack<Character>();

        for (int i=0; i<charArr.length; i++) {
            stack.push(charArr[i]);
        }

        for (int i=0; i<charArr.length; i++) {
            System.out.print(stack.pop());
        }
    }

}
