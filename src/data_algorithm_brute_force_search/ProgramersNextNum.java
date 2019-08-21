package data_algorithm_brute_force_search;

public class ProgramersNextNum {

    public static void main(String[] args) {
        //1001110
        System.out.println(solution(78));
    }

    public static int solution(int n) {
        int oneCntOfbitN = getOneCountInBit(Integer.toBinaryString(n));
        int oneCntOfNext = 0;
        int next = n;

        do {
            oneCntOfNext = getOneCountInBit(Integer.toBinaryString(++next));
        } while (oneCntOfbitN != oneCntOfNext);

        int answer = next;
        return answer;
    }

    public static int getOneCountInBit(String binary) {
        int count = 0;
        String[] binaryArr = binary.split("");
        for (int i=0; i<binaryArr.length; i++) {
            if (binaryArr[i].equals("1")) {
                count++;
            }
        }
        return count;
    }
}
