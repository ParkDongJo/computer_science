package data_algorithm_code;

import java.util.Scanner;

/**
 * 맞았습니다.
 */
public class BaeckjoonEx1316 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        int count = 0;
        boolean result = true;

        for(int i=0; i<n; i++) {
            String word = scan.nextLine();
            int[] arr = new int[word.length()];
            int prev = -1;
            result = true;

            for(int j=0; j<word.length(); j++) {
                Character c = word.charAt(j);

                //규칙이 무너지는 경우
                //이전 철자와 다르다 그리고 이전 철자들 중 중복되는 철자가 있다
                if(prev != -1 && prev != c) {
                    for(int k=0; k<arr.length; k++) {
                        if(arr[k] == c) {
                            result = false;
                        }
                    }
                }
                arr[j] = c;
                prev = c;

            }

            if(result) {
                count++;
            }
        }

        System.out.println(count);
    }
}
