package data_algorithm_code;

public class CodingInterView2_3 {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.add(1);
        list.add(2);
        list.add(3);

        list.delete(3);
        list.add(4);
        list.print();
    }

    public static class LinkedList {
        private final int ERROR = -1;
        private final int SUCCES = 1;

        private Node head;
        private Node tail;
        private int size;

        public LinkedList() {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        public int getSize() {
            return size;
        }

        public void add(int input) {

            if (isEmpty()) {
                this.head = new Node(input);
                this.tail = this.head;
            } else {
                Node node = new Node(input);
                this.tail.setNext(node);
                this.tail = node;
            }

            this.size++;
        }

        public int delete(int data) {

            if (isEmpty()) {
                return ERROR;
            } else {
                Node node = this.head;
                int result = ERROR;

                while (node.getNext() != null) {
                    if (node.getNext().getData() == data) {
                        Node next = node.getNext();

                        if (next == this.tail) {
                            node.setNext(null);
                            this.tail = node;
                        } else {
                            node.setNext(next.getNext());
                            next.setNext(null);
                        }

                        result = SUCCES;
                        this.size--;
                        break;
                    }

                    node = node.getNext();
                }
                return result;
            }
        }

        public boolean isEmpty() {
            return this.head == null ? true : false;
        }

        public void print() {
            Node node = this.head;

//            while (node != this.tail) {
//                System.out.print(node.getData() + " ");
//                node = node.getNext();
//            }
//            System.out.println(this.tail.getData());

            for(int i=1; i<=size; i++) {
                System.out.print(node.getData() + " ");
                node = node.getNext();
            }
        }
    }

    public static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        public void setData(int data) {
            this.data = data;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public int getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }
    }
}