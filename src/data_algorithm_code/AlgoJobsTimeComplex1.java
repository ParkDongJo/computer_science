package data_algorithm_code;

import java.util.Arrays;
import java.util.Scanner;

public class AlgoJobsTimeComplex1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] array = new int[n];

        for (int i=0; i<n; i++) {
            array[i] = scan.nextInt();
        }

        Arrays.sort(array);

        for (int i=n-1; i>=0; i--) {

            if (i == (n-k)) {
                System.out.print(array[i]);
            }
        }

    }

}
