package data_algorithm_code;

import com.sun.tools.javac.util.ArrayUtils;

import java.util.Arrays;

public class ProgramersGreedyGym {

    /**

         n	lost	reserve	    return
         5	[2, 4]	[1, 3, 5]	5
         5	[2, 4]	[3]	        4
         3	[3]	    [1]	        2

     */
    public static void main(String[] args) {

    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int num = n - lost.length;

        int[] all = new int[n];

        for(int received : lost) {

            int prevNum = received - 1;
            int nextNum = received + 1;

            // 포함
            if (!contains(reserve, prevNum) && !contains(reserve, nextNum)) {
                all[received - 1] = -1;
            }

        }

        return 0;
    }

    public static boolean contains(final int[] array, final int key) {
        return Arrays.stream(array).anyMatch(i -> i == key);
    }
}
