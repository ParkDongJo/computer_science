package data_algorithm_binary_search;

public class BinarySearchRecrusive {

    public static void main(String[] args) {

    }

    public static int binarySearch(long[] arr, int start, int end, long value) {

        if (start > end) {
            return -1;
        } else if (start == end) {
            if (arr[start] == value) {
                return start;
            } else {
                return -1;
            }
        } else {

            int mid = (start + end) / 2;

            if (arr[mid] == value) {
                return mid;
            } else if (arr[mid] > value) {
                return binarySearch(arr, start, mid-1, value);
            } else {
                return binarySearch(arr, mid+1, end, value);
            }
        }
    }
}
