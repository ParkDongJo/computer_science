package data_algorithm_code;

import java.util.Scanner;

/**
 * 맞았습니다.
 */
public class BaeckjoonEx2577 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        scan.nextLine();
        int b = scan.nextInt();
        scan.nextLine();
        int c = scan.nextInt();
        scan.nextLine();

        int n = a*b*c;
        String nStr = n+"";
        int[] arr = new int[10];

        for(int i=0; i<nStr.length(); i++) {
            int at = Integer.parseInt(nStr.charAt(i)+"");
            arr[at] = ++arr[at];
        }

        for(int i=0; i<arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
