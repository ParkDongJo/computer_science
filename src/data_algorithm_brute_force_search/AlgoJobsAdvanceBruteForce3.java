package data_algorithm_code;

import java.util.Scanner;

public class AlgoJobsAdvanceBruteForce3 {
    /**
     [문제]
     임의의 자연수는 그보다 작은 자연수들의 합으로 표현될 수 있다. 예를 들어 4의 경우,

     4 = 3+1
        = 2+2
        = 2+1+1
        = 1+1+1+1
     위와 같은 방법으로 표현 될 수 있다. 이 때 , 숫자의 구성이 같으면서 그 순서만이 다른 경우는 같은 경우로 생각하는데,
     예를 들어 다음 세 가지 경우는 모두 같은 경우이다.

     2 + 1 + 1, 1 + 2 + 1 , 1 + 1 + 2
     자연수 n을 입력 받아 이를 n보다 작은 자연수들의 합으로 나타내는 방법을
     모두 출력하는 프로그램을 재귀 호출을 사용하여 작성하시오.

     [입력]
     첫 줄에 2 이상 20 이하의 자연수 n이 주어진다.

     [출력]
     첫째 줄부터 모든 방법을 한 줄에 하나씩 출력한다. 하나의 식 안에는 큰 숫자가 앞으로 오도록 하고,
     전체적으로는 앞의 숫자가 큰 식이 먼저 출력되도록 한다. 숫자와 더하기 사이에는 공백이 없다.
     그리고 마지막 줄에는 나누어진 자연수의 개수를 출력한다.

     [예제]
     예제 입력
     5
     예제 출력
     4+1
     3+2
     3+1+1
     2+2+1
     2+1+1+1
     1+1+1+1+1
     6
     */
    public static int[] array = new int[30];
    public static int n;
    public static int count = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();

        printSumFunc(0, 0);
        System.out.print(count);
    }

    public static void printSumFunc(int sum, int len) {
        if (sum == n) {
            for (int i = 0; i < len; i++) {
                if (i!=0) {
                    System.out.print("+");
                }
                System.out.print(array[i]);
            }
            count++;
            System.out.println("");
            return;
        } else if (sum > n) {
            return;
        } else {
            for (int i=n-1; i>0; i--) {

                if (len == 0 || (array[len-1] >= i)) {
                    array[len] = i;
                    printSumFunc(sum+i, len+1);
                }

            }
        }
    }

    /*
        array[0] = 4;
        f(0+4) {
            if(4 != 5) {

            }
            array[1] = 4
            f(4+4) {
                if(8 != 5) {
                }
            }
            array[1] = 3
            f(4+3) {
            }
            array[1] = 2
            f(4+2) {
            }
            array[1] = 1
            f(4+1) {
                if(5 == 5) {
                    print(array);
                    return
                }
            }
        }
        array[0] = 3;
        f(0+3) {
            if(3 != 5) {
            }
            array[1] =
        }

     */
}
