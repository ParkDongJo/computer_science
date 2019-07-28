package data_algorithm_code;

import java.util.Scanner;

public class AlgoJobsSpecial2 {
    // 재귀에서 필요한 변수는 전역으로 해놔라
    public static int[] array= new int[50];
    public static int n, k;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        k = scan.nextInt();

        f(0,0);
    }

    public static void f(int length, int one) {
        if(length == n) {
            if (one == k) {
                for (int i=0; i<length; i++) {
                    System.out.print(array[i]);
                }
                System.out.println("");
            }
            return;
        }
        // 재귀 함수가 더이상 수행될 필요 없을 시
        // 더이상 수행되지 않도록 컷팅을 해줘야한다.
        // 재귀가 돌아간다고 정답이 될 수 없는 이유이다.
        if(one > k) {
            return;
        }

        //1
        array[length] = 1;
        //재귀 함수 안에 값을 증가 시킬 땐 ++ --를 쓰지 말고
        //임시로 증가시켜줘야한다.(위험함)
        f(length+1, one+1);

        //0
        array[length] = 0;
        f(length+1, one);
    }

}
