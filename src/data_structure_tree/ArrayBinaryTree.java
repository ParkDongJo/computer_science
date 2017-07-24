package data_structure_tree;

/**
 * Created by parkdongjo on 2017. 7. 8..
 */
public class ArrayBinaryTree {
    private final int ARR_SIZE = 15;
    private final int ROOT_IDX = 1;
    private Integer[] array = new Integer[ARR_SIZE+1];
    private int root;
    private int child;
    private int parent;
    private int depth;  //depth의 역할은 무엇인
    private int maxDepth;
    private int cursor;

    public ArrayBinaryTree() {
        this.depth = 0;
        this.maxDepth = 0;
        this.cursor = ROOT_IDX;
    }

    public void add(int data) {

        if(array[this.cursor] !=null) {
            if(array[this.cursor] < data) {
                this.cursor = 2 * this.cursor + 1;
            }else {
                this.cursor = 2 * this.cursor;
            }
            add(data);

            return;
        }
        array[this.cursor] = data;
        this.cursor = ROOT_IDX;

    }

    public void delete(int data) {

    }

    public int search(int data, int cursor) {

        if (array[cursor] == data) {
            return cursor;
        } else if(array[cursor] == null) {
            return -1;
        }else {

            int left = search(data, 2 * cursor);
            int right = search(data, 2 * cursor + 1);

            return left == -1 ? right : left;

        }
    }
//
//    public int findParent() {
//
//    }
//
//    public int findChild() {
//
//    }

//    public boolean isFull() {
//
//    }

    public void print(int cursor) {

        if(array[cursor] !=null) {

            print(2 * cursor);
            System.out.println(array[cursor]);
            print(2 * cursor + 1);

        }
    }



    public boolean isEmpty() {
        boolean result = true;

        if(this.root != 0) {
            result = false;
        }

        return result;
    }


}
