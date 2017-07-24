package data_structure_linked_list;

/**
 * Created by parkdongjo on 2017. 5. 29..
 */
public class Node {
    private int data;
    private Node preLink;
    private Node nextLink;


    public Node() {

    }

    public Node(int data) {
        this.data = data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setPreLink(Node link) {
        this.preLink = link;
    }

    public void setNextLink(Node nextLink) {
        this.nextLink = nextLink;
    }

    public int getData() {
        return data;
    }

    public Node getPreLink() {
        return preLink;
    }

    public Node getNextLink() {
        return nextLink;
    }
}
