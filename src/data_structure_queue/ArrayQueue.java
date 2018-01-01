package data_structure_queue;

/**
 * Created by parkdongjo on 2017. 6. 25..
 */
public class ArrayQueue {

    private final int ARR_MAX_SIZE = 10;
    private Integer[] array = new Integer[ARR_MAX_SIZE];
    private int head;
    private int tail;

    public ArrayQueue() {
        this.head = -1;
        this.tail = -1;
    }

    public int add(int data) {
        int result = 1;

        if(isFull()) {
            result = -1;
        }else{
            array[++this.tail] = data;
        }

        return result;
    }

    public int delete() {
        int result = 1;

        if(isEmpty()) {
            result = -1;
        }else{
            result = array[++this.head];
        }

        return result;
    }


    public boolean isFull() {
        boolean result = false;

        if(this.tail == ARR_MAX_SIZE-1) {
            result = true;
        }

        return result;
    }


    public boolean isEmpty() {
        boolean result = false;

        if(this.head == this.tail) {
            result = true;
        }

        return result;
    }

}
