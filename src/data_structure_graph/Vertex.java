package data_structure_graph;

import data_structure_linked_list.Node;


public class Vertex {
    private int data;
    private Node nextNode;

    public Vertex(int data) {
        this.data = data;
        this.nextNode = null;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public Node getNextNode() {
        return nextNode;
    }

}
