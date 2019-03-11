package data_structure_sort;

public class SortAlgorithmAll {
    public static void main(String[] args) {
        int[] testArr = {3,4,7,2,1,6,5};
//        int[] result = selectSort(testArr);
//        print(result);

//        int[] result = insertSort(testArr);
//        print(result);

        int[] result = bubbleSort(testArr);
        print(result);

    }

    // 선택 정렬
    public static int[] selectSort(int[] _array) {
        int[] array = _array;
        int idx;

        for (int i=0; i<array.length; i++) {
            idx = i;
            for (int j=i+1; j<array.length; j++) {
                if (array[idx] > array[j]) {
                    idx = j;
                }
            }
            swap(array, idx, i);
        }

        return array;
    }

    // 삽입 정렬
    public static int[] insertSort(int[] _array) {
        int[] array = _array;

        for (int i=1; i<array.length; i++) {
            for (int j=i; j>0; j--) {
                if (array[j] < array[j-1]) {
                    swap(array, j, j-1);
                } else {
                    break;
                }
            }
        }

        return array;
    }

    // 버블 정렬
    public static int[] bubbleSort(int[] _array) {
        int[] array = _array;

        for (int i=0; i<array.length; i++) {
            for (int j=0; j<array.length - i -1; j++) {
                if (array[j] > array[j+1]) {
                    swap(array, j, j+1);
                }
            }
        }

        return array;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void print(int[] array) {
        for(int i=0; i<array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

}
