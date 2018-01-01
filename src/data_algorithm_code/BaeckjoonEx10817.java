package data_algorithm_code;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 맞혔습니다.
 */
public class BaeckjoonEx10817 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        queue.add(a);
        queue.add(b);
        queue.add(c);

        queue.poll();
        System.out.print(queue.poll());

    }
}