package data_algorithm_dijkstra;

/**
 * Created by parkdongjo on 2017. 9. 19..
 */
public class Edge implements Comparable<Edge>{
    private int start;
    private int end;
    private Integer weight;

    public Edge() {

    }

    public Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getEnd() {
        return end;
    }

    public int getStart() {
        return start;
    }

    public Integer getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Edge edge) {
        return this.getWeight().compareTo(edge.getWeight());
    }
}
