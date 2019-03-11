package data_algorithm_number_theory;

import java.util.ArrayList;
import java.util.Scanner;

public class Divisor {
    /*
     *  약수를 구하는 원리
     *  약수 - N 이라는 수의 약수들을 구할 때,
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        ArrayList<Integer> list = getDivisor(num);

        for (int i=0; i<list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }

    public static ArrayList<Integer> getDivisor(int num) {
        ArrayList<Integer> divisors = new ArrayList<Integer>();

        for (int i=0; i<=num; i++) {
            if (num % i == 0) {
                divisors.add(i);
            }
        }

        return divisors;
    }
}
