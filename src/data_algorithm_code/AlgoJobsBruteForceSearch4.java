package data_algorithm_code;


import com.sun.tools.javac.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class AlgoJobsBruteForceSearch4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        ArrayList<Integer> kindOfColorList = new ArrayList<Integer>();
        int color;

        for (int i=0; i<n; i++) {
            color = scan.nextInt();
            if (!kindOfColorList.contains(color)) {
                kindOfColorList.add(color);
            }
        }

        if (kindOfColorList.size() >= 3) {
            System.out.print("YES");
        } else {
            System.out.print("NO");
        }
    }

//    public <Integer> static boolean contains(final Integer[] array, final Integer key) {
//        return Arrays.asList(array).contains(key);
//    }
}
