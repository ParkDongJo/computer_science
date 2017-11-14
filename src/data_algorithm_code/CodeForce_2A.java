package data_algorithm_code;

import java.util.Scanner;

/**
 * Created by parkdongjo on 2017. 11. 1..
 */
public class CodeForce_2A {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int round = scan.nextInt();
        scan.nextLine();

        int[][] matrix = new int[round][round];
        String[] names = new String[round];

        for (int i = 0; i < round; i++) {
            String roundSet = scan.nextLine();
            String[] set = roundSet.split(" ");

            System.out.println("set 0 : " + set[0]);
            System.out.println("set 1 : " + set[1]);


        }

    }
}
