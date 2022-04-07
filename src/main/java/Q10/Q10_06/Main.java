package Q10.Q10_06;

import java.util.Scanner;

public class Main {
    static int[] dy;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int min = in.nextInt();

        int[][] arr = new int[n][2];
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = in.nextInt();
            arr[i][1] = in.nextInt();
        }
        Main main = new Main();
        int a = main.solution(arr, min);
        System.out.println(a);

    }

    private int solution(int[][] arr, int min) {
        dy = new int[min + 1];
        for (int i = 0; i < arr.length; i++) {
            for (int j = min; j >= arr[i][1]; j--) {
                int n = dy[j - arr[i][1]] + arr[i][0];
                dy[j] = Math.max(dy[j], n);
            }
        }
        return dy[min];
    }
}
