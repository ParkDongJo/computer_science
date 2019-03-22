package data_algorithm_code;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class AlgoJobsBinarySearch4 {
    /*
    [문제]
    KOI 부설 과학연구소에서는 많은 종류의 산성 용액과 알칼리성 용액을 보유하고 있다.
    각 용액에는 그 용액의 특성을 나타내는 하나의 정수가 주어져있다.
    산성 용액의 특성값은 1부터 1,000,000,000까지의 양의 정수로 나타내고,
    알칼리성 용액의 특성값은 -1부터 -1,000,000,000까지의 음의 정수로 나타낸다.
    같은 양의 두 용액을 혼합한 용액의 특성값은 혼합에 사용된 각 용액의 특성값의 합으로 정의한다.
    이 연구소에서는 같은 양의 두 용액을 혼합하여 특성값이 0에 가장 가까운 용액을 만들려고 한다.

    예를 들어, 주어진 용액들의 특성값이 [-2, 4, -99, -1, 98]인 경우에는 특성값이 -99인 용액과
    특성값이 98인 용액을 혼합하면 특성값이 -1인 용액을 만들 수 있고, 이 용액이 특성값이 0에 가장 가까운 용액이다.
    참고로, 두 종류의 알칼리성 용액만으로나 혹은 두 종류의 산성 용액만으로 특성값이 0에 가장 가까운 혼합 용액을
    만드는 경우도 존재할 수 있다. 산성 용액과 알칼리성 용액의 특성값이 주어졌을 때,
    이 중 두 개의 서로 다른 용액을 혼합하여 특성값이 0에 가장 가까운 용액을 만들어내는 두 용액을 찾는 프로그램을 작성하시오.

    [입력]
    첫째 줄에는 전체 용액의 수 N이 입력된다. N은 2 이상 100,000 이하이다.
    둘째 줄에는 용액의 특성값을 나타내는 N개의 정수가 빈칸을 사이에 두고 주어진다.
    이 수들은 모두 -1,000,000,000 이상 1,000,000,000 이하이다. N개의 용액들의 특성값은 모두 다르고,
    산성 용액만으로나 알칼리성 용액만으로 입력이 주어지는 경우도 있을 수 있다.

    [출력]
    첫째 줄에 특성값이 0에 가장 가까운 용액을 만들어내는 두 용액의 특성값을 출력한다.
    출력해야하는 두 용액은 특성값의 오름차순으로 출력한다. 특성값이 0에 가장 가까운 용액을 만들어내는 경우가
    두 개 이상일 경우에는 특성값의 최솟값이 가장 작은 숫자를 출력한다. 해당 경우에서 특성값의 최솟값이 같은 경우는 없다고 가정한다.

    [예제]
    예제 입력
    5
    -2 4 -99 1 98
    예제 출력
    -99 98
     */
    public static long absolMinSum = 1000000000;
    public static long gFront, gBack;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long[] nums = new long[n];
        for (int i=0; i<n; i++) {
            nums[i] = scan.nextLong();
        }
        Arrays.sort(nums);

        for (int i=0; i<n; i++) {
            binarySearch(nums, i+1, nums.length-1, nums[i]);

        }

        System.out.println(gFront + " " + gBack);

//        Integer[] array = {9,-2,10,3,-5,34,-22,7};
//        Arrays.sort(array, Comparator.comparingInt(Math::abs));
//        System.out.println(Arrays.toString());
    }

    public static void binarySearch(long[] arr, int start, int end, long front) {

        if (start > end) {
            return;
        } else if (start == end) {
            long absSum = Math.abs(front + arr[start]);
            dualCompare(absSum, front, arr[start]);

            return;
        } else {
            int mid = (start + end) / 2;

            long sum = front + arr[mid];

            if (sum == 0) {
                long absSum = Math.abs(sum);
                dualCompare(absSum, front, arr[mid]);
                return;
            } else if (sum < 0) {
                // 오른쪽으로
                binarySearch(arr, mid+1, end, front);
            } else {
                // 왼쪽으로
                binarySearch(arr, start, mid-1, front);
            }

        }
    }

    public static void dualCompare(long absSum, long front, long back) {
        if (absSum < absolMinSum) {
            absolMinSum = absSum;
            gFront = front;
            gBack = back;
        } else if (absSum == absolMinSum){
            if (gFront > front) {
                absolMinSum = absSum;
                gFront = front;
                gBack = back;
            }
        }
    }
}
