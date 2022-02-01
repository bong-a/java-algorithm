package Q08.Q08_12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] map, answer;
    static int max, n, m;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        m = in.nextInt();
        n = in.nextInt();
        map = new int[n + 1][m + 1];
        answer = new int[n + 1][m + 1];
        boolean flag = true;
        List<Point> points = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int tomato = in.nextInt();
                map[i][j] = tomato;
                if (tomato == 1) {
                    points.add(new Point(i, j));
                }
            }
        }
        main.BFS(points);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] == 0)
                    flag = false;
            }
        }
        if (!flag) {
            System.out.println(-1);
            return;
        }
        System.out.println(max);

    }

    private void BFS(List<Point> points) {
        Queue<Point> queue = new LinkedList<>();
        for (Point point : points) {
            queue.add(new Point(point.getX(), point.getY()));
            answer[point.getX()][point.getY()] = 0;
        }
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int nx = p.getX() + dx[i];
                int ny = p.getY() + dy[i];
                if (nx > 0 && nx <= n && ny > 0 && ny <= m && map[nx][ny] == 0) {
                    if (answer[nx][ny] == 0 ||
                        (answer[nx][ny] != 0 && answer[nx][ny] > (answer[p.getX()][p.getY()] + 1))) {
                        answer[nx][ny] = answer[p.getX()][p.getY()] + 1;
                        queue.offer(new Point(p.getX() + dx[i], p.getY() + dy[i]));
                        map[nx][ny] = 1;
                        max = Math.max(max, answer[nx][ny]);
                    }
                }
            }
        }
    }
}

class Point {
    int x, y;

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

