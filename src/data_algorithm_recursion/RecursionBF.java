package data_algorithm_recursion;

import java.util.Scanner;

public class RecursionBF {
    /*
        [순열 구하기]
        N개의 알파벳중에 R개를 나열할 수 있는 경우 출력
     */

    public static final int MAX = 100;

    public static int n,r;
    public static char[] result = new char[MAX];
    public static boolean[] check = new boolean[MAX];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        r = scan.nextInt();

        printCase(n);
    }

    public static void printCase(int x) {

        if (x >= r) {
            System.out.print(result);
        } else {

            for (int i=0; i<n; i++) {
                char alpha = (char) (i + 'a');

                if (!check[i]) {
                    /*----------------*/
                    result[x] = alpha;
                    check[i] = true;
                    printCase(x+1);
                    /*----------------*/
                    // x번째에 i를 넣는 경우를 모두 고려 하였음

                    check[i] = false;
                }
            }
        }
    }
}
