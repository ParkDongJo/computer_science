package data_algorithm_code;

import java.util.Scanner;

/**
 * Created by parkdongjo on 2017. 9. 11..
 */
public class BeackjoonEx2178 {

    private static int[][] map;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        scan.nextLine();
        int y = scan.nextInt();
        scan.nextLine();

        map = new int[x][y];

        for(int i=0; i<x; i++) {
            String line = scan.nextLine();
            for(int j=0; j<y; j++) {
                map[i][j] = line.charAt(j) - 48;
            }
        }

//        //출력
//        for(int i=0; i<x; i++) {
//            for(int j=0; j<y; j++) {
//                System.out.print(map[i][j]);
//            }
//            System.out.println();
//        }
    }

    public static void dfs(int x, int y) {
        //1. 탐색을 하는 순위를 오른쪽 -> 아랫쪽 -> 왼쪽 -> 윗쪽으로 한다.
        //2. 왠만한 길은 다 돌아버린다.
        //3. 그리고 각 길이마다 비교를 한다
    }

}