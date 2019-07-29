package data_structure_sort_upgrade;

import java.util.Scanner;

/**
 * Created by parkdongjo on 2017. 6. 9..
 */
public class QuickSortVer1 {
    public static int[] arr = {10,3,1,5,4,7,9,2,6,8};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = 5;

        quickSort(arr);

        for(int i=0; i<n; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length-1);
    }

    public static void quickSort(int[] arr, int start, int end) {
        int part2 = partition(arr, start, end);
        if (start < part2 -1) {
            quickSort(arr, start, part2 -1);
        }

        if (part2 < end) {
            quickSort(arr, part2, end);
        }
    }
    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[(start + end) / 2];

        while (start <= end) {
            while (arr[start] < pivot) start++;
            while (arr[end] > pivot) end--;

            if (start <= end) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }
        return start;
    }
    private static void swap(int[] arr, int start, int end) {
        int tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
    }
}
