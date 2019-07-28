package data_algorithm_code;

import java.util.Scanner;

/**
 * 맞았습니다.
 */

public class BaeckjoonEx1193 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        int childGroupN = 1;
        int parentGroupN = 1;
        int childNum = 0;
        int parentNum = 0;
        int sumGroupCnt =0;


        /**
         * 중심축 : 2*n -1
         * 그룹갯수 : 4*n -3
         */
        //분자 그룹 찾기
        while (true) {
            sumGroupCnt += 4*childGroupN-3;

            if(x <= sumGroupCnt) {
                int location = (4*childGroupN-3) - (sumGroupCnt - x);
                int centerNum = 2*childGroupN-1;

                if(location >= centerNum) {
                    childNum = centerNum - (location - centerNum);
                    if(location == centerNum) {
                        childNum = centerNum;
                    }
                }else{
                    childNum = location;
                }

                break;
            }

            childGroupN++;
        }

        sumGroupCnt =0;

        /**
         * 중심축 : 2n
         * 그룹갯수 : 4n-1
         */
        //분자 그룹 찾기
        while (true) {
            sumGroupCnt += 4*parentGroupN-1;

            if(x <= sumGroupCnt) {

                int location = (4*parentGroupN-1) - (sumGroupCnt - x);
                int centerNum = 2*parentGroupN;

                if(location >= centerNum) {
                    parentNum = centerNum - (location - centerNum);
                    if(location == centerNum) {
                        parentNum = centerNum;
                    }
                }else{
                    parentNum = location;
                }

                break;
            }

            parentGroupN++;
        }

        System.out.println(childNum +"/" + parentNum);
    }
}
