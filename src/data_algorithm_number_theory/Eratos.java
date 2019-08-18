package data_algorithm_number_theory;

import java.util.ArrayList;
import java.util.Arrays;

public class Eratos {

    public static final boolean IS_NOT_PRIME = true;
    public static final boolean IS_PRIME = false;
    /*
     * 에라토스테네스 체
     * - 소수를 구할 때 적용할 수 있는 알고리즘
     * - 특정 수가 소수이냐 아니냐를 아는데, 쓰는 건 비효율적
     * - 1 ~ N 까지 소수가 몇개인지 또는 모든 소수를 구하라
     */
    public static void main(String[] args) {
        int count = getPrimeCountByEratos(1000000);
        System.out.println(count);

        ArrayList<Integer> list = getPrimeListByEratos(100);
        System.out.println(Arrays.toString(list.stream().mapToInt(i->i).toArray()));
    }

    // 에라토스테네츠로 소수 갯수 구하기
    public static int getPrimeCountByEratos(int n) {
        boolean[] numbers = new boolean[n+1];
        int idx;
        // int i=2; (i*i)<=n; i++

        for (int i=2; i<=n; i++) {
            idx = 1;
            for (int j=i; j<=n; j=i*idx) {
                if (j != i) {
                    numbers[j] = IS_NOT_PRIME;
                }
                idx++;
            }
        }

        int count = 0;
        for (int i=2; i<=n; i++) {
            if (numbers[i] == IS_PRIME) {
                count++;
            }
        }

        return count;
    }

    // 에라토스테네츠로 소수 목록 구하기
    public static ArrayList<Integer> getPrimeListByEratos(int n) {
        boolean[] numbers = new boolean[n+1];
        int idx;
        ArrayList<Integer> primeList = new ArrayList<Integer>();

        for (int i=2; i<=n; i++) {
            idx = 1;
            for (int j=i; j<=n; j=i*idx) {
                if (j != i) {
                    numbers[j] = IS_NOT_PRIME;
                }
                idx++;
            }
        }

        for (int i=2; i<=n; i++) {
            if (numbers[i] == IS_PRIME) {
                primeList.add(i);
            }
        }

        return primeList;
    }
}
