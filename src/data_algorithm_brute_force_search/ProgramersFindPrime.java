package data_algorithm_brute_force_search;

import java.util.ArrayList;
import java.util.Arrays;

public class ProgramersFindPrime {
    /**

     [ 문제 설명 ]
     한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.

     각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.

     제한사항
     numbers는 길이 1 이상 7 이하인 문자열입니다.
     numbers는 0~9까지 숫자만으로 이루어져 있습니다.
     013은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
     입출력 예
     numbers	return
     17	3
     011	2
     입출력 예 설명
     예제 #1
     [1, 7]으로는 소수 [7, 17, 71]를 만들 수 있습니다.

     예제 #2
     [0, 1, 1]으로는 소수 [11, 101]를 만들 수 있습니다.

     11과 011은 같은 숫자로 취급합니다.

     */

    /*
        [ 알아두면 좋은 것들 ]
        - array sort reverse
        Array를 reverse sort 시키고 싶을 때, 직접 sort 알고리즘을 짜는것도 좋지만,
        정렬 문제가 아니라면, util에서 제공해주는 형식을 쓰는 것이 좋다.

        Integer[] array = new Integer[n];
        Arrays.sort(array, Collections.reverseOrder());


        - int를 string으로 형변환
        int numStr = Integer.toString(num);

        - string을 char[]으로 형변환
        char[] array = str.toCharArray();


        - 아스키 코드에서 외워두면 좋을것
        0 ~ 9  ->  [아스키코드] 48 ~ 57
        A ~ Z  ->  [아스키코드] 65 ~ 90
        a ~ z  ->  [아스키코드] 97 ~ 122

        - array deep copy
        int[] newArr = array.clone();
     */

    /*
        [ 문제 해설 ]
        개인적으로 좀 어려웠던 문제이다. 시간이 꽤 걸렸다.
        풀이를 나름 생각해냈지만, 이게 맞나? 하는 순간들이 많았고, 그러다보니
        디버깅 시간도 들었다. ( 코테에 나왔다면 이미 떨어졌음 )

        코테를 치를때도 이런 경우가 생길 것인데,
        이때 이 문제를 뛰어넘기 보다는 최대한 코드가 복잡해 지더라도
        풀고 넘어가는게 더 경제적일 수 있다.

        문제를 이거 봤다가 저거 봤다가 하는 건 오히려 시간을 잡아먹는다.


        문제는 일단 소수를 찾는것 부터 시작해야한다.
        소수 찾기 문제를 2~3번 정도 꼬은 문제이다.

         - 풀이 -
        1. 먼저 주어진 숫자로 만들수 있는 가장 큰 수를 먼저 찾았다.
        2. 그리고 그 큰수까지에 해당하는 소수 목록을 만들었다.
        3. 소수 목록을 차례대로 접근하여,각 자리수 배열을 만들고
        4. 입력값의 숫자를 모두 만족시키는 지
            모두 만족시킨다면 최종 결과물 배열에 담았다.
     */

    public static void main(String[] args) {
        solution("011");
        solution("17");

    }

    // 48 ~ 57
    public static int solution(String numbers) {
        char[] numArr = numbers.toCharArray();

        // 조합할 수 있는 가장 큰 수와 작은 수를 구한다.
        int[] minAndMax = getMinAndMax(numArr);
        int min = minAndMax[0];
        int max = minAndMax[1];

        // 에라토스체를 활용한 소수 목록을 받는다.
        int[] primeArr = getPrimList(min, max);


        char[] primSplited;
        char[] isExist;
        int matched;
        ArrayList<Integer> list = new ArrayList<>();
        // 소수 목록에 각각 접근해서, 입력받은 numbers와 매칭시킨다.
        // 각 소수의 모든 자리수가 매칭 되면 해당 소수를 list에 담는다.
        for (int i=0; i<primeArr.length; i++) {

            primSplited = Integer.toString(primeArr[i]).toCharArray();
            isExist = numArr.clone();
            matched = 0;

            for (int j=0; j<primSplited.length; j++) {
                for (int z=0; z<numArr.length; z++) {
                    if (primSplited[j] == isExist[z]) {
                        isExist[z] = 47;
                        matched++;
                        break;
                    }
                }
            }

            if (matched == primSplited.length) {
                list.add(primeArr[i]);
            }
        }

        return list.size();
    }

    public static int[] getMinAndMax(char[] numArr) {
        int[] minAndMax = {0, 0};
        String maxStr = "";


        Arrays.sort(numArr);
        // get min
        minAndMax[0] = numArr[0]-48;

        // get max
        for (int i=numArr.length-1; i>=0; i--) {
            maxStr += numArr[i];
        }
        minAndMax[1] = Integer.parseInt(maxStr);

        return minAndMax;
    }

    public static int[] getPrimList(int start, int end) {
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] isPrime = new boolean[end+1];

        for (int i=2; i<=end; i++) {
            isPrime[i] = true;
        }

        int idx;
        for (int i=2; i<=end; i++) {
            if (isPrime[i]) {
                idx = 1;
                for (int j=i; j<=end; j=i*idx) {
                    if (j!=i) {
                        isPrime[j] = false;
                    }
                    idx++;
                }
            }
        }

        for (int i=start; i<=end; i++) {
            if (isPrime[i]) {
                list.add(i);
            }
        }

        return list.stream().mapToInt(i->i).toArray();
    }

    /*
        [ 나보다 더 잘 푼 남들의 풀이모음 ]
        이번 문제는 마음에 들지 않는 코드로 풀었다. 또한 개인적으로 어렵게 느껴져서
        시간이 꽤 걸렸다. 생각해야할 변수도 많고 여러가지 과정을 거쳐야했다.
        만약 코딩테스트에서 풀었다면, 여기서 시간을 다 잡아 먹었을것이다.
     */
}

