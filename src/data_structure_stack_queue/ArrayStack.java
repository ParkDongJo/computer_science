package data_structure_stack_queue;

/**
 * Created by parkdongjo on 2017. 6. 25..
 */
public class ArrayStack {

    private final int ARR_MAX_SIZE = 10;

    private Integer[] array = new Integer[ARR_MAX_SIZE];
    private int size;


    public ArrayStack() {
        this.size = 0;
    }

    public int top() {
        int result = 1;

        if(isEmpty()) {
            result = -1;
        }else{
            result = array[size-1];
        }
        return result;
    }

    public int push(int data) {

        if (!isFull()) {
            array[size] = data;
            return 1;
        }
        return -1;
    }

    public int pop() {
        int result = 1;

        if(isEmpty()) {
            result = array[size-1];
        }else {
            result = -1;
        }

        return result;
    }

    public boolean isFull() {
        boolean result = true;

        if(size == ARR_MAX_SIZE) {
            result = false;
        }
        return result;
    }

    public boolean isEmpty() {
        boolean result = true;

        if(size != 0) {
            result = false;
        }

        return result;
    }

}
