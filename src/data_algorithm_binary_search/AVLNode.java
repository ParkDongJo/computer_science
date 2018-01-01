package data_algorithm_binary_search;

public class AVLNode {

    private int value;

    private AVLNode left;

    private AVLNode right;

    private int height;

    public AVLNode(int value) {
        this.value = value;
        left = null;
        right = null;
        height = 0;
    }

    public int getValue() {

        return value;

    }

    public void setValue(int value) {

        this.value = value;

    }
    public AVLNode getLeft() {

        return left;

    }
    public void setLeft(AVLNode left) {

        this.left = left;

    }
    public AVLNode getRight() {

        return right;

    }
    public void setRight(AVLNode right) {

        this.right = right;

    }
    public int getHeight() {

        return height;

    }
    public void setHeight(int height) {

        this.height = height;

    }

}
