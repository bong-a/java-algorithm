package Q08.Q08_13_2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n, answer;

    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        main.solution(arr);
        System.out.println(answer);
    }

    private void solution(int[][] board) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    answer++;
                    board[i][j] = 0;
                    BFS(i, j, board);
                }
            }
        }
    }

    private void BFS(int x, int y, int[][] board) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int nx = p.getX() + dx[i];
                int ny = p.getY() + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1) {
                    board[nx][ny] = 0;
                    queue.add(new Point(nx, ny));
                }
            }
        }
    }
}

class Point {
    private int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
