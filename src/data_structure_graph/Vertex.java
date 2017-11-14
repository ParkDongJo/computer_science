package data_structure_graph;

import data_structure_linked_list.Node;


public class Vertex {
    private int data;
    private Node nextNode;
    private Vertex nextVertex;

    public void setData(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public Node getNextNode() {
        return nextNode;
    }
}
