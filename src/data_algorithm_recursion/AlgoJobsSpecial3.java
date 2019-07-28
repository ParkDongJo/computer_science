package data_algorithm_code;

import java.util.Scanner;

public class AlgoJobsSpecial3 {
    // 재귀에서 필요한 변수는 전역으로 해놔라
    public static int[] array= new int[30];
    public static int n, k;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();

        f(0,0);
    }

    // 중복 처리가 안되 있음
    // 의미 :
    public static void f(int sum, int length) {
        if (sum == n) {
            for (int i=0; i<length; i++) {
                System.out.print(array[i]);
            }
            System.out.println("");
            return;
        }
        if (sum > n) {
            return;
        }

        for (int i=n-1; i>=1; i--) {
            array[length] = i;
            f(sum+i, length+1);
        }
    }

}
