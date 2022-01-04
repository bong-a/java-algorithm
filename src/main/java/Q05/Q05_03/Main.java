package Q05.Q05_03;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        int m = in.nextInt();
        System.out.println(main.solution(arr, n, m, in));
    }

    public int solution(int[][] arr, int n, int m, Scanner in) {
        int cnt = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            int move = in.nextInt() - 1;
            int j = 0;
            int value = 0;
            while (value == 0 && j < n) {
                value = arr[j++][move];
            }
            if (value == 0) {
                continue;
            }
            arr[j - 1][move] = 0;
            Integer num = stack.peek();
            if (num != null && num == value) {
                stack.poll();
                cnt += 2;
            } else {
                stack.offerFirst(value);
            }
        }

        return cnt;
    }
}
