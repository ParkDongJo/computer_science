package data_algorithm_basic;

import java.util.Arrays;

public class ArrayBasic {
    public static void main(String[] args) {

        /*
            1.
            Arrays 클래스의 stream을 이용하면 int[] 배열의
            최대값을 쉽게 구할 수 있다
            최소값을 쉽게 구할 수 있다
            합을 쉽게 구할 수 있다
         */
        int[] arr = {10, 8, 6};
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int sum = Arrays.stream(arr).sum();
        System.out.println(max);
        System.out.println(min);
        System.out.println(sum);


    }
}
