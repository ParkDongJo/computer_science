package data_algorithm_code;
import java.util.Scanner;

/**
 * 맞혔습니다.
 */
public class BaeckjoonEx2839 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int total = scan.nextInt();
        scan.nextLine();

        if(total!=4 && total!=7) {
            switch(total%10) {
                case 9:
                    System.out.println((total-9)/5 + 3);
                    break;
                case 8:
                    System.out.println((total-8)/5 + 2);
                    break;
                case 7:
                    System.out.println((total-17)/5 + 5);
                    break;
                case 6:
                    System.out.println((total-6)/5 + 2);
                    break;
                case 5:
                    System.out.println((total-5)/5 + 1);
                    break;
                case 4:
                    System.out.println((total-14)/5 + 4);
                    break;
                case 3:
                    System.out.println((total-3)/5 + 1);
                    break;
                case 2:
                    System.out.println((total-12)/5 + 4);
                    break;
                case 1:
                    System.out.println((total-11)/5 + 3);
                    break;
                case 0:
                    System.out.println(total/5);
                    break;
            }
        }else{
            System.out.println(-1);
        }
    }
}
