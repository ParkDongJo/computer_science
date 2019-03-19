package data_algorithm_code;

import java.util.Scanner;

public class AlgoJobsRecursiveFunc3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        pattern(n);
    }

    public static void pattern(int n) {
        if (n == 1) {
            System.out.print(1);
        } else {
            // 전위
            pattern(n-1);
            // 중위
            System.out.print(n);
            pattern(n-1);
            // 후위
        }
    }
}
