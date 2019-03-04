import java.util.Scanner;

public class MainClass {
    public static void main(String [ ] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int num = n + (n / 2) * 2;

        for(int i=0; i<num; i++) {

            if ((i+1)%2 == 1) {
                for(int j=0; j<n-1; j++) {

                    if (i == n-1 && j > (n / 2) - 1) {
                        System.out.print("*");
                    } else {

                        if (j== ((num-1)-i / 2))
                        {
// 2-8=6 / = 3
// 4-8=4 /2
// 6-8=2 /1
// 8-8=0 /0
                            System.out.print("*");
                        }else {
                            System.out.print(" ");
                        }
                    }
                }

                if(i==0 || i==n-1) {
                    System.out.print("*");
                } else  {
                    System.out.print(" ");
                }

                for(int k=n; k<num; k++) {
//                    System.out.print("+");

                    if (i == n-1 && k < num-(n / 2)) {
                        System.out.print("*");
                    } else {
                        if ((i==2 && k==5) ||       // 2(3-1) / = 3
                                (i==6 && k==7) ||  // 6(7-1) / = 1
                                (i==8 && k==8))    // 8(9-1)  /  = 0
                        {

                            System.out.print("*");
                        }else {
                            System.out.print(" ");
                        }
                    }
                }

            }

            System.out.println("");
        }
    }

    /*
        3

        1 2 3    0,0  0,1  0,2
        8 9 4    1,0  1,1  1,2
        7 6 5    2,0  2,1  2,2

        i - 0 1 2 /
        j - 0 1 2 /
        i - 2, 1, 0 /
        j - 2, 1, [0] /
        i - 0, 1, [2]

        4

        1 2 3 4        0,0  0,1  0,2  0,3
        12 13 14 5     1,0  1,1  1,2  1,3
        11 16 15 6     2,0  2,1  2,2  2,3
        10 9 8 7       3,0  3,1  3,2  3,3

        i - 0 1 2 3 /
        j - 0 1 2 3 /
        i - 3 2, 1, 0 /
        j - 3 2, 1, [0] /
        i - 0, 1, 2, [3] /
        j - [0], 1, 2, [3] /
        i - [3], 2, 1, [0]
*/


    public static int[] quick(int[] array, int l, int r) {
        int left = l;
        int right = r;
        int pivot = array[l + r / 2];

        do {
//            if (array[left] < pivot) {
//                left++;
//            }
//            if (array[right] > pivot) {
//                right--;
//            }
            while(array[left] < pivot) left++;
            while(array[right] > pivot) right--;

            if (left <= right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }

        } while(left <= right);

        if(l < right) quick(array, l, right);
        if(r > left) quick(array, left, r);

        return array;
    }

//    public void sort(int[] data, int l, int r){
//        int left = l;
//        int right = r;
//        int pivot = data[(l+r)/2];
//
//        do{
//            while(data[left] < pivot) left++;
//            while(data[right] > pivot) right--;
//            if(left <= right){
//                int temp = data[left];
//                data[left] = data[right];
//                data[right] = temp;
//                left++;
//                right--;
//            }
//        }while (left <= right);
//
//        if(l < right) sort(data, l, right);
//        if(r > left) sort(data, left, r);
//    }

}
