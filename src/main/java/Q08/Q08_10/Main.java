package Q08.Q08_10;

import java.util.Scanner;

public class Main {
    static int[][] map, ch;
    static int cnt;

    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);

        map = new int[8][8];
        ch = new int[8][8];
        for (int i = 1; i < 8; i++) {
            for (int j = 1; j < 8; j++) {
                map[i][j] = in.nextInt();
            }
        }
        main.DFS(1, 1);
        System.out.println(cnt);
    }

    private void DFS(int x, int y) {
        if (x == 0 || y == 0) {
            return;
        }
        if (map[x][y] == 1) {
            return;
        }
        if (x == 7 && y == 7) {
            cnt++;
        } else {
            ch[x][y] = 1;
            if (ch[x - 1][y] == 0) {
                DFS(x - 1, y);
            }
            if (x + 1 <= 7 && ch[x + 1][y] == 0) {
                DFS(x + 1, y);
            }
            if (ch[x][y - 1] == 0) {
                DFS(x, y - 1);
            }
            if (y + 1 <= 7 && ch[x][y + 1] == 0) {
                DFS(x, y + 1);
            }
            ch[x][y] = 0;
        }
    }
}
