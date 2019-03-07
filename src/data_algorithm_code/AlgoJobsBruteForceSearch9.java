package data_algorithm_code;

import java.util.Scanner;

public class AlgoJobsBruteForceSearch9 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int max = 0;
        int maxI = 0;
        int maxJ = 0;
        int num;

        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                 num = scan.nextInt();
                 if (max < num) {
                     max = num;
                     maxI = i;
                     maxJ = j;
                 } else if (max == num) {

                     if (maxI > i) {
                         maxI = i;
                     } else if(maxI == i) {
                         if (maxJ > j) {
                             maxJ = j;
                         }
                     }
                 }
            }
        }

        System.out.println(max);
        System.out.println((maxI+1) + " " + (maxJ+1));
    }
}
