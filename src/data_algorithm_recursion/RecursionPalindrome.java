package data_algorithm_recursion;

import java.util.Scanner;

public class RecursionPalindrome {
    // 팬린드롬 판별 재귀함수
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        char[] array = line.toCharArray();

        boolean result = palindrome(array, 0, array.length -1);

        System.out.println(result);
    }

    public static boolean palindrome(char[] arr, int start, int end) {
        if (start == end) {
            return true;
        } else if(arr[start] != arr[end]) {
            return false;
        }

        return arr[start] == arr[end] && palindrome( arr,start+1, end-1);
    }
}

