package data_algorithm_code;

import java.util.Scanner;

public class BaeckjoonEx2751 {

    private static int[] arr;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = scan.nextInt();
        }

        int j = -1;
        int cursor = -1;

        for(int i=1; i<n; i++) {
            j = i-1;
            cursor = i;

            while (j>=0) {

                if(arr[cursor] < arr[j]){
                    swap(cursor,j);
                    cursor--;
                }

                j--;
            }
        }

        for(int i=0; i<n; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
