package Q10.Q10_02;

import java.util.Scanner;

public class Main {
    private int[] dy;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Main main = new Main();
        int answer = main.solution(n);
        System.out.println(answer);
    }

    public int solution(int n) {
        dy = new int[n + 2];
        dy[1] = 1;
        dy[2] = 2;
        for (int i = 3; i <= n + 1; i++) {
            dy[i] = dy[i - 2] + dy[i - 1];
        }
        return dy[n + 1];
    }

}
