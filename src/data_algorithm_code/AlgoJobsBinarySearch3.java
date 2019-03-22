package data_algorithm_code;

import java.util.Arrays;
import java.util.Scanner;

public class AlgoJobsBinarySearch3 {
    /*
    [문제]
    n개의 숫자가 주어지고, q개의 질문이 주어진다. 각각의 질문은 n개의 숫자 중에서 특정 숫자가 몇개나 있는지를 묻는다.
    q개의 질문에 모두 답하는 프로그램을 작성하시오.

    [입력]
    첫 번째 줄에 숫자의 개수 n, 그리고 질문의 개수 q가 주어진다 ( 1 ≤ n ≤ 100,000, 1 ≤ q ≤ 100,000)
    두 번째 줄에 n개의 숫자가 주어진다. 세 번째 줄에 q개의 질문이 주어진다. 주어지는 q개의 질문은 모두 2000이하이다.

    [출력]
    각 질문에 대하여 숫자의 개수를 한 줄에 하나씩 출력한다.

    [예제]
    예제 입력
    10 4
    1 3 4 3 2 3 1 2 5 10
    1 3 9 10
    예제 출력
    2
    3
    0
    1
     */
    public static final int NOT_FOUND_VALUE = -1;
    public static int[] countNums = new int[2001];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int q = scan.nextInt();
        int[] nums = new int[n];
        int[] qArr = new int[q];

        for(int i=0; i<n; i++) {
            nums[i] = scan.nextInt();
        }
        Arrays.sort(nums);

        for(int i=0; i<q; i++) {
            qArr[i] = scan.nextInt();
            int result = binarySearch(nums, 0, nums.length-1, qArr[i]);
            if (result != NOT_FOUND_VALUE) {
                countNum(nums, result, result, qArr[i]);
            }
        }

        for (int qNum : qArr) {
            System.out.println(countNums[qNum]);
        }
    }

    public static int binarySearch(int[] arr, int start, int end, int value) {
        if (start > end) {
            return -1;
        } else if (start == end) {
            if (arr[start] == value) {
                return start;
            } else {
                return -1;
            }
        } else {
            int mid = (start + end) / 2;

            if (arr[mid] == value) {
                return mid;
            } else if (arr[mid] > value) {
                return binarySearch(arr, start, mid-1, value);
            } else {
                return binarySearch(arr, mid+1, end, value);
            }
        }
    }

    public static void countNum(int[] arr, int pivot, int cursor, int value) {
        if (cursor < 0 || cursor > arr.length-1) {
            return;
        }
        if (value != arr[cursor]) {
            return;
        } else {
            countNums[value] += 1;
        }

        if (cursor <= pivot) {
            countNum(arr, pivot, cursor-1, value);
        }
        if (cursor >= pivot) {
            countNum(arr, pivot, cursor+1, value);
        }
    }
}
