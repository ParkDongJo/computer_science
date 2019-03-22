package data_algorithm_code;

import java.util.Arrays;
import java.util.Scanner;

public class AlgoJobsBinarySearch2 {
    /*
    [문제]
    숫자박스에는 자연수들이 적혀있는 종이들이 N장 들어있다. 숫자 M개가 주어졌을 때,
    이 숫자가 적혀있는 숫자가 상자 안에 있는지 아닌지를 구하는 프로그램을 작성하시오.

    [입력]
    첫째 줄에 윤성이가 가지고 있는 숫자 정보의 개수 N (1 ≤ N ≤ 300,000)이가 주어진다.
    둘째 줄에는 숫자 정보들이 주어진다. 숫자는 1,000,000이하의 정수이다. 두 숫자 카드에 같은 숫자가 적혀있는 경우는 없다.

    셋째 줄에는 M (1 ≤ M ≤ 500,000)이 주어진다. 넷째 줄에는 윤성이가 숫자 박스에 있는지 아닌지를
    구해야 할 M개의 숫자가 주어지며, 이 숫자는 공백으로 구분되어져 있다. 이숫자도 1,000,000이하의 정수이다.

    [출력]
    첫째 줄에 입력으로 주어진 M개의 숫자에 대해서, 각 숫자가 숫자 상자안에 있으면 1, 아니면 0을 개행으로 구분해 출력한다.


    [예제]
    예제 입력
    5
    6 3 2 10 -10
    8
    10 9 -5 2 3 4 5 -10
    예제 출력
    1
    0
    0
    1
    1
    0
    0
    1

     */
    public static final int NOT_FOUND_VALUE = -1;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long[] box = new long[n];
        for (int i=0; i<n; i++) {
            box[i] = scan.nextInt();
        }

        int m = scan.nextInt();
        long[] cards = new long[m];
        for (int i=0; i<m; i++) {
            cards[i] = scan.nextInt();
        }

        Arrays.sort(box);

        for (long card : cards) {
            int result = binarySearch(box, 0, box.length, card);
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
            System.out.println(0);
        } else {
            System.out.println(1);
        }
    }
}
