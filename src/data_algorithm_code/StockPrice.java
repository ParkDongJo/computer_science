package data_algorithm_code;

import java.util.Stack;

public class StockPrice {

    /**
     [문제]
     초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때,
     가격이 유지된 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.

     [제한사항]
     prices의 각 가격은 1 이상 10,000 이하인 자연수입니다.
     prices의 길이는 2 이상 100,000 이하입니다.

     [입출력 예]
     prices	return
     [498,501,470,489]	[2,1,1,0]
     */
    public static void main(String[] args) {

        int[] arr = {498,501,470,489,220,500,430};
        long start = System.currentTimeMillis();
//        int[] result = solution(arr);
        int[] result = solution2(arr);
        long end = System.currentTimeMillis();


        System.out.println( "실행 시간 : " + ( end - start ));
        System.out.println( "실행 시간(초) : " + ( end - start )/1000.0 +"초");

        for (int item : result) {
            System.out.println(item);
        }
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i=0; i<prices.length; i++) {
            int seccond = 0;

            if (i == prices.length - 1) {
                break;
            }

            for(int j=i+1; j<prices.length; j++) {
                seccond++;
                if (prices[i] > prices[j]) {
                    answer[i] = seccond;
                    break;
                }

                if (j == prices.length - 1) {
                    answer[i] = seccond;
                }
            }
        }

        return answer;
    }

    public static int[] solution2(int[] prices) {
        int[] answer = new int[prices.length];

        Stack<Stock> stack = new Stack<>();


        for (int i = 0; i < prices.length ; i++) {
            int price = prices[i];

            while((!stack.isEmpty()) && (stack.peek().getCost() > price)) {
                Stock item = stack.pop();
                answer[item.getIndex()-1] = i + 1 - item.index;
            }

            stack.push(new Stock(i+1, prices[i]));
        }



        // stack 비우기
        while(!stack.isEmpty()) {
            Stock item = stack.pop();
            answer[item.getIndex()-1] = prices.length- item.index;
        }

        return answer;
    }

    public static class Stock {
        private int index;
        private int cost;

        public Stock(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        public int getCost() {
            return cost;
        }

        public int getIndex() {
            return index;
        }
    }
}
