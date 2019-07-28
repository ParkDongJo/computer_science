package data_algorithm_code;

import java.util.Scanner;

public class AlgoJobsSpecial1 {

    /**
     1. 재귀함수로 풀 필요가 있는가?

     2. 재귀 안에 내부 for문이 필요하다
        재귀 안에 내부 for문이 필요없다

     3. 트리형태로 파고드는 재귀 형태
        재귀 함수가 열리는 개념으로 다가가기.

     */


    //재귀 함수가 열린다 라는 개념이 중요하다
    // f(2) {
    //   f(1) {
    //      f(0) {
    //      }
    //   }
    // }

    //40개 중에 2개를 뽑아야 한다 -> 일반 반복문
    //M개 중에 N개를 뽑아야 된다 -> 재귀함수


    // 재귀에서 필요한 변수는 전역으로 해놔라
    public static int n;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        printNums(1);
    }

    public static void printNums(int x) {

        if (n == x) {
            System.out.print(x);
        }
        System.out.print(x);
        printNums(x+1);
        System.out.print(x);
    }

}
