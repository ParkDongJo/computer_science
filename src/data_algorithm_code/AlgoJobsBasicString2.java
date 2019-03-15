package data_algorithm_code;

import java.util.Scanner;

public class AlgoJobsBasicString2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();

        String[] arr = str.split(" ");

        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

}
