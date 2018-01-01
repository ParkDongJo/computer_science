package data_algorithm_mst;


import data_algorithm_dijkstra.Edge;

import java.util.PriorityQueue;

/**
 * Created by parkdongjo on 2017. 9. 19..
 */
public class Prim {
    public static void main(String[] args) {

        Integer[][] graph = { { null, 1, 6, 7, 5 },
                            { 1, null, 2, 9, 8 },
                            { 6, 2, null, 3, 10 },
                            { 7, 9, 3, null, 4 },
                            { 5, 8, 10, 4, null } };

        printMSTByPrim(graph);
    }

    public static void printMSTByPrim(Integer[][] graph) {
        int start = 0;
        int count = 0;
        PriorityQueue<Edge> queue = new PriorityQueue<Edge>();
        Edge[] MST = new Edge[graph[start].length -1];


        MST = prim(graph,start,queue,MST,count);


        for(int i = 0; i <MST.length ; i++) {
            System.out.println(MST[i].getWeight());
        }
    }

    public static Edge[] prim(Integer[][] graph, int start, PriorityQueue<Edge> queue, Edge[] MST, int count) {

        if(count == graph[0].length -1) {
            return MST;
        }

        for(int i=0; i<graph[start].length; i++){
            if(graph[start][i] != null) {
                queue.add(new Edge(start,i,graph[start][i]));
            }
        }
        Edge edge = queue.poll();
        int next = edge.getEnd();
        graph[start][next] = null;
        graph[next][start] = null;
        MST[count++] = edge;


        return prim(graph,next,queue,MST,count);
    }

}

