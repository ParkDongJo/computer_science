package data_algorithm_code;


import java.util.Scanner;
import java.util.Stack;

/**
 * Created by parkdongjo on 2017. 8. 25..
 */
public class BaekjoonEx9012 {
    public static void main(String [ ] args) {

        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();
        scan.nextLine();

        String[] strArr = new String[count];

        for(int i=0; i<count; i++) {
            strArr[i] = scan.nextLine();
        }

        for(int i=0; i<strArr.length; i++) {
            if(isVPS(strArr[i])) {
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }

    }

    public static boolean isVPS(String str) {

        Stack stack = new Stack();
        for (Character c : str.toCharArray()) {
            if(c.compareTo('(') == 0) {
                stack.add(c);
            }else{

                if(!stack.isEmpty()) {
                    stack.pop();
                }else{
                    return false;
                }
            }
        }//for() end

        if(!stack.isEmpty()) {
            return false;
        }

        return true;
    }
}
