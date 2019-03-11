package data_algorithm_code;

import java.util.Scanner;

public class AlgoJobsBasicNumTheory1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int a;
        int b;
        int c;
        while (true) {
            a = scan.nextInt();
            b = scan.nextInt();
            c = scan.nextInt();

            if (a == 0 && b == 0 && c == 0) {
                break;
            }
            printComDiff(a,b,c);
        }
    }

    public static void printComDiff(int a, int b, int c) {

        int plusDiff = b - a;
        if (plusDiff + b == c) {
            System.out.println("AP "+(c+plusDiff));
            return;
        }

        int multiDiff = b / a;
        if (multiDiff * b == c) {
            System.out.println("GP "+(c*multiDiff));
            return;
        }

    }
}
