package data_structure_graph;

import java.util.Queue;

/**
 * Created by parkdongjo on 2017. 9. 13..
 */
public class GraphArray {

    private static final int WORK_FAIL = -1;
    private static final int WORK_SUCCESS = -1;
    private static final int IN_VERTEX = 1;

    private Integer[][] matrix;
    private Integer[] array;
    private int cursor = 0;
    private int size;

    public GraphArray(int size) {
        this.size = size;
        this.matrix = new Integer[size][size];
        this.array = new Integer[size];
    }

    public void graphInit() {
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix.length; j++) {
                matrix[i][j] = null;
            }
        }
        for(int i=0; i<array.length; i++) {
            array[i] = null;
        }
    }

    public int insertVertex(int v) {
        int result = WORK_FAIL;

        if(cursor < this.size) {
            array[++cursor] = v;
            result = WORK_SUCCESS;
        }
        return result;
    }

    public int insertEdge(int v1, int v2) {
        int result = WORK_FAIL;

        if(isEmpty(v1,v2)) {
            matrix[v1][v2] = IN_VERTEX;
            matrix[v2][v1] = IN_VERTEX;
            result = WORK_SUCCESS;
        }

        return result;
    }

    public int deleteVertex(int v) {
        int result = WORK_FAIL;

        for(int i=0; i<array.length; i++) {
            if(array[i] == v) {
                array[i] = null;
                result = WORK_SUCCESS;
            }
        }

        return result;
    }

    public int deleteEdge(int v1, int v2) {
        int result = WORK_FAIL;

        if(matrix[v1][v2] != null) {
            matrix[v1][v2] = null;
            result = WORK_SUCCESS;
        }

        return result;
    }

    public boolean isEmpty(int v1,int v2) {
        return matrix[v1][v2] == null ? true : false;
    }

    public int[] Adjacent(int v) {
        int[] result = null;
        int idx = 0;

        for(int i=0; i<size; i++) {
            if(matrix[v][i] == IN_VERTEX) {
                result[idx++] = i;
            }
        }

        return result;
    }
}
