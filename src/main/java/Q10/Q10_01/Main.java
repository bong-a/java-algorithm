package Q10.Q10_01;

import java.util.Scanner;

public class Main {
    private int[][] dy;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Main main = new Main();
        int answer = main.solution(n);
        System.out.println(answer);
    }

    public int solution(int n) {
        dy = new int[n+1][n+1];
        int twoNum = n / 2;
        int sum = 0;
        for (int i = 0; i <= twoNum; i++) {
            int one = n - (i * 2);
            int two = i;
            int m = one + two;
            int min = Math.min(one, two);
            int cnt = combi(m, min);
            //System.out.println("2 step : " + two + ", 1 step : " + one + " -> " + cnt);
            sum += cnt;
        }
        return sum;
    }

    private int combi(int n, int r) {
        if (dy[n][r] > 0)
            return dy[n][r];
        if (n == r || r == 0)
            return 1;
        else
            return dy[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
    }
}
