package data_structure_stack;

import data_structure_linked_list.LinkedList;
import data_structure_linked_list.Node;

/**
 * Created by parkdongjo on 2017. 6. 25..
 */
public class LinkedStack {

    private int size;
    private LinkedList list = new LinkedList();
    private Node top;

    public LinkedStack(int size) {
        this.top = null;
        this.size = size;
    }

    public int push(int data) {
        int result = 1;

        if(isFull()) {
            result = -1;
        }else{
            list.add(data);
            this.top = list.getTail();
        }

        return result;
    }

    public int pop() {
        int result = 1;

        if(isEmpty()) {
            result = -1;
        }else{
            list.delete(this.top.getData());
        }

        return result;
    }

    public boolean isFull() {
        boolean result = true;

        if(size > list.getSize()) {
            result = false;
        }

        return result;
    }


    public boolean isEmpty() {
        boolean result = true;

        if(top != null) {
            result = false;
        }

        return result;
    }

}
