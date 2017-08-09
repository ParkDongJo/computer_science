package data_structure_heap;

/**
 * Created by parkdongjo on 2017. 8. 9..
 */
public class Heap {

    private int ARR_SIZE = 20;
    private int ROOT_IDX = 1;
    private Integer[] array = new Integer[ARR_SIZE];
    private int cursor;

    public Heap() {
        this.cursor = ROOT_IDX;
    }

    public int insert(int data) {

        array[this.cursor] = data;

        if(this.cursor != 1) {
            switchNode(this.cursor/2, this.cursor);
        }


        this.cursor++;

        return -1;
    }

    public int delete(int data) {

        return -1;
    }

    public boolean compare(int parentsIdx, int childIdx) {
        if(array[parentsIdx] > array[childIdx]) {
            return true;
        }

        return false;
    }

    public void switchNode(int parentsIdx, int childIdx) {
        int temp = 0;

        if(childIdx == ROOT_IDX || compare(parentsIdx,childIdx) ) {
            return;
        }

        temp = array[parentsIdx];
        array[parentsIdx] = array[childIdx];
        array[childIdx] = temp;

        switchNode(parentsIdx/2, parentsIdx);
    }

    public void print() {
        for (int i=1; i<array.length; i++) {
            System.out.print(array[i]);
        }
    }
}
