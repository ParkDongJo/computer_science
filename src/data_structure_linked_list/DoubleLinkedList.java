package data_structure_linked_list;

/**
 * Created by parkdongjo on 2017. 6. 9..
 */
//더블 링크드 리스트 오늘 완성
public class DoubleLinkedList {

    private Node head;
    private Node tail;
    private Node cursor;
    private int size;


    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.cursor = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int add(int data) {
        int result = 1;

        //비어 있다
        if(isEmpty()) {
            this.head = new Node(data);
            this.tail = this.head;
            this.cursor = this.head;
        //비어있지 않다
        }else{

            //중복체크 : 중복 시 -1 리턴
            result = isOverlap(data);

            if(result == 1) {
                Node node = new Node(data);
                node.setPreLink(this.tail);
                this.tail.setNextLink(node);
                this.tail = node;
            }

        }


        if(result == 1) {
            size++;
        }


        return result;
    }


    public int delete(int data) {
        int result = -1;


        if(isEmpty()) {
            System.out.println("Double linked list is empty");
        }else{

            for(int i =0; i<size; i++) {

                if(this.cursor.getData() == data) {
                    Node preNode = cursor.getPreLink();
                    preNode.setNextLink(this.cursor.getNextLink());

                    //만약 삭제할 노드가 끝 노드일 시 tail 값도 변경
                    if(this.cursor == this.tail) {
                        this.tail = preNode;
                    }

                    size--;
                    result = 1;

                    break;
                }

                if(this.cursor.getNextLink() != null) {
                    this.cursor = this.cursor.getNextLink();
                }

            }
            this.cursor = this.head;

        }

        return result;
    }


    public int find(int data) {
        int index = -1;

        if(isEmpty()) {
            System.out.println("Double linked list is empty");
        }else{
            for(int i =0; i<size; i++) {

                if(this.cursor.getData() == data) {
                    index = i+1;
                    break;
                }

                if(this.cursor.getNextLink() != null) {
                    this.cursor = this.cursor.getNextLink();
                }
            }
            this.cursor = this.head;

        }

        return index;
    }


    public int conact(DoubleLinkedList list) {

        int result = 1;

        if(isEmpty()) {
            this.head = list.getHead();
            this.tail = list.getTail();
            this.cursor = this.head;
        }else{

            //중복 체크
            for(int i =0; i<size; i++) {

                if(list.isOverlap(this.cursor.getData()) == -1) {
                    result = -1;
                    break;
                }

                if(this.cursor.getNextLink() != null) {
                    this.cursor = this.cursor.getNextLink();
                }
            }
            this.cursor = this.head;


            if(result == 1) {
                this.tail.setNextLink(list.getHead());
                this.tail = list.getTail();
            }
        }

        //성공 시 사이즈 늘리기
        if(result == 1) {
            this.size += list.getSize();
        }


        return result;
    }


    public void print() {
        if(isEmpty()) {
            System.out.println("Double linked list is empty");
        }else{

            for(int i =0; i<size; i++) {
                System.out.print(this.cursor.getData() + " ");
                if(this.cursor.getNextLink() != null) {
                    this.cursor = this.cursor.getNextLink();
                }
            }
            this.cursor = this.head;

        }
    }// print() end

    public boolean isEmpty() {
        boolean result = false;

        if(this.head == null) {
            result = true;
        }
        return result;
    }//isEmpty() end


    public int isOverlap(int data) {
        int result = 1;

        if(!isEmpty()) {

            //중복 체크
            for(int i = 0; i<size; i++) {

                if(this.cursor.getData() == data) {
                    result = -1;
                    break;
                }

                if(this.cursor.getNextLink() != null) {
                    this.cursor = this.cursor.getNextLink();
                }
            }
            this.cursor = this.head;

        }

        return result;
    }// isOverlap() end


}
