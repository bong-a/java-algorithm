package Q02.Q02_10;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main main = new Main();
        int count = in.nextInt();
        System.out.println(main.solution(count, in));
    }

    public int solution(int count, Scanner in) {
        int[][] map = new int[count + 2][count + 2];
        for (int i = 1; i <= count; i++) {
            for (int j = 1; j <= count; j++) {
                map[i][j] = in.nextInt();
            }
        }

        int rs = 0;
        for (int i = 1; i <= count; i++) {
            for (int j = 1; j <= count; j++) {
                int n = map[i][j];
                if (n > map[i][j - 1] && n > map[i - 1][j] && n > map[i + 1][j] && n > map[i][j + 1]) {
                    rs++;
                }
            }
        }
        return rs;
    }
}
