package data_structure_sort;

/**
 * Created by parkdongjo on 2017. 6. 3..
 */
public class BubbleMain {


    public static void main(String[] args) {

        int[] array = {10,3,1,5,4,7,9,2,6,8};
        int temp = 0;

        for(int i =0; i<array.length; i++) {
            for (int j = 0; j<array.length; j++) {

                if(array[i] > array[j]) {
                    temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }


            }
        }

        for(int i=0; i<array.length; i++) {
            System.out.print(array[i] + ", ");

        }

    }

}
