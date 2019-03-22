package data_algorithm_basic;

import java.math.BigInteger;
import java.util.Scanner;

public class StringBasic {
    public static void main(String[] args) {
        // scanner.next() 와 scanner.nextLine() 의 차이점
        // next()는 공백을 기점으로 하나의 문자열만 가져온다.
        // nextLine()은 공백,줄바꿈 상관없이 한줄로 가져온다.
        /**
         * [주의]
         * scan.nextLine() 이후
         * scan.nextInt() 또는 scan.nextLong() 처럼 다른 타입을 가지고 오려고 할 때,
         * 앞선 nextLine() 때문에 잘못된 타입으로 인식을 하게 된다.
         */
        Scanner scan = new Scanner(System.in);
//        String str = scan.next();
//        String line = scan.nextLine();


        /*
            2.
         */
        // String을 char[]로 바꾸기
        // String 클래스 내부에 toCharArray()라는 메서드가 지원된다.
        String str2 = "abcd";
        char[] charArr = str2.toCharArray();

        // char[] 배열을 다시 string 타입으로 바꾸기
        String newStr = String.valueOf(charArr);



        /*
            3.
         */
        // 문자열에 특정 문자열 포함 여부
        // String 클래스 내부에
        String str3 = "watermelon";
        String str4 = "melon";
        System.out.println(str3.contains(str4));
        // true

        String str5 = "hello everyone";
        String str6 = "everyone";
        System.out.println(str5.contains(str6));
        // true


        /*
            4.
         */
        /*
        int : -2147483648 ~ 2147483647
        long : -9223372036854775808 ~ 9223372036854775807
         */
        // long으로도 표현할 수 없는 숫
        // String 클래스 내부에
        String aBigNumber = "1000000000000000000";
        String bBigNumber = "1000000000000000000";
        BigInteger a = new BigInteger(aBigNumber);
        BigInteger b = new BigInteger(bBigNumber);
        System.out.print(a.add(b));

    }
}
