package data_algorithm_code;

import java.util.Scanner;
import java.util.Stack;

/**
 * 맞았습니다.
 */
public class BaeckjoonEx2908 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();

        a = convertNum(a);
        b = convertNum(b);

        System.out.println(compareNum(a,b));
    }
    public static int convertNum(int num) {
        String oldNum = num + "";
        String newNum = "";
        Stack stack = new Stack();

        for(int i=0; i<oldNum.length(); i++) {
            stack.add(oldNum.charAt(i) + "");
        }

        for(int i=0; i<oldNum.length(); i++) {
            newNum += stack.pop();
        }

        return Integer.parseInt(newNum);
    }

    public static int compareNum(int a, int b) {
        if(a>b) {
            return a;
        }else{
            return b;
        }
    }
}
