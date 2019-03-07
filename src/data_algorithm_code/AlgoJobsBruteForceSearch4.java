package data_algorithm_code;


import com.sun.tools.javac.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class AlgoJobsBruteForceSearch4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[] colors = new int[n];
        int[] selected = new int[6];
        for (int i=0; i<n; i++) {
            colors[i] = scan.nextInt();
        }

        int temp;
        int idx = 0;
        for (int i=0; i<n; i++) {
            temp = colors[i];

            // 존재하면
            if (isExist(selected,temp)) {

                // 한번 더 찾기
                for (int j=0; j<n; j++) {
                    if (i != j && temp == colors[j]) {

                        if (!isFull(selected, temp)) {
                            selected[idx] = temp;
                            idx++;
                        }
                    }
                }

            } else {
                // 존재하지 않으면 넣어주기
                selected[idx] = temp;
                idx++;
            }

            if (idx == 6) {
                break;
            }
        }

        if (idx == 6) {
            System.out.print("YES");
        } else {
            System.out.print("NO");
        }
    }

    public static boolean isExist(int[] array, int num) {
        for (int i=0; i<array.length; i++) {
            if (array[i] == num) {
                return true;
            }
        }
        return false;
    }

    public static boolean isFull(int[] array, int num) {
        int count = 0;
        for (int i=0; i<array.length; i++) {
            if (array[i] == num) {
                count++;
            }
        }

        if (count == 2) {
            return true;
        }
        return false;
    }

//    public <Integer> static boolean contains(final Integer[] array, final Integer key) {
//        return Arrays.asList(array).contains(key);
//    }
}
