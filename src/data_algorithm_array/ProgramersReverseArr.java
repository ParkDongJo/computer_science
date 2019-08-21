package data_algorithm_array;

import java.util.Arrays;
import java.util.Collections;

public class ProgramersReverseArr {

    /**
        [ 문제 설명 ]
        자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.

        [ 제한 조건 ]
        n은 10,000,000,000이하인 자연수입니다.

        [ 입출력 예 ]
        n	return
        12345	[5,4,3,2,1]
     */

    /*
        [ 알아두면 좋은 스킬 ]
        - java에서 string과 관련된 연산들은 StringBuilder()가 훨씬 성능상 좋다.

        String s = String.valueOf(n);
        StringBuilder sb = new StringBuilder(s);
        sb = sb.reverse();
        String[] strArr = sb.toString().split("");


        - 정수의 자릿수 길이를 얻고자 할때

        int length = Math.log10(temp)+1;
     */

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(solution(12345)));
//        long number = 10000000000L;
//        long number = 12345;
        long number = 9999999999L;
//        System.out.println(Arrays.toString(solution(number)));
        System.out.println(Arrays.toString(anotherSolution(number)));
    }

    public static int[] solution(long n) {
        String s = String.valueOf(n);
        StringBuilder sb = new StringBuilder(s);
        sb = sb.reverse();
        String[] strArr = sb.toString().split("");


        int[] answer = new int[strArr.length];
        for(int i=0; i<strArr.length; i++) {
            answer[i] = Integer.parseInt(strArr[i]);
        }
        return answer;
    }


    public static int[] anotherSolution(long n) {
        int[] answer;

        long temp = n;
        long length = (long)(Math.log10(temp)+1);

        answer = new int[(int)length];
        for(int i=0; i<length;i++){
            answer[i] = Integer.parseInt((temp%10)+"");
            temp = temp/10;
        }

        return answer;
    }
}