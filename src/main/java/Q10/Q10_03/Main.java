package Q10.Q10_03;

import java.util.Scanner;

public class Main {
    private static int[] dy;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        dy = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        Main main = new Main();
        int rs = main.solution(arr);
        System.out.println(rs);

    }

    private int solution(int[] arr) {
        int answer = 0;
        dy[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            int maxLen = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i] && dy[j] > maxLen) {
                    maxLen = dy[j];
                }
            }
            dy[i] = maxLen + 1;
            answer = Math.max(answer, dy[i]);
        }
        return answer;
    }
}
