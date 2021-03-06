package data_algorithm_code;

import java.util.Scanner;

public class AlgoJobsBasicNumTheory8 {


    /**
     [문제]
     정수 B를 0보다 큰 정수인 N으로 곱해 정수 A를 구할 수 있다면 A는 B의 배수이다.
     예:
     10은 5의 배수이다 (5 * 2 = 10)
     10은 10의 배수이다(10 * 1 = 10)
     6은 1의 배수이다(1 * 6 = 6)
     20은 1, 2, 4, 5, 10, 20의 배수이다.
     다른 예:

     2와 5의 최소공배수는 10이고, 그 이유는 10은 2와 5 둘 다의 배수이고, 10보다 작은 공배수가 없기 때문이다.
     10과 20의 최소공배수는 20이다.
     5와 3의 최소공배수는 15이다.
     당신은 두 수에 대하여 최소공배수를 구하는 프로그램을 작성 하는 것이 목표이다.

     [입력]
     한 줄에 두 자연수 A와 B가 공백으로 분리되어 주어진다.
     A와 B는 100,000,000(10^8)보다 작다.
     참고: 큰 수 입력에 대하여 변수를 64비트 정수로 선언하시오. C/C++에서는 long long int(%lld)를 사용하고,
     Java에서는 long을 사용하시오.

     [출력]
     A와 B의 최소공배수를 한 줄에 출력한다.

     */

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long n = scan.nextLong();
        long m = scan.nextLong();

        long num = gcd(n, m);

        long lcm = (n / num) * (m / num) * num;

        System.out.print(lcm);
    }

    private static long gcd(long a, long b) {
        if(b==0){
            return a;
        }
        else{
            return gcd(b, a%b);
        }
    }


//    public static int[] memo = new int[46];
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        long n = scan.nextInt();
//        long m = scan.nextInt();
//
//        long max = Math.max(n, m);
//        long min = Math.min(n, m);
//
//        long gcd = getGCD(max, min);
//        long lcm = (n / gcd) * (m / gcd) * gcd;
//        System.out.println(lcm);
//
//    }
//
//    public static long getGCD(long max, long min) {
//        long a = max, b = min;
//        long remain = 1;
//        long temp;
//
//        while (remain > 0) {
//            remain = a % b;
//
//            temp = b;
//            b = remain;
//            a = temp;
//        }
//        return a;
//    }

}
