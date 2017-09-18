package data_structure_graph;

import java.util.*;

/**
 * Created by parkdongjo on 2017. 9. 17..
 */
public class GraphLinkedList {

    private static final int WORK_FAIL = -1;
    private static final int WORK_SUCCESS = 1;

    private LinkedList<LinkedList<Integer>> lists;
    //private Map<Integer,LinkedList<Integer>> idxList;
    private int index = 0;

    public GraphLinkedList() {
        this.lists = new LinkedList<LinkedList<Integer>>();
        //this.idxList = new HashMap<Integer, LinkedList<Integer>>();
    }

    public void graphInit() {

    }

    public void insertVertex(Integer v) {
        LinkedList head = new LinkedList<Integer>();
        head.add(v);
        lists.add(head);
    }

    public int insertEdge(Integer v1, Integer v2) {
        int result = WORK_FAIL;

        for(LinkedList<Integer> list : lists) {
            if(list.getFirst() == v1) {
                list.add(v2);
                result = WORK_SUCCESS;
            }
        }

        if(result != WORK_SUCCESS) {
            LinkedList head = new LinkedList<Integer>();
            head.add(v1);
            head.add(v2);
            lists.add(head);
            result = WORK_SUCCESS;
        }

        return result;
    }


    public int deleteVertex(Integer v) {
        int result = WORK_FAIL;

        if(isEmpty()) {
            for(LinkedList<Integer> list : lists) {
                if(list.getFirst() == v) {
                    lists.remove(list);
                    result = WORK_SUCCESS;
                }
            }
        }

        return result;
    }

    public int deleteEdge(Integer v1, Integer v2) {
        int result = WORK_FAIL;

        if(isEmpty()) {
            for(LinkedList<Integer> list : lists) {
                if(list.getFirst() == v1) {
                    list.remove(v2);
                    result = WORK_SUCCESS;
                }
            }
        }

        return result;
    }

    public boolean isEmpty() {
        return lists.size() == 0 ? true : false;
    }

    public LinkedList<Integer> Adjacent(int v) {
        LinkedList<Integer> result = null;

        for(LinkedList<Integer> list : lists) {
            if(list.getFirst() == v) {
                result = list;
                result.remove(v);
            }
        }

        return result;
    }
}
