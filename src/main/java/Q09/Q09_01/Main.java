package Q09.Q09_01;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        System.out.println(main.solution(arr));
    }

    private int solution(int[][] arr) {
        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            int[] n = arr[i];
            boolean win = true;
            for (int j = 0; j < arr.length; j++) {
                if (i == j) {
                    continue;
                }
                int[] m = arr[j];
                if (n[0] < m[0] && n[1] < m[1]) {
                    win = false;
                }
            }
            if (win) {
                answer++;
            }
        }
        return answer;
    }
}
