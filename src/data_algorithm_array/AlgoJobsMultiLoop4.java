package data_algorithm_code;

import java.util.ArrayList;
import java.util.Scanner;

public class AlgoJobsMultiLoop4 {
    /*
     자연수n,m이 주어질 때, n부터 m까지 존재하는 소수를 모두 출력하는 프로그램을 작성하여라.
     여기서 소수란, 약수가 1과 자기자신밖에 존재하지 않는 수를 말한다.

     [입력]
     첫째 줄에 자연수 n, m이 주어진다. (1≤n,m≤20,000)

     [출력]
     첫째 줄에 n부터m까지 존재하는 소수를 모두 출력한다.

     [예제입력]
     1 10

     [예제출력]
     2 3 5 7
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int start = scan.nextInt();
        int end = scan.nextInt();



        ArrayList<Integer> prime = getPrime(end);

        for (Integer result : prime) {
            if (result >= start) {
                System.out.print(result + " ");
            }
        }
    }

    public static ArrayList<Integer> getPrime(int num) {
        ArrayList<Integer> prime = new ArrayList<Integer>();
        prime.add(2);

        for (int i = 2; i <= num; i++) {
            for (int j = 0; prime.size() > j; j++) {

                if (i % prime.get(j) == 0) break;

                if (j == prime.size() - 1) {
                    prime.add(i);
                }
            }
        }
        return prime;
    }
}
