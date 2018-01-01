package data_algorithm_code;

/**
 * 맞혔습니다.
 */
public class BaeckjoonEx4673 {

    public static void main(String[] args) {

        int[] nums = new int[10000];

        for(int i=0; i<10000; i++) {
            nums[i] = i+1;
        }

        for(int i=0; i<10000; i++) {
            int num = i + 1;
            int unSelfNum = getChildNum(num+"");

            if((unSelfNum-1) < 10000) {
                nums[unSelfNum-1] = -1;
            }
        }

        for(int i=0; i<10000; i++) {
            if(nums[i] != -1) {
                System.out.println(nums[i]);
            }
        }
    }


    /**
     *  셀프 넙버 체크
     *  - 셀프넘은 자신을 만드는 이전의 숫자의 조합이 있냐 없냐, 즉 생성자가 있냐없냐 단, 생성자는 현재의 수보다 크기가 작아야 한다
     *  - 생성자의 여부르를 알기 위해서는 수를 쪼개야 하는데
     *   ex> 33 -> 33 + 3 + 3 = 39  ab -> ab + a + b ->
     *
     */
    public static int getChildNum(String num) {

        int origin = Integer.parseInt(num);

        for(int i=0; i<num.length(); i++) {
            origin += Integer.parseInt(num.charAt(i)+"");
        }

        return origin;
    }
}
