package data_structure_sort_upgrade;

import java.util.Scanner;

/**
 * Created by parkdongjo on 2017. 6. 9..
 */
public class QuickSortVer2 {
    /*
        [Quick sort 디자인]
        1. 원소 하나를 정하여, 해당 원소보다 작은 수들과 큰 수로 나누어 정렬한다.
        2. 남은 요소가 한개이거나 아예 없거나
        3. left[] + [pivot] + right[]
     */
    /*
        myLeft[] myRight[]
        pivot = arr[start]

        getLeft(arr[], s+1, e, pivot, left[])
        getRight(arr[], s+1, e, pivot, left[])

     */

    public static void main(String[] args) {
        int[] array = {10,3,1,5,4,7,9,2,6,8};
        print(array);
        quickSort(array, 0, array.length - 1);
        print(array);
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int[] left = new int[100];
        int[] right = new int[100];
        int pivot = arr[start];

        int leftCnt = getLeft(arr, start+1, end, pivot, left);
        int rightCnt = getRight(arr, start+1, end, pivot, right);

        for (int i=0; i<leftCnt; i++) {
            arr[start + i] = left[i];
        }
        arr[start + leftCnt] = pivot;
        for (int i=0; i<rightCnt; i++) {
            arr[start + leftCnt + 1 + i] = right[i];
        }

        quickSort(arr, start,start+leftCnt-1);
        quickSort(arr, start+leftCnt+1, end);
    }

    public static int getLeft(int[] arr, int start, int end, int pivot, int[] left) {
        int idx = 0;
        for (int i=start; i<=end; i++) {
            if (pivot >= arr[i]) {
                left[idx++] = arr[i];
            }
        }

        return idx;
    }

    public static int getRight(int[] arr, int start, int end, int pivot, int[] right) {
        int idx = 0;
        for (int i=start; i<=end; i++) {
            if (pivot < arr[i]) {
                right[idx++] = arr[i];
            }
        }
        return idx;
    }

    public static void print(int[] array) {
        for (int i=0; i<array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
