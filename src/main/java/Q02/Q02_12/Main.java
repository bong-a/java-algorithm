package Q02.Q02_12;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main main = new Main();
        int col = in.nextInt();
        int row = in.nextInt();
        System.out.println(main.solution(row, col, in));
    }

    public int solution(int row, int col, Scanner in) {
        int[][] map = new int[row][col];
        for (int i = 0; i < row; i++) {
            int rank = 1;
            for (int j = 0; j < col; j++) {
                map[i][in.nextInt() - 1] = rank++;
            }
        }

        int count = 0;
        for (int j = 0; j < col; j++) {
            int[] cols = new int[col];
            for (int i = 0; i < row; i++) {
                int num = map[i][j];
                for (int k = 0; k < col; k++) {
                    if (k == j) {
                        continue;
                    }
                    if (num < map[i][k]) {
                        cols[k] += 1;
                    }
                }

            }
            for (int i : cols) {
                if (i == row) {
                    count++;
                }
            }
        }
        return count;
    }
}
