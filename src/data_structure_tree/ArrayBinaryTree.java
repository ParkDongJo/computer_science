package data_structure_tree;

/**
 * Created by parkdongjo on 2017. 7. 8..
 */
public class ArrayBinaryTree {
    private final static int ARR_SIZE = 15;
    private final static int ROOT_IDX = 1;
    private Integer[] array = new Integer[ARR_SIZE+1];
    private int root;
    private int cursor;

    public ArrayBinaryTree() {
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

        int idx = search(data, ROOT_IDX);

        int right = findMinToRight(idx * 2 + 1);
        int left = findMaxToLeft(idx * 2);

        if(array[right] != null) {
            array[idx] = array[right];
        }else{
            array[idx] = array[left];
        }

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

    public int findMinToRight(int cursor) {
        if(array[cursor * 2] == null ) {
            return cursor;
        }
        return findMinToRight(cursor * 2);
    }

    public int findMaxToLeft(int cursor) {
        if(array[cursor * 2 + 1] == null ) {
            return cursor;
        }
        return findMaxToLeft(cursor * 2 + 1);
    }

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
