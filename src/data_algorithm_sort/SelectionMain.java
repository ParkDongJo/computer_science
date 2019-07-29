package data_structure_sort;

/**
 * Created by parkdongjo on 2017. 6. 3..
 */
public class SelectionMain {

    public static void main(String[] args) {

        int[] array = {10,3,1,5,4,7,9,2,6,8};
        int temp = 0;

        for(int i=0; i<array.length; i++) {

            int min = array[i];
            int min_index = i;

            for(int j=array.length-1; j>i; j--) {

                if(min > array[j]) {
                    min = array[j];
                    min_index = j;
                }

            }

            temp = array[i];
            array[i] = min;
            array[min_index] = temp;

        }

        for(int i =0; i<array.length; i++) {
            System.out.print(array[i] + ", ");
        }

    }

}
