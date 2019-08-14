package data_algorithm_brute_force_search;


import java.util.ArrayList;
import java.util.Arrays;

public class ProgramersMockTest {

    /**
    [문제풀이]
    수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

    1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
    2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
    3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

    1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아
    return 하도록 solution 함수를 작성해주세요.

    [제한 조건]
    시험은 최대 10,000 문제로 구성되어있습니다.
    문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
    가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.

    [입출력 예]
    answers	return
    [1,2,3,4,5]	[1]
    [1,3,2,4,2]	[1,2,3]

    입출력 예 설명
    입출력 예 #1

    수포자 1은 모든 문제를 맞혔습니다.
    수포자 2는 모든 문제를 틀렸습니다.
    수포자 3은 모든 문제를 틀렸습니다.
    따라서 가장 문제를 많이 맞힌 사람은 수포자 1입니다.

    입출력 예 #2

    모든 사람이 2문제씩을 맞췄습니다.
     */

    /*
        알아두면 좋을 것들

        java는(C도 마찬가지) 동적타입 언어 python과 javascript 등등과
        달리 array와 list의 구분이 엄격하다.
        구조상 array는 동적으로 구현 불가능 하다.
        이때 list가 유용한데, 너무 큰 데이터가 아니라면
        아래와 같이 변환하여 쓰는것이 빠른 코딩을 달성 할 수 있다.

        List로 구현 후 Array로 변환 (속도를 측정해볼 필요는 있음)
        ------------------------------------------------------
        ArrayList<Integer> list = new ArrayList<Integer>();

        int[] answer = list.stream().mapToInt(i->i).toArray();
        ------------------------------------------------------
     */

    /*
        [ 생각의 핵심 ]
        1. 규칙을 파악하고 그 규칙에 따라 정답을 비교해간다. (idx % 규칙패턴) 공식을 활용한다.

        2. 가장큰수를 뽑아내는데, 조건이 있다. 바로 중복된 수가 있다는 것이다.
           또한 해당 수를 알아야 하는 것이 아니라, 그 수의 Index를 정답으로 제출해야한다.

           - 큰수를 찾는다.
           - 큰수에 해당하는 인덱스를 찾는다.

           보면 두가지 작업으로 나눠서 해결했다.
           대부분 생각이 꼬이는 경우가 여러가지 일을 하나의 task에 담으려고 할때
           코드도 엉망이 되고 생각도 엉망이 된다.

           이럴때는 작업을 나눈다.
           반복문을 한번 더 도는 한이 있더라도 작업을 둘로 나누는 것이다.
           코드에 대한 최적화는 그 이후에 한다!(남는 시간이 있다면.. 지금 경우는 굳이 안해도 될것 같다)

     */

    public static void main(String[] args) {
        int [] a = {1,2,3,4,5};
        int [] b = {1,3,2,4,2};
        System.out.println(Arrays.toString(solution(a)));
        System.out.println(Arrays.toString(solution(b)));


    }

    public static int[] solution(int[] answers) {
        int[] aPattern = {1,2,3,4,5};           //5
        int[] bPattern = {2,1,2,3,2,4,2,5};     //8
        int[] cPattern = {3,3,1,1,2,2,4,4,5,5}; //10
        int[] score = {0,0,0};
        int cursor;

        for (int i=0; i<answers.length; i++) {
            cursor = answers[i];

            //1번 핵심생각 구현
            if (aPattern[i%5] == cursor) {
                score[0]++;
            }
            if (bPattern[i%8] == cursor) {
                score[1]++;
            }
            if (cPattern[i%10] ==  cursor) {
                score[2]++;
            }
        }

        //2번 핵심생각 구현
        int max = score[0];
        for (int i=0; i<score.length; i++) {
            if (score[i] > max){
                max = score[i];
            }
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=0; i<score.length; i++) {
            if (max == score[i]) {
                list.add(i+1);
            }
        }

        int[] answer = list.stream().mapToInt(i->i).toArray();
        return answer;
    }
}
