package data_algorithm_code;

import java.util.ArrayList;
import java.util.Scanner;

public class AlgoJobsBruteForceSearch10 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] matrix = new int[8][8];
        int num;

        King king = new King();
        ArrayList<Rook> rookList = new ArrayList<Rook>();

        for (int i=0; i<8; i++) {
            for (int j = 0; j < 8; j++) {
                num = scan.nextInt();
                matrix[i][j] = num;
                // 룩 위치 파악
                if (num == 2) {
                    Rook rook = new Rook();
                    rook.x = i;
                    rook.y = j;
                    rookList.add(rook);
                }
                // 킹 위치 파악
                if (num == 1) {
                    king.x = i;
                    king.y = j;
                }
            }
        }

        int x;
        int y;
        int result = 0;
        for (int i=0; i<rookList.size(); i++) {
            Rook rook = rookList.get(i);
            x = rook.x;
            y = rook.y;

            // x축 탐색
            if (king.x == rook.x) {
                // 잡혔다는 가정부터 시작
                result = 1;
                for (int idx=0; idx<8; idx++) {
                    if (matrix[x][idx] == 3) {
                        if (rook.y > king.y) {
                            if (king.y < idx && idx < rook.y) {
                                result = 0;
                            }
                        }

                        if (rook.y < king.y) {
                            if (rook.y < idx && idx < king.y) {
                                result = 0;
                            }
                        }
                    }
                }
            } // x축 탐색 if() end

            // y축 탐색
            if (king.y == rook.y) {
                // 잡혔다는 가정부터 시작
                result = 1;
                for (int idx=0; idx<8; idx++) {
                    if(matrix[idx][y] == 3) {
                        if (rook.x > king.x) {
                            if (king.x < idx && idx < rook.x) {
                                result = 0;
                            }
                        }

                        if (rook.x < king.x) {
                            if (rook.x < idx && idx < king.x) {
                                result = 0;
                            }
                        }
                    }
                }
            } // y축 탐색 if() end
        }

        System.out.println(result);
    }

    public static class Rook {
        public int x;
        public int y;
        public Rook() {
            this.x = -1;
            this.y = -1;
        }
    }
    public static class King {
        public int x;
        public int y;
        public King() {
            this.x = -1;
            this.y = -1;
        }
    }
}
