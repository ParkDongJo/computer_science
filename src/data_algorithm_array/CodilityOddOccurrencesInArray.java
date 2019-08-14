package data_algorithm_array;

import java.util.Arrays;
import java.util.Collections;

public class CodilityOddOccurrencesInArray {
    /**
     [문제]
     A non-empty array A consisting of N integers is given. The array contains an odd number of elements,
     and each element of the array can be paired with another element that has the same value, except for one element that is left unpaired.

     For example, in array A such that:

     A[0] = 9  A[1] = 3  A[2] = 9
     A[3] = 3  A[4] = 9  A[5] = 7
     A[6] = 9
     the elements at indexes 0 and 2 have value 9,
     the elements at indexes 1 and 3 have value 3,
     the elements at indexes 4 and 6 have value 9,
     the element at index 5 has value 7 and is unpaired.
     Write a function:

     class Solution { public int solution(int[] A); }

     that, given an array A consisting of N integers fulfilling the above conditions, returns the value of the unpaired element.

     For example, given array A such that:

     A[0] = 9  A[1] = 3  A[2] = 9
     A[3] = 3  A[4] = 9  A[5] = 7
     A[6] = 9
     the function should return 7, as explained in the example above.

     Write an efficient algorithm for the following assumptions:

     N is an odd integer within the range [1..1,000,000];
     each element of array A is an integer within the range [1..1,000,000,000];
     all but one of the values in A occur an even number of times.
     Copyright 2009–2019 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
     */

    /*
        알아두면 좋을 것들
        정렬이 필요할 시 도움이 될 java util Arrays를 활용한다.
        일일이 정렬 알고리즘을 짤 필요도 없고
        내부적으로 빠른 시간복잡도를 가진다.

        ----------------------------------------------
        int [] arr = { ... }
        Arrays.sort(arr)

        Integer [] arr = { ... }
        Arrays.sort(arr, Collections.reverseOrder())
        ----------------------------------------------


        java util의 sort()의 시간복잡도는 아래의 설명과 같다.

        It uses dual-pivot quicksort for primitives,
        which though better than a standard quicksort could still degrade into a quadratic running time.

        For non-primitive types, it uses TimSort, essetially a hybrid of merge sort and insertion sort,
        which makes it adapt to the test cases with a worst case run-time of Θ(𝑛log𝑛)Θ(nlog⁡n)

        For that reason, whenever you need a sorted array,
        it’s better to use a non-primitive if your array is huge and may contain nearly sorted sequences.
        [참고] - https://www.quora.com/What-is-the-complexity-of-Arrays-sort-in-java-Also-why-isn%E2%80%99t-it-as-efficient-as-quick-sort-in-C-or-C++

     */

    /*
        [ 생각의 핵심 ]
        짝이 없는 수를 찾는 다면,
        중복된 수를 모아두고 처음부터 끝까지 돌면서 숫자를 세고 짝수, 홀수를 비교하자
        만약 홀수가 나온다면 짝이 없는 수이다.

     */

    public static void main(String[] args) {
        int [] arr = {9,3,9,3,9,7,9};
        System.out.println(solution(arr));
    }

    public static int solution(int[] A) {
        int [] arr = A;
        Arrays.sort(arr);
        int current;
        int cursor = 0;
        int count = 0;

        for (int i=0; i<arr.length; i++) {
            current = arr[i];

            if (current == cursor) {
                count++;
            } else {
                if (count % 2 != 0) {
                    break;
                } else {
                    count = 1;
                    cursor = current;
                }
            }
        }

        return cursor;
    }
}
