package data_algorithm_code;

import java.util.Scanner;

public class AlgoJobsBasicNumTheory6 {

    public static int[][] pascal = new int[31][31];
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

        int num = getNumInPascal(n,m);

        System.out.println(num);
    }


    public static int getNumInPascal(int n, int m) {
        int j;
        for (int i=0; i<31; i++) {

            for (j = 0; j<(i+1); j++) {
                if (j == 0 || j == i) {
                    pascal[i][j] = 1;
                } else {
                    pascal[i][j] = pascal[i-1][j] + pascal[i-1][j-1];
                }
            }

            if (i == n && (j-1)==m) {
                break;
            }
        }

        return pascal[n][m];
    }


}
