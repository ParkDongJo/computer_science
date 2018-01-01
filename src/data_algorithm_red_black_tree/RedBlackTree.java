package data_algorithm_red_black_tree;

import java.util.TreeSet;

/**
 * Created by parkdongjo on 2017. 12. 23..
 */
public class RedBlackTree {

    private final static int TREE_SIZE = 15;

    private RB_Node root = null;
    private int[] array;

    public RedBlackTree() {
        array = new int[TREE_SIZE];
    }

    private void insert(RB_Node z) {

    }

    public RB_Node getGrandFather(RB_Node z) {
        return  z.getParent() == null ? null : z.getParent().getParent();
    }

    public RB_Node getUncle(RB_Node z) {
        RB_Node grandFather = getGrandFather(z);
        RB_Node uncle = null;
        if(grandFather != null) {
            if(grandFather.getLeft() == z.getParent()) {
                uncle = grandFather.getRight();
            }else{
                uncle = grandFather.getLeft();
            }

        }
        return uncle;
    }

    public void rotate(RB_Node x) {
        RB_Node right = x.getRight();
        x.setRight(right.getLeft());
        right.getLeft().setParent(x);

        if(x != this.root) {
            right.setParent(x.getParent());
            if(x == x.getParent().getLeft()) {
                x.getParent().setLeft(right);
            }else{
                x.getParent().setRight(right);
            }

        }else{
            this.root = right;
        }

        x.setParent(right);
        right.setLeft(x);

    }


}
