package data_algorithm_code;

import java.util.Scanner;

public class AlgoJobsArray3 {
    /*
        9개의 서로 다른 자연수가 주어질 때, 이들 중 두 번째 최소값을 찾고,
        그 두 번째 최소값이 몇 번째 수인지를 구하는 프로그램을 작성하시오.
        예를 들어, 서로 다른 9개의 자연수 3, 29, 38, 12, 57, 74, 40, 85, 61 이 주어지면,
        이들 중 두 번째 최소값은 12이고, 이 값은 4번째 수이다.

        [입력]
        첫째 줄부터 아홉 번째 줄까지 한 줄에 하나의 자연수가 주어진다. 주어지는 자연수는 10,000,000 보다 작다.

        [출력]
        첫째 줄에 두 번째 최소값을 출력하고, 둘째 줄에 두 번째 최소값이 몇 번째 수인지를 출력한다.

        [예제 입력]
        3
        29
        38
        12
        57
        74
        40
        85
        61

        [예제 출력]
        12
        4
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] arr = new int[9];
        int min = 0;
        int idx = 0;

        for (int i=0; i<9; i++) {
            arr[i] = scan.nextInt();
        }
        min = arr[idx];

        // 최소수를 찾고
        for (int i=1; i<9; i++) {
            if (min > arr[i]) {
                min = arr[i];
                idx = i;
            }
        }

        // 최소수를 최대수로 만든 다음
        arr[idx] = 10000000;
        min = arr[idx];

        // 그 다음 최소수를 찾는다.
        for (int i=1; i<9; i++) {
            if (min > arr[i]) {
                min = arr[i];
                idx = i;
            }
        }
        System.out.println(min);
        System.out.println(idx + 1);

        //[질문]
        /*
            배열의 내부 값을 조작하게 되고,
            두개의 반복문을 쓰게 된다. 더 효율적인 방법은 없을까?
         */
    }
}
