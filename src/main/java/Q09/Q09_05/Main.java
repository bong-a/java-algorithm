package Q09.Q09_05;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] arr = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            arr[x][y] = 1;
            arr[y][x] = 1;
        }
        int x = in.nextInt();
        int y = in.nextInt();
        System.out.println(main.solution(n, arr, x, y));
    }

    private String solution(int n, int[][] arr, int x, int y) {
        for (int i = 1; i < arr[x].length; i++) {
            if (arr[x][i] == 1) {
                Queue<Integer> queue = new LinkedList<>();
                int[] ch = new int[n + 1];
                queue.offer(i);
                ch[x] = 1;
                while (!queue.isEmpty()) {
                    int row = queue.poll();
                    if (row == y) {
                        return "YES";
                    }
                    for (int col = 0; col < arr[row].length; col++) {

                        if (arr[row][col] == 1 && ch[col] == 0) {
                            queue.offer(col);
                        }
                    }
                    ch[row] = 1;
                }
            }
        }
        return "NO";
    }
}