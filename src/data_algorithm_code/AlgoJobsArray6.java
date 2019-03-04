package data_algorithm_code;

import java.util.Arrays;
import java.util.Scanner;

public class AlgoJobsArray6 {
    /*
    1에서부터 6까지의 눈을 가진 3개의 주사위를 던져서 다음과 같은 규칙에 따라 상금을 받는 게임이 있다.

     * 규칙(1) 같은 눈이 3개가 나오면 10,000원+(같은 눈)*1,000원의 상금을 받게 된다.
     * 규칙(2) 같은 눈이 2개만 나오는 경우에는 1,000원+(같은 눈)*100원의 상금을 받게 된다.
     * 규칙(3) 모두 다른 눈이 나오는 경우에는 (그 중 가장 큰 눈)*100원의 상금을 받게 된다.

    예를 들어, 3개의 눈 3, 3, 6이 주어지면 상금은 1,000+3 * 100으로 계산되어 1,300원을 받게 된다.
    또 3개의 눈이 2, 2, 2로 주어지면 10,000+2 * 1,000 으로 계산되어 12,000원을 받게 된다.
    3개의 눈이 6, 2, 5로 주어지면 그 중 가장 큰 값이 6이므로 6 * 100으로 계산되어 600원을 상금으로 받게 된다.

    N(2≤N≤1,000) 명이 주사위 게임에 참여하였을 때, 가장 많은 상금을 받은 사람의 상금을 출력하는 프로그램을 작성하시오.

    [입력]
    첫째 줄에는 참여하는 사람 수 이 주어지고
    그 다음 줄부터 N개의 줄에 사람들이 주사위를 던진 3개의 눈이 빈칸을 사이에 두고 각각 주어진다.

    [출력]
    첫째 줄에 가장 많은 상금을 받은 사람의 상금을 출력한다.

    [입력 예제]
    3
    3 3 6
    2 2 2
    6 2 5

    [출력 예제]
    12000

     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();

        int[] rewardList = new int[n];

        for (int i=0; i<n; i++) {
            rewardList[i] =calc(scan.nextInt(), scan.nextInt(), scan.nextInt());
        }

        int max = Arrays.stream(rewardList).max().getAsInt();
        System.out.print(max);
    }

    /*
     * 규칙(1) 같은 눈이 3개가 나오면 10,000원+(같은 눈)*1,000원의 상금을 받게 된다.

     * 규칙(2) 같은 눈이 2개만 나오는 경우에는 1,000원+(같은 눈)*100원의 상금을 받게 된다.

     * 규칙(3) 모두 다른 눈이 나오는 경우에는 (그 중 가장 큰 눈)*100원의 상금을 받게 된다.
     */
    public static int calc(int a, int b, int c) {
        int reward;

        if (a == b && b == c ) {
            reward = 10000 + (a * 1000);
        } else if (a == b || b == c || a == c) {

            if (b==c) {
                reward = 1000 + (b * 100);
            } else {
                reward = 1000 + (a * 100);
            }

        } else {
            int [] arr = {a,b,c};

            // java 8 Stream 에 대해 알아볼 필요가 있음 (한동안 java의 기술 변화를 체크하지 않음)
            // [참고] - https://stackoverflow.com/questions/1484347/finding-the-max-min-value-in-an-array-of-primitives-using-java
            int max = Arrays.stream(arr).max().getAsInt();

            reward = max * 100;
        }

        return reward;
    }
}
