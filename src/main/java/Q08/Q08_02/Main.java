package Q08.Q08_02;

import java.util.Scanner;

public class Main {
    static int maxWeight;
    static int n;
    static int max;
    static int[] index;
    static int[] arr;

    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        maxWeight = in.nextInt();
        n = in.nextInt();

        index = new int[n + 1];
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = in.nextInt();
        }
        main.DFS(1);
        System.out.println(max);
    }

    private void DFS(int m) {
        if (m == n + 1) {
            int sum = 0;
            for (int i = 1; i < index.length; i++) {
                if (index[i] == 1) {
                    sum += arr[i];
                }
            }
            if (maxWeight > sum) {
                max = Math.max(max, sum);
            }
        } else {
            index[m] = 1;
            DFS(m + 1);
            index[m] = 0;
            DFS(m + 1);
        }
    }
}
