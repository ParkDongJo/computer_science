package data_structure_sort;

/**
 * Created by parkdongjo on 2017. 6. 9..
 */
public class InsertionMain {
    public static void main(String[] args) {

        int[] array = {10,3,1,5,4,7,9,2,6,8};
        //int[] afterArr = new int[10];

        int temp = 0;


        for(int i=1; i<array.length; i++) {
            temp = array[i];

            for(int j=i-1; j>=0; j--) {

                if(array[j] > temp) {
                    array[j+1] = array[j];
                    array[j] = temp;
                }
                if(array[j] > temp) {
                    array[j+1] = temp;
                }

            }


        }

        for(int i =0; i<array.length; i++) {
            System.out.print(array[i] + ", ");
        }

    }
}
