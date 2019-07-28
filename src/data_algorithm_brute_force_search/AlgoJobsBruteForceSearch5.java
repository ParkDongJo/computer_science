package data_algorithm_code;

import java.util.ArrayList;
import java.util.Scanner;

public class AlgoJobsBruteForceSearch5 {
    /*
        두 개의 자연수를 입력받아 최대공약수(GCD)와 최소공배수(LCM)를 출력하는 프로그램을 작성하시오.

        첫째 줄에는 두 개의 자연수가 주어진다. 이 둘은 10,000 이하의 자연수이며 사이에 한 칸의 공백이 주어진다.

        첫째 줄에는 입력으로 주어진 두 수의 최대공약수를, 둘째 줄에는 입력으로 주어진 두 수의 최소공배수를 출력한다.
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();

        ArrayList<Integer> aDivisors = getDivisors(a);
        ArrayList<Integer> bDivisors = getDivisors(b);

        int gcd = 0;

        for (int i=0; i<aDivisors.size(); i++) {
            for (int j=0; j<bDivisors.size(); j++) {
                if (aDivisors.get(i) == bDivisors.get(j)) {
                    gcd = Math.max(gcd, aDivisors.get(i));
                }
            }
        }

        int lcm = (a / gcd) * (b / gcd) * gcd;

        System.out.println(gcd);
        System.out.println(lcm);
    }

    public static ArrayList<Integer> getDivisors(final int num) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i=1; i<=num; i++) {
            if (num%i == 0) {
                list.add(i);
            }
        }
        return list;
    }

}
