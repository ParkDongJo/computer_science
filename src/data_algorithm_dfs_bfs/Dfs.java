package data_algorithm_dfs_bfs;

import java.util.Stack;

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

        dfs(graph, visited, 0);

    }

    public static void dfs(int[][] arr, boolean[] visited, int vertax) {
        int n = arr.length - 1;
        visited[vertax] = true;
        System.out.print((vertax+1) + " ");

        for (int i = 0; i <= n; i++) {
            if (arr[vertax][i] == 1 && !visited[i]) {
                dfs(arr, visited, i);
            }
        }
    }

    public static void dfsByStack(int[][] arr, boolean[] visited, int vertax, boolean flag) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length - 1;
        stack.push(vertax);
        visited[vertax] = true;
        System.out.print(vertax + " ");

        while (!stack.isEmpty()) {
            int vv = stack.peek();
            flag = false;

            for (int i = 1; i <= n; i++) {
                if (arr[vv][i] == 1 && !visited[i]) {
                    stack.push(i);
                    System.out.print(i + " ");
                    visited[i] = true;
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                stack.pop();
            }
        }
    }
}
