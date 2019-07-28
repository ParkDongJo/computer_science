package data_algorithm_code;

import java.util.Scanner;

public class CodingInterView1_3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        int n = scan.nextInt();
        String s = "";

        for (int i=0; i<n; i++) {
            char c = str.charAt(i);

            if (c==32) {
                s = "%20";
            } else {
                s = String.valueOf(c);
            }
            System.out.println(s);
        }
    }
}