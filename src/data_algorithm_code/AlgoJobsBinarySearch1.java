package data_algorithm_code;

import java.util.Scanner;

public class AlgoJobsBinarySearch1 {
    /*
    [문제]
    n개의 오름차순으로 정렬된 숫자가 주어지고, 그 후 q개의 질문이 주어진다.
    각각의 질문은 특정 숫자가 n개의 숫자 내에 존재하는지를 판별하는 것이다.
    모든 q개의 질문에 대하여 답을 하는 프로그램을 작성하시오.

    [입력]
    첫 번째 줄에 숫자의 개수 n, 그리고 질문의 개수 q가 주어진다 ( 1 ≤ n ≤ 100,000, 1 ≤ q ≤ 100,000)
    이는 오름차순으로 정렬되어 주어진다. 두 번째 줄에 n개의 숫자가 주어진다.
    세 번째 줄에 q개의 질문이 주어진다. 각 수는 21억보다 작은 정수다.

    [출력]
    각 질문에 대하여 숫자가 존재하면 YES, 아니면 NO를 한 줄에 하나씩 출력한다.

    [예제]
    예제 입력
    10 4
    1 2 4 8 10 11 12 14 15 19
    4 5 8 17
    예제 출력
    YES
    NO
    YES
    NO
     */
    public static final int NOT_FOUND_VALUE = -1;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int q = scan.nextInt();
        long[] nums = new long[n];
        int[] resultArr = new int[q];
        scan.nextLine();

        for (int i=0; i<n; i++) {
            nums[i] = scan.nextLong();
        }

        long qNum;
        for (int i=0; i<q; i++) {
            qNum = scan.nextLong();
            resultArr[i] = binarySearch(nums,0, nums.length-1, qNum);
        }

        for (int result : resultArr) {
            printAnswer(result);
        }

    }

    public static int binarySearch(long[] arr, int start, int end, long value) {

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

    public static void printAnswer(int result) {
        if (result == NOT_FOUND_VALUE) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}
