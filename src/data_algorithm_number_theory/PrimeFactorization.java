package data_algorithm_number_theory;

import java.util.ArrayList;
import java.util.Scanner;

public class PrimeFactorization {
    /*
     * 소인수 분해 원리
     * - N보다 작은 소수들을 나눠가면서 구한다.
     * - 소수를 알고 있는 상태가 아니므로 N보다 작은 수들을 차례대로 나눠본다.
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        ArrayList<Prime> list = calcPrimFactor(num);

        for (int i=0; i<list.size(); i++) {
            Prime prime = list.get(i);
            System.out.println(prime.num + " 소수 " + prime.count + " 개");
        }

        printPrimFactor(num);
    }

    public static ArrayList<Prime> calcPrimFactor(int num) {
        ArrayList<Prime> list = new ArrayList<Prime>();
        int share = num;
        int count = 0;

        for (int i=2; i<= num; i++) {

            if (share % i == 0) {
                while (share % i == 0) {
                    share = share / i;
                    count++;
                }
                list.add(new Prime(i, count));
                count = 0;
            }

            if (share == 1) {
                break;
            }
        }

        return list;
    }

    public static class Prime {
        public int num;
        public int count;

        public Prime(int _num, int _count) {
            this.num = _num;
            this.count = _count;
        }
    }


    /*
     * [모범 답안]
     * 알고 잡스의 풀이법
     */
    public static void printPrimFactor(int num) {

        for (int i=2; num>1; ) {
            if (num % i == 0) {
                System.out.println("소수 : " + i);
                num /= i;
            } else {
                i++;
            }
        }
    }

}
