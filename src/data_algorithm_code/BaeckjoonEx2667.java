package data_algorithm_code;

import java.util.Scanner;

/**
 * Created by parkdongjo on 2017. 8. 30..
 */
public class BaeckjoonEx2667 {

    //private static int[][] cursor;
    private static final int CHECKED_FLAG =2;
    private static final int CHECKED_QUADRANT =4;

    private static int dx[] = {1,0,-1,0};
    private static int dy[] = {0,1,0,-1};

    private static int[][] map;
    private static int length = 0;
    private static int cnt = 0;
    private static int[] sum;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        length = scan.nextInt();
        scan.nextLine();

        map = new int[length][length];
        sum= new int[length*length];


        for(int i=0; i<length; i++) {
            String line = scan.nextLine();
            for(int j=0; j<length; j++) {
                map[i][j] = line.charAt(j) - 48;
            }
        }


        for(int i=0; i<length; i++) {
            for(int j=0; j<length; j++) {
                if(map[i][j] == 1) {
                    dfs(i,j);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
        for(int i=0; i<cnt; i++) {
            System.out.println(sum[i]);
        }

        //출력
        for(int i=0; i<length; i++) {
            for(int j=0; j<length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

    }

    public static void dfs(int x, int y) {
        boolean loop = false;
        sum[cnt]++;
        map[x][y] = CHECKED_FLAG;


        for(int i=0; i<CHECKED_QUADRANT; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];
            if(cx<length && cx>=0 && cy<length && cy>=0) {
                if(map[cx][cy] == 1) {
                    loop = true;
                    dfs(cx,cy);
                }
            }
            if(i == CHECKED_QUADRANT-1 && loop == false) {
                return;
            }
        }
    }

}
