package data_algorithm_code;

import java.util.Scanner;

/**
 * 맞았습니다.
 */

public class BaeckjoonEx2941 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();

        String[] croatia = {"c=","c-","dz=","d-","lj","nj","s=","z="};

        for(int i=0; i<croatia.length; i++) {
            str = str.replaceAll(croatia[i], "@");
        }

        System.out.println(str.length());
    }
}
