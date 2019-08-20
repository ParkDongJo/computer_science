package data_algorithm_binary_search;

import java.util.Scanner;

public class BeackjoonEx1654 {
    /**

     [ 문제 ]
     집에서 시간을 보내던 오영식은 박성원의 부름을 받고 급히 달려왔다. 박성원이 캠프 때 쓸 N개의 랜선을 만들어야 하는데 너무 바빠서 영식이에게 도움을 청했다.

     이미 오영식은 자체적으로 K개의 랜선을 가지고 있다. 그러나 K개의 랜선은 길이가 제각각이다.
     박성원은 랜선을 모두 N개의 같은 길이의 랜선으로 만들고 싶었기 때문에 K개의 랜선을 잘라서 만들어야 한다.
     예를 들어 300cm 짜리 랜선에서 140cm 짜리 랜선을 두 개 잘라내면 20cm 은 버려야 한다. (이미 자른 랜선은 붙일 수 없다.)

     편의를 위해 랜선을 자르거나 만들 때 손실되는 길이는 없다고 가정하며,
     기존의 K개의 랜선으로 N개의 랜선을 만들 수 없는 경우는 없다고 가정하자.
     그리고 자를 때는 항상 센티미터 단위로 정수길이만큼 자른다고 가정하자. N개보다 많이 만드는 것도 N개를 만드는 것에 포함된다.
     이때 만들 수 있는 최대 랜선의 길이를 구하는 프로그램을 작성하시오.

     입력
     첫째 줄에는 오영식이 이미 가지고 있는 랜선의 개수 K, 그리고 필요한 랜선의 개수 N이 입력된다.
     K는 1이상 10,000이하의 정수이고, N은 1이상 1,000,000이하의 정수이다. 그리고 항상 K ≦ N 이다.
     그 후 K줄에 걸쳐 이미 가지고 있는 각 랜선의 길이가 센티미터 단위의 정수로 입력된다. 랜선의 길이는 231-1보다 작거나 같은 자연수이다.

     출력
     첫째 줄에 N개를 만들 수 있는 랜선의 최대 길이를 센티미터 단위의 정수로 출력한다.

     시간 제한 : 2 초

     [ 예제 입력 ]
     4 11
     802
     743
     457
     539

     [ 예제 출력 ]
     200
     */

    /*
        [ 알아두면 좋은 것 ]

     */

    /*
        [ 문제 풀이 ]
        일단 정답을 어떻게 찾을건지에 대한 고민부터 해야하는 문제이다.
        렌선이 모두 붙었을 시 k로 나눴을 때 나온 기준값을 시작으로

        N개를 만들 수 있는 최대 렌선 길이를 빠르게 찾아야 한다.
        제한시간과 입력 시 조건들을 고려해봤을 시
        완전 탐색이 아닌 더 빠른 시간복잡도를 내는 이진탐색으로 찾아야 한다.

        몇몇 테스트 예제를 통과는 했으나,
        물론.. 아직 해당 문제는 통과를 하진 않닸다.
        런타임 에러가 난 상황
    */

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt();
        int n = scan.nextInt();
        long[] nums = new long[k];
        int sum = 0;

        for (int i=0; i<k; i++) {
            nums[i] = scan.nextInt();
            sum += nums[i];
        }

        System.out.println(solution(nums, sum, n));

    }

    public static long solution(long[] arr,int sum, int n) {

        long[] resultArr = new long[sum / n];

        for (int i=0; i<resultArr.length; i++) {
            resultArr[i] = i + 1;
        }

        long mid;
        long start = 1;
        long end = resultArr.length -1;
        long max = 0;

        while (start <= end) {
            mid = (start+end)/2;

            long allCount = 0;

            for(int j=0; j<arr.length; j++) {
                allCount = allCount + arr[j]/mid;
            }

            if(allCount >= n) {
                start = mid + 1;
                if (mid > max)
                    max = mid;
            }else if(allCount < n) {
                end = mid - 1;
            }
        }

        return max;
    }

}
