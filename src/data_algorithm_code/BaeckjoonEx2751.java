package data_algorithm_code;

import java.util.Scanner;

/**
 * 병합 정렬로 풀어보기 지금 정렬 알고리즘으로는 속도가 안나옴
 */

public class BaeckjoonEx2751 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
//        scan.nextLine();
//        int[] arr = new int[n];
//
//        for(int i=0; i<n; i++) {
//            arr[i] = scan.nextInt();
//        }
        int [] arr = {5,4,3,2,1};
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
