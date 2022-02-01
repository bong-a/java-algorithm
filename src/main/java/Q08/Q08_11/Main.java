package Q08.Q08_11;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] map, dis;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);

        map = new int[8][8];
        dis = new int[8][8];
        for (int i = 1; i < 8; i++) {
            for (int j = 1; j < 8; j++) {
                map[i][j] = in.nextInt();
            }
        }
        main.BFS(1, 1);
        System.out.println(dis[7][7] == 0 ? -1 : dis[7][7]);
    }

    private void BFS(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int tempX = p.getX() + dx[i];
                int tempY = p.getY() + dy[i];
                if (tempX > 0 && tempX <= 7 && tempY > 0 && tempY <= 7 && map[tempX][tempY] == 0) {
                    map[tempX][tempY] = 1;
                    queue.offer(new Point(tempX, tempY));
                    dis[tempX][tempY] = dis[p.getX()][p.getY()] + 1;
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
