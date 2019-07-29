package data_structure_sort_upgrade;

import java.util.Scanner;

/**
 * Created by parkdongjo on 2017. 6. 9..
 */
public class MergeSortVer2 {
    /*
        [Merge sort 디자인]
        1. 재귀호출을 통한 합병정렬
        2. 한개의 요소가 남을때 까지 분할
        3. 분할 된 두 정렬 배열을 하나로 합치는 과정
     */
    /*
        mid = (start + end) / 2
        mergeSort(arr, start, mid)
        mergeSort(arr, mid + 1, end)
        merging(start, mid, mid+1, end)
     */
    public static void main(String[] args) {

//        int[] array = {10,3,1,5,4,7,9,2,6,8};
        int[] array = {10,3,1,5};
        print(array);
        mergeSort(array, 0, array.length - 1);
        print(array);
    }

    // start ~ end까지 arr 배열을 정렬 시켜주는 함수
    // start == end가 되는 순간 (= 요소가 하나가 되는 순간)
    public static void mergeSort(int[] arr, int start, int end) {

        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;

        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);

        merge(arr, start, mid, mid + 1, end);
    }

    public static void merge(int[] arr, int start1, int end1, int start2, int end2) {
        int cursor1, cursor2;
        int[] temp = new int[100];
        int idx = 0;

        cursor1 = start1;
        cursor2 = start2;

        while (cursor1 <= end1 && cursor2 <= end2) {

            if (arr[cursor1] <= arr[cursor2]) {
                temp[idx++] = arr[cursor1];
                cursor1++;
            } else {
                temp[idx++] = arr[cursor2];
                cursor2++;
            }

        }

        if (cursor1 <= end1) {
            for (int i=cursor1; i<=end1; i++) {
                temp[idx++] = arr[i];
            }
        }

        if (cursor2 <= end2) {
            for (int i=cursor2; i<=end2; i++) {
                temp[idx++] = arr[i];
            }
        }

        for (int i=start1; i<=end2; i++) {
            arr[i] = temp[i-start1];
        }
    }

    public static void print(int[] array) {
        for (int i=0; i<array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}
