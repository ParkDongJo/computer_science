package data_algorithm_code;

import java.util.LinkedList;
import java.util.Scanner;

public class AlgoJobsAdvanceBruteForce5_1 {
    /**
     [문제]
     농부 존은 소들의 저녁식사 줄 세우는 새로운 방법을 개발 했다.
     N(1~15)마리의 소들을 순서대로 세 워놓은 후, 각 소들 사이에 +, - , . 셋 중 1가지가 써져있는
     냅킨을 배치해서 최종 결과가 0 이 되게 해야 하는 것이다. 점(.)이 써져있는 냅킨을 통해 더 큰 수를 만들 수 있게 된다.
     아래와 같은 경우를 보자. (ps .이 써져있는 냅킨은 '공백'이라고 생각하면 된다.)
     1-2.3-4.5+6.7 이와 같은 배치는 1-23-45+67 을 나타낸다. 결과는 0 이다. 10.11은 1011 로 해석된다.

     [입력]
     첫 째 줄에는 소들의 수 N(1 ≤ N ≤ 15)이 입력된다.

     [출력]
     처음 20줄에 대해 가능한 20가지 답을 출력하는데, 사전 순으로 앞선 것을 출력한다.
     순서는 +가 가장 앞서고 -와 . 이 순서대로 뒤따른다.
     답이 20개 미만이면 가능한 답을 각 숫자와 문자 사이에 공백을 두고 출력한다.
     모두 출력한다. 마지막 줄에는 가능한 답의 총 가지수를 출력한다.

     [예제]
     예제 입력
     7
     예제 출력
     1 + 2 - 3 + 4 - 5 - 6 + 7
     1 + 2 - 3 - 4 + 5 + 6 - 7
     1 - 2 + 3 + 4 - 5 + 6 - 7
     1 - 2 - 3 - 4 - 5 + 6 + 7
     1 - 2 . 3 + 4 + 5 + 6 + 7
     1 - 2 . 3 - 4 . 5 + 6 . 7
     6
     */

    public static final char[] SIGNS = {'+','-','.'};
    public static final int[] COWS = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

    public static int n;
    public static int count = 0;
    public static char[] signArr;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();

        signArr = new char[n];

        location(0);
    }

    public static void location(int idx) {
        if (idx > n-1) {
            // 출력
            if (isSumZero()) {

            }
            // 갯수 세기
        } else {

            for(int i=0; i<SIGNS.length; i++) {
                signArr[idx] = SIGNS[i];

                location(idx + 1);

                signArr[idx] = 0;
            }
        }
    }

    public static boolean isSumZero() {
        return true;
    }

    public static void print() {

    }

}
