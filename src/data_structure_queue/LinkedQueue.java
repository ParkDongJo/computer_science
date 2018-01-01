package data_structure_queue;

import data_structure_linked_list.LinkedList;
import data_structure_linked_list.Node;

/**
 * Created by parkdongjo on 2017. 7. 1..
 */
public class LinkedQueue {

    private int size;
    private LinkedList list = new LinkedList();
    private Node head;
    private Node tail;

    public LinkedQueue(int size) {
        this.head = null;
        this.tail = null;
        this.size = size;
    }

    public int add(int data) {
        int result = 1;

        if(isFull()) {
            result = -1;
        }else{
            list.add(data);
            this.head = list.getHead();
            this.tail = list.getTail();
        }


        this.size++;
        return result;
    }

    public int delete() {
        int result = 1;

        if(isEmpty()) {
            result = -1;
        }else{
            list.delete(list.getHead().getData());
            this.head = list.getHead();
        }

        this.size--;
        return result;
    }

    public boolean isFull() {
        boolean result = false;

        if(list.getSize() == this.size) {
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
