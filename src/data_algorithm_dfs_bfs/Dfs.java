package data_algorithm_dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Dfs {
    public static void main(String[] args) {
        // 배열로 그래프 표현
        /*
            1 - 2 - 3
            |   |
            4 - 5
            |
            6
            위와 같은 그래프 구조가 있다고 가졍
         */
        int[][] graph = { { 0, 1, 0, 1, 0, 0 },
                { 1, 0, 1, 0, 1, 0 },
                { 0, 1, 0, 0, 0, 0 },
                { 1, 0, 0, 0, 1, 1 },
                { 0, 1, 0, 1, 0, 0 },
                { 0, 0, 0, 1, 0, 0 }};
        boolean[] visited = new boolean[6];

        bfs(graph, visited, 0);
    }

    public static void bfs(int[][] a, boolean[] c, int v) {
        Queue<Integer> q = new LinkedList<>();
        int n = a.length - 1;
        q.add(v);
        c[v] = true;

        while (!q.isEmpty()) {
            v = q.poll();
            System.out.print(v + " ");

            for (int i = 1; i <= n; i++) {
                if (a[v][i] == 1 && !c[i]) {
                    q.add(i);
                    c[i] = true;
                }
            }
        }
    }

}
