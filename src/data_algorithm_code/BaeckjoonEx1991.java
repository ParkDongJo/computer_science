package data_algorithm_code;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by parkdongjo on 2017. 9. 8..
 */
public class BaeckjoonEx1991 {

    static private final int NODE_COUNT_LINKED = 3;
    static private final int PARENTS_IDX = 0;
    static private final int LEFT_CHILD_IDX = 1;
    static private final int RIGHT_CHILD_IDX = 2;
    static private int length;
    static private Character[][] map;
    static private Queue<Character> preQueue;
    static private Queue<Character> inQueue;
    static private Queue<Character> postQueue;


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        length = scan.nextInt();
        scan.nextLine();

        preQueue = new ArrayBlockingQueue<Character>(length);
        inQueue = new ArrayBlockingQueue<Character>(length);
        postQueue = new ArrayBlockingQueue<Character>(length);
        map = new Character[length][NODE_COUNT_LINKED];


        for(int i=0; i<length; i++) {
            String line = scan.nextLine();
            for(int j=0; j<NODE_COUNT_LINKED; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        preorder(0,0);
        preQueue.forEach(value -> System.out.print(value));

        System.out.println();

        inorder(0,0);
        inQueue.forEach(value -> System.out.print(value));

        System.out.println();

        postorder(0,0);
        postQueue.forEach(value -> System.out.print(value));

    }

    public static void preorder(int x, int y) {

        preQueue.add(map[x][y]);

        if(map[x][LEFT_CHILD_IDX] == '.') {
            if(map[x][RIGHT_CHILD_IDX] == '.') {
                return;
            }
        }else{
            for(int i=0;i<length; i++) {
                if(map[i][PARENTS_IDX] == map[x][LEFT_CHILD_IDX]) {
                    preorder(i,PARENTS_IDX);
                }
            }
        }
        for(int i=0;i<length; i++) {
            if(map[i][PARENTS_IDX] == map[x][RIGHT_CHILD_IDX]) {
                preorder(i,PARENTS_IDX);
            }
        }
    }

    public static void inorder(int x, int y) {

        if(map[x][LEFT_CHILD_IDX] != '.') {
            for(int i=0;i<length; i++) {
                if(map[i][PARENTS_IDX] == map[x][LEFT_CHILD_IDX]) {
                    inorder(i,PARENTS_IDX);
                }
            }
        }
        inQueue.add(map[x][y]);

        if(map[x][RIGHT_CHILD_IDX] != '.') {
            for(int i=0;i<length; i++) {
                if(map[i][PARENTS_IDX] == map[x][RIGHT_CHILD_IDX]) {
                    inorder(i,PARENTS_IDX);
                }
            }
        }else{
            return;
        }
    }

    public static void postorder(int x, int y) {
        if(map[x][LEFT_CHILD_IDX] != '.') {
            for(int i=0;i<length; i++) {
                if(map[i][PARENTS_IDX] == map[x][LEFT_CHILD_IDX]) {
                    postorder(i,PARENTS_IDX);
                }
            }
        }
        if(map[x][RIGHT_CHILD_IDX] != '.') {
            for(int i=0;i<length; i++) {
                if(map[i][PARENTS_IDX] == map[x][RIGHT_CHILD_IDX]) {
                    postorder(i,PARENTS_IDX);
                }
            }
        }

        postQueue.add(map[x][y]);
        return;
    }

}
