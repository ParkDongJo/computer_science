package data_algorithm_binary_search;


public class AVLTree {

    AVLTree position;
    AVLTree avlTree;

    public AVLNode makeEmpty(AVLNode t) {
        if(t != null) {
            makeEmpty(t.getLeft());
            makeEmpty(t.getRight());
            t = null;
        }
        return null;
    }

    public AVLNode find(int value, AVLNode t) {

        if (t == null) {
            return null;
        }

        if (value < t.getValue()) {
            return find(value, t.getLeft());
        }else if(value > t.getValue()) {
            return find(value, t.getRight());
        }else{
            return t;
        }
    }

    public AVLNode findMin(AVLNode t) {

        if(t == null) {
            return null;
        }else if(t.getLeft() == null) {
            return t;
        }else {
            return findMin(t.getLeft());
        }
    }

    public AVLNode findMax(AVLNode t) {

        if(t != null) {
            while (t.getRight() != null) {
                t = t.getRight();
            }
        }
        return t;
    }

    public int getHeight (AVLNode position) {
        if(position == null) {
            return -1;
        }else{
            return position.getHeight();
        }
    }

    public int max (int lhs, int rhs) {
        return lhs > rhs ? lhs : rhs;
    }

    public AVLNode singleRotateWithLeft (AVLNode k2) {
        AVLNode k1;

        k1 = k2.getLeft();
        k2.setLeft(k1.getRight());
        k1.setRight(k2);
        k2.setHeight(max(getHeight(k2.getLeft()),	getHeight(k2.getRight()))+1);
        k1.setHeight(max(getHeight(k1.getLeft()),k2.getHeight())+1);

        return k1;
    }

    public AVLNode singleRotateWithRight (AVLNode k1) {
        AVLNode k2;

        k2 = k1.getRight();
        k1.setRight(k2.getLeft());
        k2.setLeft(k1);
        k1.setHeight(max(getHeight(k1.getLeft()),	getHeight(k1.getRight()))+1);
        k2.setHeight(max(getHeight(k2.getRight()),k1.getHeight())+1);

        return k2;
    }

    public AVLNode doubleRotateWithLeft (AVLNode k3) {
        k3.setLeft(singleRotateWithRight(k3.getLeft()));
        return singleRotateWithLeft(k3);
    }

    public AVLNode doubleRotateWithRight (AVLNode k1) {
        k1.setRight(singleRotateWithLeft(k1.getRight()));
        return singleRotateWithRight(k1);
    }

    public AVLNode insert (int value, AVLNode t) {

        if(t == null) {
            t = new AVLNode(value);

            //새로운 값이 루트보다 작으면
        }else if(value < t.getValue()) {
            t.setLeft(insert(value,t.getLeft()));

            if(getHeight(t.getLeft())-getHeight(t.getRight()) == 2)
                if(value < t.getLeft().getValue())
                    t = singleRotateWithLeft(t);
                else
                    t = doubleRotateWithLeft(t);

            //새로운 값이 루트보다 크면
        }else if(value > t.getValue()) {
            t.setRight(insert(value,t.getRight()));

            if(getHeight(t.getRight())-getHeight(t.getLeft()) == 2)
                if(value > t.getRight().getValue())
                    t = singleRotateWithRight(t);
                else
                    t = doubleRotateWithRight(t);

        }

        t.setHeight(max(getHeight(t.getLeft()),	getHeight(t.getRight()))+1);
        return t;
    }

    public int retrieve (AVLNode t) {
        return t.getValue();
    }

    public void preOrder(AVLNode t) {
        System.out.println(t.getValue());
        if(t.getLeft() != null) {
            preOrder(t.getLeft());
        }

        if(t.getRight() != null) {
            preOrder(t.getRight());
        }
    }

}
