package data_algorithm_number_theory;

import java.util.Scanner;

public class Prime {

    /*
     * 소수를 구하는 원리
     * - 약수가 1과 자기자신밖에 없는 수
     * - N이라는 수가 소수인지 확인하기 위해서는 1과 자기자신으로만 나뉘에 지면 됨
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        boolean result = checkPrime(num);

        System.out.println(result);
    }

    public static boolean checkPrime(int num) {
        boolean result = true;

        for (int i=0; i<num; i++) {

            if (num % i == 0 && (i != 1 && i == num)) {
                result = false;
            }
        }

        return result;
    }
}
