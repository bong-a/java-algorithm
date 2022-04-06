package Q10.Q10_01;

import java.util.Scanner;

public class Main2 {
    private int[] dy;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Main2 main = new Main2();
        int answer = main.solution(n);
        System.out.println(answer);
    }

    public int solution(int n) {
        dy = new int[n + 1];
        dy[1] = 1;
        dy[2] = 2;

        for (int i = 3; i <= n; i++) {
            dy[i] = dy[i - 2] + dy[i - 1];
        }
        return dy[n];
    }

}
