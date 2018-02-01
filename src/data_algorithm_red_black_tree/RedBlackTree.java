package data_algorithm_red_black_tree;

import java.util.TreeSet;

/**
 * Created by parkdongjo on 2017. 12. 23..
 */
public class RedBlackTree {

    private static final boolean RED   = true;
    private static final boolean BLACK = false;

    private RB_Node root = null;
    private int[] array;

    public RedBlackTree() {
    }

    private void insert(RB_Node x) {


        //이건 일단 보류!!!
//        //x의 오른쪽 자식이 레드일때, 왼쪽자식이 레드가 아닐때
//        if (isRed(x.getRight()) && !isRed(x.getLeft())) {
//            x = rotateLeft(x);
//        }
//
//        //x의 왼쪽 자식이 레드일때, 왼쪽자식의 왼쪽자식이 레드일때
//        if (isRed(x.getLeft()) && isRed(x.getLeft().getLeft())) {
//            x = rotateRight(x);
//        }
//
//        //왼쪽 자식이 레드일때, 오른쪽 자식이 오른쪽 자식이 레드일때
//        if (isRed(x.getLeft()) && isRed(x.getRight())) {
//            flipColors(x);
//        }
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

    private RB_Node rotateRight(RB_Node h) {
        RB_Node x = h.getLeft();
        h.setLeft(x.getRight());
        x.setRight(h);
        x.setColor(x.getRight().getColor());
        x.getRight().setColor(RED);
        x.setSize(h.getSize());
        h.setSize(size(h.getLeft()) + size(h.getRight()) + 1);
        return x;
    }

    private RB_Node rotateLeft(RB_Node h) {
        RB_Node x = h.getRight();
        h.setRight(x.getLeft());
        x.setLeft(h);
        x.setColor(x.getLeft().getColor());
        x.getLeft().setColor(RED);
        h.setSize(size(h.getLeft()) + size(h.getRight()) + 1);
        return x;
    }

    private void flipColors(RB_Node h) {
        h.setColor(!h.getColor());
        h.getLeft().setColor(!h.getLeft().getColor());
        h.getRight().setColor(!h.getRight().getColor());
    }

    public boolean isEmpty() {
        return root == null;
    }

    private boolean isRed(RB_Node x) {
        if (x == null) return false;
        return x.getColor() == RED;
    }

    private int size(RB_Node x) {
        if (x == null) return 0;
        return x.getSize();
    }

    private int height(RB_Node x) {
        if (x == null) return -1;
        return 1 + Math.max(height(x.getLeft()), height(x.getRight()));
    }

}
