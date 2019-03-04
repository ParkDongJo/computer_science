package data_algorithm_code;

import java.util.ArrayList;
import java.util.Scanner;

public class AlgoJobsArray7 {
    /*
    숫자를 입력 받아 이진수로 출력하는 프로그램을 작성하시오.

    [입력]
    첫 번째 줄에 숫자를 입력 받는다. 숫자의 크기는 1,000보다 작거나 같다.

    [출력]
    첫째 줄에 숫자를 이진수로 바꾸어 출력한다.

    [입력 예제]
    14

    [출력 예제]
    1110
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int share = scan.nextInt();
        ArrayList<Integer> binaryList = new ArrayList<Integer>();

        while (share != 1) {
            binaryList.add(share % 2);
            share = share / 2;
        }
        binaryList.add(share);

        for (int i=binaryList.size()-1; i>=0; i--) {
            System.out.print(binaryList.get(i));
        }
    }
}
