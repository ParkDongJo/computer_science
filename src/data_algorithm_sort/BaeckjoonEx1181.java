package data_algorithm_code;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BaeckjoonEx1181 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        BaeckjoonEx1181 obj = new BaeckjoonEx1181();
        PriorityQueue<String> queue = new PriorityQueue<>(obj.new WordComparator());

        for(int i=0; i<n; i++) {
            String word = scan.nextLine();
            queue.add(word);
        }

        int idx = 0;
        String[] arr = new String[n];
        while (!queue.isEmpty()) {
            //중복을 없애야 함
            String txt = queue.peek();

            if(idx==0 || !arr[idx-1].equals(txt)) {
                arr[idx] = txt;
                idx++;
            }
            queue.remove();
        }

        for(int i=0; i<n; i++) {
            if(arr[i] != null) {
                System.out.println(arr[i]);
            }
        }
    }


    //중복을 없애야 함
    public class WordComparator implements Comparator<String> {
        @Override
        public int compare(String word1, String word2) {
            int result = 0;
            if(word1.length() > word2.length()) {
                result = 1;
            }else if(word1.length() < word2.length()){
                result = -1;
            }else{
                result = word1.compareTo(word2);
            }

            return result;
        }
    }
}

