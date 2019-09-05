package data_algorithm_code;

import java.util.Arrays;
import java.util.Scanner;

public class AlgoJobsMergeSort {
    /*
    [문제]
    서로 다른 n개의 정수가 주어질 때, 이를 합병정렬을 이용하여 오름차순으로 정렬하는 프로그램을 작성하시오.

    [입력]
    첫 번째 줄에 n이 주어진다. ( 1 ≤ n ≤ 100,000 ) 두번째 줄에 n개의 정수가 주어진다.

    [출력]
    첫 번째 줄에 n개의 숫자를 합병정렬을 이용하여 오름차순으로 정렬한 결과를 출력한다.

    [예제]
    예제 입력
    10
    2 5 3 4 8 7 -1 9 10 2
    예제 출력
    -1 2 2 3 4 5 7 8 9 10

     */
    public static int n = 10;

    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        n = scan.nextInt();
//        int[] array = new int[n];
//        for (int i=0; i<n; i++) {
//            array[i] = scan.nextInt();
//        }
        int[] array = {10,3,1,5,4,7,9,2,6,8};


        mergeSort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }

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
        int[] temp = new int[n];
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

}
