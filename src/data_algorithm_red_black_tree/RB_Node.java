package data_algorithm_red_black_tree;

/**
 * Created by parkdongjo on 2017. 12. 23..
 */
public class RB_Node {
    private boolean color;
    private RB_Node parent;
    private RB_Node left;
    private RB_Node right;
    private int key;

    public void setColor(boolean color) {
        this.color = color;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setLeft(RB_Node left) {
        this.left = left;
    }

    public void setParent(RB_Node parent) {
        this.parent = parent;
    }

    public void setRight(RB_Node right) {
        this.right = right;
    }

    public int getKey() {
        return key;
    }

    public RB_Node getLeft() {
        return left;
    }

    public RB_Node getParent() {
        return parent;
    }

    public RB_Node getRight() {
        return right;
    }
}
