package data_algorithm_theory;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created by parkdongjo on 2017. 9. 23..
 */
public class Kruscal {

    public static void main(String[] args) {

        Integer[][] graph = { { null, 1, 6, 7, 5 },
                { 1, null, 2, 9, 8 },
                { 6, 2, null, 3, 10 },
                { 7, 9, 3, null, 4 },
                { 5, 8, 10, 4, null } };

        printMSTByKruscal(graph);


    }

    public static void printMSTByKruscal(Integer[][] graph) {

        Edge[] MST = kruscal(graph);

        for(int i = 0; i <MST.length ; i++) {
            try {

                System.out.println(MST[i].getWeight());
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static Edge[] kruscal(Integer[][] graph) {

        PriorityQueue<Edge> queue = new PriorityQueue<Edge>();
        for(int i=0; i<graph[0].length; i++){
            for(int j=0; j<graph[0].length; j++) {
                if(graph[i][j] != null) {
                    queue.add(new Edge(i,j,graph[i][j]));
                    graph[j][i] = null;
                }
            }
        }

        int size = queue.size();
        int idx = 0;
        Edge[] MST = new Edge[graph[0].length-1];
        Set<Integer> connected = new HashSet<Integer>();
        for(int i=0; i<size; i++){
            Edge edge = queue.poll();


            if(connected.size() != graph[0].length) {
                MST[idx++] = edge;
                if(!connected.contains(edge.getStart())){
                    connected.add(edge.getStart());
                }

                if(!connected.contains(edge.getEnd())){
                    connected.add(edge.getEnd());
                }
            }else{
                break;
            }
        }

        return MST;
    }


}
