package data_algorithm_binary_search;

import java.util.Scanner;

public class BeackjoonEx1654 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt();
        int n = scan.nextInt();
        int[] nums = new int[k];
        int sum = 0;

        for (int i=0; i<k; i++) {
            nums[i] = scan.nextInt();
            sum += nums[i];
        }

        System.out.println(solution(nums, sum, n));

    }

    public static long solution(int[] arr,int sum, int target) {

        long[] resultArr = new long[sum / target];

        long mid = resultArr[(arr.length)-1];
        long start = 1;
        long end = 0;

        while (start >= end) {
            mid = (start+end)/2;

            long allCount = 0;

            for(int j=0; j<resultArr.length; j++) {

                allCount += resultArr[j]/mid;
            }

            if(allCount >= target) {
                end = mid + 1;

            }else if(allCount < target) {

                start = mid - 1;

            }
        }

        return start;
    }

}
