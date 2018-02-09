package data_algorithm_code;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BaeckjoonEx2108 {

    private static int[] arr;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = scan.nextInt();
        }

        System.out.println(getAverage(arr));
        System.out.println(getCenterNum(arr));
        System.out.println(getFrequencyNum(arr));
        System.out.println(getRange(arr));

    }

    public static int getAverage(int[] arr) {
        int sum = 0;
        for(int i=0; i<arr.length; i++) {
            sum += arr[i];
        }

        return sum/arr.length;
    }
    public static int getCenterNum(int[] arr) {
        int idx = arr.length/2;
        return arr[idx+1];
    }
    public static int getFrequencyNum(int[] arr) {
        HashMap<Integer,Integer> freqs = new HashMap<Integer,Integer>();

        for(int i=0; i<arr.length; i++) {
            if(freqs.get(arr[i]) == null) {
                freqs.put(arr[i],1);
            }else{
                int cnt = freqs.get(arr[i]);
                freqs.put(arr[i],++cnt);
            }
        }



        freqs.forEach((k,v) ->
                System.out.println("key: "+k+" value:"+v)
        );
        
        return 0;
    }
    public static int getRange(int[] arr) {
        return 0;
    }
}
