package data_algorithm_code;

import java.util.Scanner;

public class AlgoJobsArray1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();

        int[] arr = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = scan.nextInt();
        }

        for (int j=n-1; j>=0; j--) {
            System.out.print(arr[j] + " ");
        }
    }
}
