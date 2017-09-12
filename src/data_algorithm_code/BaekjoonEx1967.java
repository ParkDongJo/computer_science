package data_algorithm_code;

import java.util.*;

/**
 * Created by parkdongjo on 2017. 8. 27..
 */
public class BaekjoonEx1967 {

    /*
     * 1. ROOT 노드에서 각각 리프 노드까지의 거리를 구한다
     * 2. 가장 긴 길이를 가진 두개의 리프 노드를 선택하고 그 두 노드간 간격을 구한
     *
     */

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();
        scan.nextLine();

        int[][] tree = new int[count+1][count+1];
        HashSet<Integer> parentArr = new HashSet<Integer>();
        ArrayList<Integer> childArr = new ArrayList<Integer>();


        for(int i=1; i<count; i++) {
            int parents = scan.nextInt();
            int child = scan.nextInt();
            tree[parents][child] = scan.nextInt();
            parentArr.add(parents);
            scan.nextLine();
        }

        for(int i=1; i<count; i++) {
            if(!parentArr.equals(i)) {
                childArr.add(i);
            }
        }

        for(Integer parents: parentArr) {
            System.out.print(parents + " / ");
        }

        System.out.println();

        for(Integer child: childArr) {
            System.out.print(child + " / ");
        }


        for(int i=1; i<=count; i++) {
            for(int j=1; j<=count; j++) {

                if(tree[i][j] != 0) {
                    System.out.print(tree[i][j] + " / ");
                }
            }
        }

    }

}