package data_algorithm_code;

import java.util.Scanner;

public class AlgoJobsRecursiveFunc2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        printBinary(n);
    }

    public static void printBinary(int n) {
        if (n == 0) {
            System.out.print(0);
        } else if (n == 1) {
            System.out.print(1);
        } else {
            printBinary(n/2);
            System.out.print(n%2);
        }
    }
}
