package data_algorithm_code;

import java.util.ArrayList;
import java.util.Scanner;

public class AlgoJobsBruteForceSearch15 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] nums = new int[10];
        for (int i=0; i<10; i++) {
            nums[i] = scan.nextInt();
        }

        ArrayList<E> list = new ArrayList<E>();
        for (int i=0; i<10; i++) {
            int idx = isExist(list, nums[i]);
            if (idx == -1) {
                E e = new E(nums[i]);
                list.add(e);
            }
        }

        int num;
        int count;
        for (int i=0; i<list.size(); i++) {
            num = list.get(i).num;
            count = 0;

            for (int j=0; j<10; j++) {
                if (num == nums[j]) {
                    count++;
                }
            }
            list.get(i).count = count;
        }

        // 최빈값
        int binNum = 0;
        int binMax = 0;
        for (int i=0; i<list.size(); i++) {
            count = list.get(i).count;
            num = list.get(i).num;
            if (binMax < count) {
                binMax = count;
                binNum = num;
            } else if (binMax == count) {
                if (binNum > num) {
                    binNum = num;
                }
            }
        }

        // 평균값
        int evgNum = 0;
        int sum = 0;
        for (int i=0; i<10; i++) {
            sum += nums[i];
        }
        evgNum = sum / 10;

        System.out.println(evgNum);
        System.out.println(binNum);
    }

    public static class E {
        public int num;
        public int count;
        public E(int num) {
            this.num = num;
            this.count = 0;
        }
    }
    public static int isExist(ArrayList<E> list, int num) {
        E e;
        for (int i=0; i<list.size(); i++) {
            e = list.get(i);
            if (e.num == num) {
                return i;
            }
        }
        return -1;
    }
}
