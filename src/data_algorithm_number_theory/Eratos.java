package data_algorithm_number_theory;

import java.util.ArrayList;

public class Eratos {

    /*
     * 에라토스테네스 체
     * - 소수를 구할 때 적용할 수 있는 알고리즘
     * - 특정 수가 소수이냐 아니냐를 아는데, 쓰는 건 비효율적
     * - 1 ~ N 까지 소수가 몇개인지 또는 모든 소수를 구하라
     */
    public static void main(String[] args) {

    }

    // 에라토스테네츠로 소수 갯수 구하기
    public static int getPrimeCountByEratos(int num) {
        int result = 0;
        boolean[] primeArr = new boolean[num+1];

        primeArr[0] = false;
        primeArr[1] = false;

        // int i=2; (i*i)<=n; i++

        for (int i=2; i<=num; i++) {

        }

        return result;
    }

    //
    public static ArrayList<Integer> getPrimeListByEratos(int num) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i=2; i<num; i++) {

        }

        return list;
    }
}
