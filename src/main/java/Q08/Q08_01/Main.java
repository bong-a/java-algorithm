package Q08.Q08_01;

import java.util.Scanner;

public class Main {
    static int n;
    static int[] index;
    static int[] arr;

    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        index = new int[n + 1];
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(main.DFS(1));
    }

    private String DFS(int m) {
        if (m == n + 1) {
            int nSum = 0;
            int mSum = 0;
            for (int i = 1; i < index.length; i++) {
                if (index[i] == 0) {
                    nSum += arr[i];
                } else {
                    mSum += arr[i];
                }
            }
            if (nSum == mSum) {
                return "YES";
            }
        } else {
            index[m] = 1;
            String a = DFS(m + 1);
            if ("NO".equals(a)) {
                index[m] = 0;
                return DFS(m + 1);
            } else {
                return a;
            }
        }
        return "NO";
    }
}
