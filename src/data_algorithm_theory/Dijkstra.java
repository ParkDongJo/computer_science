package data_algorithm_theory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by parkdongjo on 2017. 9. 24..
 */

public class Dijkstra {
    public static void main(String[] args) {

        Integer[][] graph = { { null, 10, 30, 15, null, null },
                            { null, null, null, null, 20, null },
                            { null, null, null, null, null, 5 },
                            { null, null, 5, null, null, 20 },
                            { null, null, null, null, null, 20 },
                            { null, null, null, 20, null, null}};
        Integer[] dist = dijkstra(graph,0);
        for(int i=0; i<dist.length; i++) {
            System.out.println(dist[i]);
        }

    }


    public static Integer[] dijkstra(Integer[][] graph, int start) {

        int size = graph.length;
        Integer dist[] = new Integer[size];
        Integer prev[] = new Integer[size];
        Integer[] S = new Integer[size];
        Integer[] Q = new Integer[size];

        for(int i=0; i<size; i++) {
            dist[i] = null;
            prev[i] = null;
            Q[i] = i;
        }
        dist[start] = 0;
        int idx = 0;

        while (idx != 6) {

            Integer temp = -1;
            int minIdx = -1;

            for(int i =0; i<size; i++) {
                if(Q[i] != null) {
                    if(temp == -1) {
                        temp = dist[Q[i]];
                        minIdx = i;
                    }else{

                        if(dist[Q[i]] != null) {
                            int result = dist[Q[i]].compareTo(temp);

                            if(result < 0) {
                                temp = dist[Q[i]];
                                minIdx = i;
                            }
                        }
                    }
                }
            }

            int u = Q[minIdx];
            S[idx] = u;
            idx++;
            Q[minIdx] = null;


            for(int i=0; i<size; i++) {

                if(graph[u][i] != null) {

                    if(dist[i] != null && dist[i] > dist[u] + graph[u][i]) {
                        dist[i] = dist[u] + graph[u][i];
                        prev[i] = u;
                    }
                    if(dist[i] == null) {
                        dist[i] = dist[u] + graph[u][i];
                        prev[i] = u;
                    }
                }
            }
        }

        return prev;
    }

}
