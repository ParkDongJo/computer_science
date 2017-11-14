package data_algorithm_code;

import java.util.Scanner;

/**
 * 맞혔습니다.
 */
public class BaeckjoonEx10828 {

    public class Stack {

        private final int YES_EMPTY = 1;
        private final int NO_EMPTY = 0;
        private final int HEAD_INIT = 0;
        private int[] arr;
        private int head;

        public Stack(int size) {
            this.arr = new int[size];
            this.head = HEAD_INIT;
        }

        public void push(int num) {
            if(empty() == YES_EMPTY) {
                arr[0] = num;
                //head++;
            }else{
                arr[++this.head] = num;
                //head++;
            }
        }

        public int pop() {
            int result = -1;
            if(empty() == NO_EMPTY) {
                result = arr[this.head];
                arr[this.head] = 0;
                if(this.head != HEAD_INIT) this.head--;
            }
            return result;
        }

        public int size() {
            return empty() == YES_EMPTY ? 0 : this.head + 1;
        }

        public int top() {
            int result = -1;
            if(empty() == NO_EMPTY) {
                result = arr[this.head];
            }
            return result;
        }

        public int empty() {
            return arr[0] == 0 ? YES_EMPTY : NO_EMPTY;
        }

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();
        scan.nextLine();

        BaeckjoonEx10828 m = new BaeckjoonEx10828();
        BaeckjoonEx10828.Stack stack = m.new Stack(count);

        for(int i=0; i< count; i++) {
            String query = scan.nextLine();
            checkQuery(query,stack);
        }

    }

    public static void checkQuery(String query, Stack stack) {
        if(query.contains("push")) {
            String[] in = query.split(" ");
            stack.push(Integer.parseInt(in[1]));
        }else if(query.contains("pop")){
            System.out.println(stack.pop());
        }else if(query.contains("size")){
            System.out.println(stack.size());
        }else if(query.contains("top")){
            System.out.println(stack.top());
        }else if(query.contains("empty")){
            System.out.println(stack.empty());
        }

    }

}