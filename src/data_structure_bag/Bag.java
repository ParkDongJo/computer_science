package data_structure_sort;

/**
 * Created by parkdongjo on 2017. 6. 3..
 */
public class Bag {
    private static final int BAG_SIZE = 20;
    private static final int EMPTY_SIZE = 0;

    private int[] array;
    private int currentSize;

    public Bag() {
        this.array = new int[BAG_SIZE];
        this.currentSize = 0;
    }

    public int getSize() {
        return currentSize;
    }

    public boolean add(int data) {
        int i;

        for(i=0; i<BAG_SIZE; i++) {

            if(array[i] == 0) {
                array[i] = data;
                return true;
            }


        }
        return false;
    }

    public boolean remove(int data) {
        int count = 0;
        boolean result = true;

        for(int i=0; i<BAG_SIZE; i++) {

            if(array[i] == data) {
                array[i] = 0;
                break;
            }
            count++;

            if(count == BAG_SIZE) {
                result = false;
            }
        }

        return result;
    }

    public boolean contain(int data) {
        boolean result = true;
        int count = 0;

        for(int i=0; i<BAG_SIZE; i++) {

            if(array[i] == data) {

                break;
            }
            count++;

            if(count == BAG_SIZE) {
                result = false;
            }
        }
        return result;
    }

    public boolean isEmpty() {
        return currentSize == EMPTY_SIZE ? true : false;
    }
}
