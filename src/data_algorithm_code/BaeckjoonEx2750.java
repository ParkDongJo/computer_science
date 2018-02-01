package data_algorithm_code;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 맞았습니다.
 */

public class BaeckjoonEx2750 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        scan.nextLine();

        int num = -1;
        for(int i=0; i<n; i++){
            num = scan.nextInt();
            queue.add(num);
        }

        for(int i=0; i<n; i++) {
            System.out.println(queue.poll());
        }
    }
}