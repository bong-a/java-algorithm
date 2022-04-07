package Q10.Q10_05;

import java.util.Scanner;

public class Main {
    static int[] dy;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = in.nextInt();
        }
        int m = in.nextInt();
        Main main = new Main();
        int answer = main.solution(coin, m);
        System.out.println(answer);
    }

    private int solution(int[] coin, int m) {
        dy = new int[m+1];

        for (int i = 0; i < dy.length; i++) {
            dy[i] = i;
        }

        for (int i = 0; i < coin.length; i++) {
            int c = coin[i];
            for (int j = c; j < dy.length; j++) {
                int n = dy[j - c] + 1;
                if (dy[j] > n) {
                    dy[j] = n;
                }
            }
        }
        return dy[dy.length - 1];
    }
}
