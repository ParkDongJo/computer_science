package data_algorithm_theory;

import java.util.PriorityQueue;

/**
 * Created by parkdongjo on 2017. 9. 19..
 */
public class Prim {
    public static void main(String[] args) {

    }

    public static void prim(Integer[][] graph) {
        PriorityQueue<Edge> queue = new PriorityQueue<Edge>();

        //우선순위 큐에 간선(시작점,끝점,가중치) 넣기
        for(int i=0; i<graph.length; i++) {
            for(int j=0; j<graph[i].length; j++){
                if(graph[i][j] != null) {
                    queue.add(new Edge(i,j,graph[i][j]));
                }
            }
        }

    }

}

