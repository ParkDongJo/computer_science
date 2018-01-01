package data_algorithm_code;

import java.util.Scanner;
import java.util.Stack;

/**
 * 아작 문제 푸는 중
 */
public class BaeckjoonEx2448 {

    public static String[] stars = {"*****","     "," * * ","     ","  *  "};
    public static Stack<String> basket = null;

    public static void main(String[] args) {
        basket = new Stack<String>();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int exp = getExp(n);

        System.out.println(exp);

        for(int i=0; i<exp; i++) {

            makeTrangle(exp);
        }

        printTrangle();
//        printEmpty();
//        printTrangle();

    }

    /**
     *    *
     *
     *   * *
     *
     *  *****
     *
     * 5*5 박스에서 빈공간과 *를 잘 체크해야함
     * 함수() 영역 이니까, 함수로 분리시키고, 재귀함수로 풀어야 할 듯
     * 패턴을 만들수 있는 부분을 찾아야 할듯
     */
    public static int getExp(int n) {
        int m = n / 3;
        int i;
        for(i=0; m>=2; i++) {
            m = m/2;
        }
        return i;
    }

    public static void makeTrangle(int n) {
        for(int i=0; i<stars.length; i++) {
            for(int j=0; j<n*2; j++) {
                if(j!=0) basket.add(" ");
                basket.add(stars[i]);
            }

            if(i!=stars.length-1) basket.add("\n");
        }
    }

    public static void printTrangle() {
        int size = basket.size();

        for(int i=0; i<size; i++) {
            System.out.print(basket.pop());
        }
    }

}
