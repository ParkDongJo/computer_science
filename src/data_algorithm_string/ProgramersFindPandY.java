package data_algorithm_string;

public class ProgramersFindPandY {

    /**

     [ 문제 설명 ]
     대문자와 소문자가 섞여있는 문자열 s가 주어집니다. s에 'p'의 개수와 'y'의 개수를 비교해 같으면 True, 다르면 False를 return 하는 solution를 완성하세요. 'p', 'y' 모두 하나도 없는 경우는 항상 True를 리턴합니다. 단, 개수를 비교할 때 대문자와 소문자는 구별하지 않습니다.

     예를 들어 s가 pPoooyY면 true를 return하고 Pyy라면 false를 return합니다.

     [ 제한사항 ]
     문자열 s의 길이 : 50 이하의 자연수
     문자열 s는 알파벳으로만 이루어져 있습니다.

     [ 입출력 예 ]
     s	answer
     pPoooyY	true
     Pyy	false
     입출력 예 설명
     입출력 예 #1
     'p'의 개수 2개, 'y'의 개수 2개로 같으므로 true를 return 합니다.

     입출력 예 #2
     'p'의 개수 1개, 'y'의 개수 2개로 다르므로 false를 return 합니다.

     */
    /*
        [ 알아두면 좋을 것들 ]
        - Java에서 string의 분리는 StringBuilder 내장 객체를 사용하는 것이 좋다.
        StringBuilder sb = new StringBuilder(s);


        - StringBuild의 결과값을 char 형태로 뽑고자 할때
        sb.charAt(i)

     */

    /*
        [ 문제에 대한 해설 ]

     */

    public static void main(String[] args) {
        System.out.println(solution("pPoooyY"));
        System.out.println(solution("Pyy"));
    }

    public static boolean solution(String s) {
        boolean answer = false;

        int pCount = 0;
        int yCount = 0;

        StringBuilder sb = new StringBuilder(s);
        char cursor;
        for (int i=0; i<sb.length(); i++) {
            cursor = sb.charAt(i);

            if (cursor == 89 || cursor == 121) {
                yCount++;
            } else if (cursor == 80 || cursor == 112) {
                pCount++;
            }
        }

        if (yCount == pCount) {
            answer = true;
        }

        return answer;
    }
}
