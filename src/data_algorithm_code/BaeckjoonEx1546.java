package data_algorithm_code;


import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by parkdongjo on 2017. 11. 27..
 */
public class BaeckjoonEx1546 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(n, Collections.reverseOrder());
        for(int i=0; i<n; i++) {
            int a = scan.nextInt();
            queue.add(a);
        }

        int m = queue.peek();
        int sum = 0;

        for(int i=0; i<n; i++) {
            int real = queue.poll();
            float fake = Float.parseFloat(String.format("%.2f", (float) real/m * 100));
            sum += fake;
        }
        System.out.printf("%.2f",(float)sum/n);
    }
}
