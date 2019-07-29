package data_structure_sort_upgrade;

import java.util.Scanner;

/**
 * Created by parkdongjo on 2017. 6. 9..
 */
public class MergeSortVer1 {
    public static int[] arr = {10,3,1,5,4,7,9,2,6,8};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        mergeSort(arr);

        for(int i=0; i<n; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length -1);
    }

    private static void mergeSort(int[] arr, int[] temp, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, temp, start, mid);
            mergeSort(arr, temp, mid+1, end);
            merge(arr, temp, start, mid, end);
        }
    }

    private static void merge(int[] arr, int[] temp, int start, int mid, int end) {
        for (int i=start; i<=end; i++) {
            temp[i] = arr[i];
        }
        int part1 = start;
        int part2 = mid + 1;
        int index = start;

        while (part1 <= mid && part2 <= end) {
            if (temp[part1] <= temp[part2]) {
                arr[index] = temp[part1];
                part1++;
            } else {
                arr[index] = temp[part2];
                part2++;
            }
            index++;
        }
        for (int i=0; i<= mid - part1; i++) {
            arr[index + i] = temp[part1 + i];
        }
    }
}
