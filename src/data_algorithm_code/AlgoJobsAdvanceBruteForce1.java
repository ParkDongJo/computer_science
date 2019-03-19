package data_algorithm_code;

import java.util.Scanner;

public class AlgoJobsAdvanceBruteForce1 {
    /**
    [문제]
    서로 다른 n개의 원소들 중에서 r개만을 뽑아 일렬로 나열하는 것을 순열이라 한다.
    예를 들어, 3개의 원소 a, b, c 중에서 2개만을 뽑아 나열하면 ab, ac, ba, bc, ca, cb 의 6가지 경우가 있다.
    n과 r이 주어질 때, n개의 소문자 중에서 r개만을 뽑아 나열하는 모든 경우를 출력하는 프로그램을 작성하시오.
     단, a부터 시작하여 연속으로 n개의 알파벳을 갖고 있다고 하자.

    [입력]
    첫 번째 줄에 n과 r이 주어진다. ( 1 ≤ n ≤ 10, 0 ≤ r ≤ min(n, 7) )

    [출력]
    각 줄에 n개의 소문자 중에서 r개만을 뽑아 나열하는 경우를 사전순으로 나열한 결과를 출력한다.

    [예제]
    예제 입력
    4 2
    예제 출력
    ab
    ac
    ad
    ba
    bc
    bd
    ca
    cb
    cd
    da
    db
    dc
     */

    public static int n, r;
    public static char[] result = new char[11];
    public static boolean[] checked = new boolean[11];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        r = scan.nextInt();

        permutaion(0);
    }

    // 의미 : n개 중에 순서대로 r개를 뽑는 함수
    //       n중 반복
    // 기저조건 : 커서가 나열하고자 하는 수보다 커질때
    public static void permutaion(int cursor) {
        if (cursor >= r) {
            printResult(result);
        } else {
            for (int i=0; i<n; i++) {
                if (!checked[i]) {
                    char e = (char) (i + 'a');
                    result[cursor] = e;
                    checked[i] = true;

                    permutaion(cursor+1);

                    checked[i] = false;
                }
            }
        }

    }

    public static void printResult(char[] arr) {
        for (int i=0; i<r; i++) {
            if ((int) arr[i] != 0) {
                System.out.print(String.valueOf(arr[i]));
            }
        }
        System.out.println("");
    }
}
