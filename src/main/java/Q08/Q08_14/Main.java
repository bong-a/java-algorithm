package Q08.Q08_14;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int n, m, len, answer = Integer.MAX_VALUE;
    static int[] combi;
    static List<Point> pz, hs;

    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        pz = new ArrayList<>();
        hs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = in.nextInt();
                if (tmp == 1)
                    hs.add(new Point(i, j));
                else if (tmp == 2)
                    pz.add(new Point(i, j));
            }
        }
        len = pz.size();
        combi = new int[m];
        main.DFS(0, 0);
        System.out.println(answer);
    }

    private void DFS(int L, int s) {
        if (L == m) {
            int sum = 0;
            for (Point h : hs) {
                int dis = Integer.MAX_VALUE;
                for (int i : combi) {
                    Point p = pz.get(i);
                    dis = Math.min(dis, Math.abs(p.getX() - h.getX()) + Math.abs(p.getY() - h.getY()));
                }
                sum += dis;
            }
            answer = Math.min(answer, sum);
        } else {
            for (int i = s; i < len; i++) {
                combi[L] = i;
                DFS(L + 1, i + 1);
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
