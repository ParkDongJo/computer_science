package data_algorithm_sort_upgrade;

    /**
     * 문제 설명
     * 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
     *
     * 예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.
     *
     * 0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.
     *
     * 제한 사항
     * numbers의 길이는 1 이상 100,000 이하입니다.
     * numbers의 원소는 0 이상 1,000 이하입니다.
     * 정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
     * 입출력 예
     * numbers	return
     * [6, 10, 2]	6210
     * [3, 30, 34, 5, 9]    9534330
     */

    /*
        [알아두면 좋을 것들]

        // int를 string으로 변환
        String str = Integer.toString(number);

        // Math 승수
        double result = Math.pow(n,r); // n^r

        // 문자열 비교
        int result = string1.compareTo(string2)
        // result == 0 : 두 문자열이 같다
        // result < 0 : string1이 더 작다
        // result > 0 : string2가 더 크다
     */
public class ProgramersFindMax {
    public static void main(String[] args) {
//        int[] numbers = {6, 10, 2};
//        int[] numbers = {3, 30, 34, 5, 9};
//        int[] numbers = {0, 0, 0};
//        int[] numbers = {5, 546};
//        int[] numbers = {0,0,1000,0};
//        int[] numbers = {0,0,70};
//        int[] numbers = {12,1213};
//        int[] numbers = {2,22,223};
//        int[] numbers = {2,22};
        int[] numbers = {12, 1213};
//        int[] numbers = {70, 0, 0, 0};


        System.out.println(solution(numbers));

    }

    public static String solution(int[] numbers) {
        mergeSort(numbers, 0, numbers.length - 1);

        if (numbers[0] == 0) {
            return "0";
        }

        String answer = "";
        for (int i=0; i<numbers.length; i++) {
            answer += Integer.toString(numbers[i]);
        }

        return answer;
    }

    public static void mergeSort(int[] arr, int start, int end) {

        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;

        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);

        merge(arr, start, mid, mid + 1, end);
    }

    public static void merge(int[] arr, int start1, int end1, int start2, int end2) {
        int cursor1, cursor2;
        int[] temp = new int[100];
        int idx = 0;

        cursor1 = start1;
        cursor2 = start2;

        int digit1;
        int digit2;

        String prevNum;
        String nextNum;

        while (cursor1 <= end1 && cursor2 <= end2) {
            digit1 = arr[cursor1] / (int) Math.pow(10, String.valueOf(arr[cursor1]).length());
            digit2 = arr[cursor2] / (int) Math.pow(10, String.valueOf(arr[cursor2]).length());


            if (digit1 >= digit2) {


                if (digit1 == digit2) {
                    prevNum = Integer.toString(arr[cursor1]);
                    nextNum = Integer.toString(arr[cursor2]);

                    if ((prevNum+nextNum).compareTo(nextNum+prevNum) >= 0 ) {
                        temp[idx++] = arr[cursor1];
                        cursor1++;
                    } else {
                        temp[idx++] = arr[cursor2];
                        cursor2++;
                    }

                } else {
                    temp[idx++] = arr[cursor1];
                    cursor1++;
                }

            } else {
                // 뒤 배열의 cursor2의 값이 작으면 앞에 정렬
                temp[idx++] = arr[cursor2];
                cursor2++;
            }

        }

        if (cursor1 <= end1) {
            for (int i=cursor1; i<=end1; i++) {
                temp[idx++] = arr[i];
            }
        }

        if (cursor2 <= end2) {
            for (int i=cursor2; i<=end2; i++) {
                temp[idx++] = arr[i];
            }
        }

        for (int i=start1; i<=end2; i++) {
            arr[i] = temp[i-start1];
        }
    }
}
